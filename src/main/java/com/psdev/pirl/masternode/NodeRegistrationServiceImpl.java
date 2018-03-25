package com.psdev.pirl.masternode;

import com.psdev.pirl.contracts.generated.PirlMasternodeDeposit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
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

    private PirlMasternodeDeposit adminContract;
    private BigInteger nodeRegistrationCost;

    @Override
    public void enableNodeRegistration() throws Exception {
        isTrue(contractDeployed(adminContract), "Error deploying contract");

        log.info("isRegistrationEnabled=" + adminContract.nodeRegistrationEnabled().send());
        adminContract.enableNodeRegistration().send();
        log.info("isRegistrationEnabled=" + adminContract.nodeRegistrationEnabled().send());

    }

    @Override
    public void registerNodeForUser(int userId) throws Exception {
        isTrue(contractDeployed(adminContract), "Error deploying contract");

        String userAddress = userCredentialsManager.getUserAddress(userId);

        log.info("userId=" + userId + " isNodeEnabled=" + adminContract.nodes(userAddress).send().getValue5());
        getContractAuthorizedForUser(userId).nodeRegistration(nodeRegistrationCost).send();
        log.info("userId=" + userId + " isNodeEnabled=" + adminContract.nodes(userAddress).send().getValue5());
    }

    @Override
    public BigInteger getNodeCount() throws Exception {
        isTrue(contractDeployed(adminContract), "Error deploying contract");

        return adminContract.nodeCount().send();
    }


    protected Contract deployContract() throws Exception {

        Credentials admin = userCredentialsManager.getAdmin();

        BigInteger nonce = getNonce(admin.getAddress());
        RawTransaction rawTransaction = createContractTransaction(nonce, gasPrice, gasLimit, ZERO, contractBin);
        String transactionHash = sendRawTransaction(toHexString(signMessage(rawTransaction, admin)));
        String contractAddress = getTransactionReceipt(transactionHash).getContractAddress();

        adminContract = PirlMasternodeDeposit.load(contractAddress, web3j, admin, gasPrice, gasLimit);
        log.info("contractAddress=" + adminContract.getContractAddress());
        log.info("adminContract.isValid=" + adminContract.isValid());
        if (!adminContract.isValid()) {
            throw new RuntimeException("Contract not valid");
        }

        nodeRegistrationCost = adminContract.nodeCost().send();
        return adminContract;
    }

    private PirlMasternodeDeposit getContractAuthorizedForUser(int userNumber) throws Exception {

        PirlMasternodeDeposit userContract =
                PirlMasternodeDeposit.load(
                        contractAddress(adminContract), web3j, userCredentialsManager.getUser(userNumber),
                        gasPrice, gasLimit);
        log.info("userContract.isValid=" + userContract.isValid());

        return userContract;
    }

}
