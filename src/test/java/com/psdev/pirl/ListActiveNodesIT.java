package com.psdev.pirl;

import com.psdev.pirl.contracts.generated.PirlMasternodeDeposit;
import com.psdev.pirl.masternode.events.NodeStatusEvent;
import com.psdev.pirl.masternode.loader.ContractLoader;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import rx.Observable;
import rx.Subscription;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;

import static org.web3j.protocol.core.DefaultBlockParameterName.EARLIEST;
import static org.web3j.protocol.core.DefaultBlockParameterName.LATEST;

@Slf4j
@ActiveProfiles("akroma")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ListActiveNodesIT {

    private Map<String, NodeStatusEvent> nodeRegistrationStatus = new ConcurrentHashMap<>();
    private Set<String> activeMasternodes = new CopyOnWriteArraySet<String>();

    @Autowired
    ContractLoader contractLoader;

    @Test
    public void listActiveNodesTest() throws InterruptedException, ExecutionException, IOException {

        PirlMasternodeDeposit registrationContract = contractLoader.loadPirlMasternodeDeposit();

        Subscription subscription = Observable.merge(
                registrationContract.masterNodeEnabledEventObservable(EARLIEST, LATEST)
                        .map(NodeStatusEvent::new),
                registrationContract.masterNodeDisabledEventObservable(EARLIEST, LATEST)
                        .map(NodeStatusEvent::new),
                registrationContract.stakeWithdrawnEventObservable(EARLIEST, LATEST)
                        .map(NodeStatusEvent::new),
                registrationContract.masterNodeRegisteredEventObservable(EARLIEST, LATEST)
                        .map(NodeStatusEvent::new))
                .doOnNext(event -> {
                    String address = event.pirlAddress;
                    nodeRegistrationStatus.putIfAbsent(address, event);
                    NodeStatusEvent oldEvent = nodeRegistrationStatus.get(address);
                    if (!StringUtils.equals(oldEvent.uniqueLogHash, event.uniqueLogHash)) {
                        int compateDates = oldEvent.dateStatusChange.compareTo(event.dateStatusChange);
                        if (compateDates < 0) {
                            nodeRegistrationStatus.put(event.pirlAddress, event);
                        } else if (compateDates == 0) {
                            int compareTxnIndex = oldEvent.transactionIndex.compareTo(event.transactionIndex);
                            if (compareTxnIndex < 0) {
                                nodeRegistrationStatus.put(event.pirlAddress, event);
                            } else if (compareTxnIndex == 0) {
                                int compareLogIndex = oldEvent.logIndex.compareTo(event.logIndex);
                                if (compareLogIndex < 0) {
                                    nodeRegistrationStatus.put(event.pirlAddress, event);
                                } else if (compareLogIndex == 0) {
                                    throw new RuntimeException("same txn index and same log index?");
                                }
                            }
                        }
                    }
                }).subscribe();

        Set<String> active = new HashSet<>();
        for (Map.Entry<String, NodeStatusEvent> registration : nodeRegistrationStatus.entrySet()) {
            if (registration.getValue().nodeEnabled) {
                active.add(registration.getValue().pirlAddress);
            }
        }
        log.info("Registered=" + active.size());
        activeMasternodes.clear();
        activeMasternodes.addAll(active);
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
            log.info("unsubsubscribe: success=" + subscription.isUnsubscribed());
        }

        subscription.unsubscribe();


    }
}
