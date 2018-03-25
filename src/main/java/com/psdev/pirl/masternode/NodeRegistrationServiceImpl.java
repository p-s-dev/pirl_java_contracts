package com.psdev.pirl.masternode;

import com.psdev.pirl.contracts.generated.PirlMasternodeDeposit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.tx.Contract;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;
import static org.springframework.util.Assert.isTrue;
import static org.web3j.crypto.RawTransaction.createContractTransaction;
import static org.web3j.crypto.TransactionEncoder.signMessage;
import static org.web3j.utils.Numeric.toHexString;

@Slf4j
@Service
public class NodeRegistrationServiceImpl extends AbstractContractService implements NodeRegistrationService {

    @Value("${contract.bin.masternode.deploy.smalldeposit}")
    String contractBin;

    private PirlMasternodeDeposit pirlMasternodeDeposit;
    private BigInteger nodeRegistrationCost;

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


    protected Contract deployContract() throws Exception {

        Credentials admin = userCredentialsManager.getAdmin();

        BigInteger nonce = getNonce(admin.getAddress());
        RawTransaction rawTransaction = createContractTransaction(nonce, gasPrice, gasLimit, ZERO, contractBin);
        String transactionHash = sendRawTransaction(toHexString(signMessage(rawTransaction, admin)));
        String contractAddress = getTransactionReceipt(transactionHash).getContractAddress();

        pirlMasternodeDeposit = PirlMasternodeDeposit.load(contractAddress, web3j, admin, gasPrice, gasLimit);
        log.info("pirlMasternodeDeposit=" + pirlMasternodeDeposit.getContractAddress());
        log.info("pirlMasternodeDeposit.isValid=" + pirlMasternodeDeposit.isValid());
        if (!pirlMasternodeDeposit.isValid()) {
            throw new RuntimeException("Contract pirlMasternodeDeposit not valid");
        }

        nodeRegistrationCost = pirlMasternodeDeposit.nodeCost().send();
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
