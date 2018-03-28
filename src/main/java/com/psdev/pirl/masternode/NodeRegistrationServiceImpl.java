package com.psdev.pirl.masternode;

import com.psdev.pirl.contracts.generated.PirlMasternodeDeposit;
import com.psdev.pirl.masternode.events.NodeRegistrationListener;
import com.psdev.pirl.masternode.loader.ContractLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.tx.Contract;

import java.math.BigInteger;

import static org.springframework.util.Assert.isTrue;

@Slf4j
@Service
public class NodeRegistrationServiceImpl extends AbstractContractService implements NodeRegistrationService {

    @Autowired
    ContractLoader contractLoader;

    @Autowired
    NodeRegistrationListener eventListener;

    private PirlMasternodeDeposit pirlMasternodeDeposit;
    private BigInteger nodeRegistrationCost;

//    @EventListener
//    public void onApplicationEvent(ContextRefreshedEvent event) throws Exception {
//        enableNodeRegistration();
//    }

    @Override
    public PirlMasternodeDeposit enableNodeRegistration() throws Exception {
        isTrue(contractDeployed(pirlMasternodeDeposit), "Error deploying pirlMasternodeDeposit contract");

        Boolean isEnabled = pirlMasternodeDeposit.nodeRegistrationEnabled().send();
        if (!isEnabled) {
            log.info("isRegistrationEnabled=" + pirlMasternodeDeposit.nodeRegistrationEnabled().send());
            pirlMasternodeDeposit.enableNodeRegistration().send();
            log.info("isRegistrationEnabled=" + pirlMasternodeDeposit.nodeRegistrationEnabled().send());
        } else {
            log.info("pirlMasternodeDeposit already enabled");
        }
        return pirlMasternodeDeposit;
    }

    @Override
    public void registerNodeForUser(int userId) throws Exception {
        isTrue(contractDeployed(pirlMasternodeDeposit), "Error deploying pirlMasternodeDeposit contract");

        String userAddress = userCredentialsManager.getUserAddress(userId);

        log.info("userId=" + userId + " isNodeEnabled=" + pirlMasternodeDeposit.nodes(userAddress).send().getValue5());
        getContractAuthorizedForUser(userId).nodeRegistration(nodeRegistrationCost).send();
        log.info("userId=" + userId + " isNodeEnabled=" + pirlMasternodeDeposit.nodes(userAddress).send().getValue5());
    }

    @Override
    public BigInteger getNodeCount() throws Exception {
        isTrue(contractDeployed(pirlMasternodeDeposit), "Error deploying pirlMasternodeDeposit contract");

        return pirlMasternodeDeposit.nodeCount().send();
    }

    @Override
    public BigInteger getNodeCost() throws Exception {
        isTrue(contractDeployed(pirlMasternodeDeposit), "Error deploying pirlMasternodeDeposit contract");
        return pirlMasternodeDeposit.nodeCost().send();
    }

    @Override
    public Boolean isNodeRegistrationEnabled() throws Exception {
        isTrue(contractDeployed(pirlMasternodeDeposit), "Error deploying pirlMasternodeDeposit contract");
        return pirlMasternodeDeposit.nodeRegistrationEnabled().send();
    }

    @Override
    public BigInteger getBalance() throws Exception {
        isTrue(contractDeployed(pirlMasternodeDeposit), "Error deploying contract");
        return web3j.ethGetBalance(pirlMasternodeDeposit.getContractAddress(),
                        DefaultBlockParameterName.LATEST).send().getBalance();
    }

    @Override
    public void startEventListener() throws Exception {
//        eventListener.start();

    }


    protected Contract deployContract() throws Exception {
        pirlMasternodeDeposit = contractLoader.loadPirlMasternodeDeposit();

        log.info("pirlMasternodeDeposit=" + pirlMasternodeDeposit.getContractAddress());
        log.info("pirlMasternodeDeposit.isValid=" + pirlMasternodeDeposit.isValid());
        if (!pirlMasternodeDeposit.isValid()) {
            throw new RuntimeException("Contract pirlMasternodeDeposit not valid");
        }

        nodeRegistrationCost = pirlMasternodeDeposit.nodeCost().send();
        startEventListener();
        return pirlMasternodeDeposit;
    }

    private PirlMasternodeDeposit getContractAuthorizedForUser(int userNumber) throws Exception {

        PirlMasternodeDeposit userContract =
                PirlMasternodeDeposit.load(
                        contractAddress(pirlMasternodeDeposit), web3j, userCredentialsManager.getUser(userNumber),
                        gasPrice, gasLimit);
        log.info("userContract.isValid=" + userContract.isValid());

        return userContract;
    }

}
