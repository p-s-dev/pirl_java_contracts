package com.psdev.pirl.masternode;

import com.psdev.pirl.contracts.generated.PirlMasternodeDeposit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.Response;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

import static java.math.BigInteger.ZERO;
import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.StringUtils.isEmpty;
import static org.web3j.crypto.RawTransaction.createContractTransaction;
import static org.web3j.crypto.TransactionEncoder.signMessage;
import static org.web3j.protocol.core.DefaultBlockParameterName.LATEST;
import static org.web3j.utils.Numeric.toHexString;

@Slf4j
@Service
public class NodeRegistrationServiceImpl implements NodeRegistrationService {

    @Autowired
    Web3j web3j;

    @Autowired
    UserCredentialsManager userCredentialsManager;

    @Autowired
    BigInteger gasPrice;

    @Autowired
    BigInteger gasLimit;

    @Value("${contract.bin.masternode.deploy.smalldeposit}")
    String contractBin;

    private PirlMasternodeDeposit adminContract;
    private BigInteger nodeRegistrationCost;

    @Override
    public void enableNodeRegistration() throws Exception {
        isTrue(contractDeployed(), "Error deploying contract");

        log.info("isRegistrationEnabled=" + adminContract.nodeRegistrationEnabled().send());
        adminContract.enableNodeRegistration().send();
        log.info("isRegistrationEnabled=" + adminContract.nodeRegistrationEnabled().send());

    }

    @Override
    public void registerNodeForUser(int userId) throws Exception {
        isTrue(contractDeployed(), "Error deploying contract");

        String userAddress = userCredentialsManager.getUserAddress(userId);

        log.info("userId=" + userId + " isNodeEnabled=" + adminContract.nodes(userAddress).send().getValue5());
        getContractAuthorizedForUser(userId).nodeRegistration(nodeRegistrationCost).send();
        log.info("userId=" + userId + " isNodeEnabled=" + adminContract.nodes(userAddress).send().getValue5());
    }

    @Override
    public BigInteger getNodeCount() throws Exception {
        isTrue(contractDeployed(), "Error deploying contract");

        return adminContract.nodeCount().send();
    }


    private PirlMasternodeDeposit deployContract() throws Exception {

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
                PirlMasternodeDeposit.load(contractAddress(), web3j, userCredentialsManager.getUser(userNumber), gasPrice, gasLimit);
        log.info("userContract.isValid=" + userContract.isValid());

        return userContract;
    }


    private BigInteger getNonce(String address) throws ExecutionException, InterruptedException {
        String adminAddress = userCredentialsManager.getAdmin().getAddress();

        EthGetTransactionCount ethGetTransactionCount =
                web3j.ethGetTransactionCount(adminAddress, LATEST).sendAsync().get();

        BigInteger nonce = ethGetTransactionCount.getTransactionCount();
        log.info("Address=" + address + " Nonce=" + nonce);
        return nonce;
    }

    private String sendRawTransaction(String hexValue) throws ExecutionException, InterruptedException {
        EthSendTransaction ethSendTransaction = web3j.ethSendRawTransaction(hexValue).sendAsync().get();

        if (ethSendTransaction.hasError()) {
            Response.Error e = ethSendTransaction.getError();
            log.error(e.getMessage() + "\n" + e.getData());
            throw new RuntimeException("Error when creating contract");
        }

        return ethSendTransaction.getTransactionHash();
    }

    private TransactionReceipt getTransactionReceipt(String transactionHash) throws IOException {

        EthGetTransactionReceipt ethGetReceipt = web3j.ethGetTransactionReceipt(transactionHash).send();

        if (ethGetReceipt.hasError()) {
            Response.Error e = ethGetReceipt.getError();
            log.error(e.getMessage() + "\n" + e.getData());
            throw new RuntimeException("Error when getting transaction receipt");
        }

        if (ethGetReceipt.getTransactionReceipt().isPresent()) {
            return ethGetReceipt.getTransactionReceipt().get();
        } else {
            throw new RuntimeException("transaction receipt not available after sync call");
        }

    }

    private boolean contractDeployed() throws Exception {
        if (adminContract == null || isEmpty(contractAddress())) {
            deployContract();
        }

        return adminContract != null && !isEmpty(contractAddress());
    }

    private String contractAddress() {
        return adminContract.getContractAddress();
    }


}
