package com.psdev.pirl.masternode.events;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.psdev.pirl.masternode.loader.ContractLoader;
import com.psdev.pirl.masternode.loader.UserCredentialsManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetCode;

import java.util.Set;

@Service
@Slf4j
@ConditionalOnProperty("listener.payments")
public class PaymentListener {

    @Autowired
    Web3j web3j;

    @Autowired
    UserCredentialsManager userCredentialsManager;

    @Autowired
    ContractLoader contractLoader;

    @Autowired
    NodeRegistrationListener nodeRegistrationListener;

    private static final long DAY = 86400000l;
    private static final long PER_HOUR = 3600000l;
    public static final long BLOCK_CHECK_DELAY = 30000; // 30 secondns
    public static final long STARTUP_DELAY = 5000; // 30 secondns

    Multimap<String, SimpleMasternodeTransaction> masternodePaymentTransactions =
        Multimaps.synchronizedListMultimap(MultimapBuilder.linkedHashKeys().arrayListValues().build());

    public void checkMasternodePaymentTransactions() throws Exception {
        Set<String> activeMasternodes = nodeRegistrationListener.getActiveMasternodes();

        final String PAYER = userCredentialsManager.getPayerAddress();
        final DefaultBlockParameter START =
                DefaultBlockParameter.valueOf(contractLoader.getPirlMasternodeDepositCreationBlock());

        if (activeMasternodes.size() == 0) {
            log.info("waiting for active masternode list");
            return;
        }

        for (String masternode : activeMasternodes) {
            EthGetCode ethGetCode = web3j.ethGetCode(masternode, DefaultBlockParameterName.LATEST).send();
            String code = ethGetCode.getCode();
            log.info("ActiveMasternodeAddress=" + masternode + " addressCode=" + code);
        }

    }

}
