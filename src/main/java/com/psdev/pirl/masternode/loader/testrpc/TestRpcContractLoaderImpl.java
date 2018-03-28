package com.psdev.pirl.masternode.loader.testrpc;

import com.psdev.pirl.contracts.generated.PirlMasternodeDeposit;
import com.psdev.pirl.contracts.generated.RewardSplitter;
import com.psdev.pirl.masternode.loader.ContractLoader;
import com.psdev.pirl.masternode.loader.UserCredentialsManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
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
import static org.web3j.crypto.RawTransaction.createContractTransaction;
import static org.web3j.crypto.TransactionEncoder.signMessage;
import static org.web3j.protocol.core.DefaultBlockParameterName.LATEST;
import static org.web3j.utils.Numeric.toHexString;

@Service
@Slf4j
@Profile("dev")
public class TestRpcContractLoaderImpl implements ContractLoader {
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

    @Override
    public PirlMasternodeDeposit loadPirlMasternodeDeposit() throws ExecutionException, InterruptedException, IOException {
        Credentials admin = userCredentialsManager.getAdmin();

        BigInteger nonce = getNonce(admin.getAddress());
        RawTransaction rawTransaction = createContractTransaction(nonce, gasPrice, gasLimit, ZERO, contractBin);
        String transactionHash = sendRawTransaction(toHexString(signMessage(rawTransaction, admin)));
        String contractAddress = getTransactionReceipt(transactionHash).getContractAddress();
        return PirlMasternodeDeposit.load(contractAddress, web3j, admin, gasPrice, gasLimit);

    }

    @Override
    public BigInteger getPirlMasternodeDepositCreationBlock() {
        return BigInteger.ZERO;
    }

    @Override
    public RewardSplitter loadRewardSplitterContract(String pirlMasternodeDepositAddress) throws Exception {
        Credentials admin = userCredentialsManager.getAdmin();

        return RewardSplitter.deploy(
                web3j,
                admin,
                gasPrice,
                gasLimit,
                userCredentialsManager.getPayer().getAddress(),
                userCredentialsManager.getOperator().getAddress(),
                pirlMasternodeDepositAddress).send();

    }


    protected BigInteger getNonce(String address) throws ExecutionException, InterruptedException {
        String adminAddress = userCredentialsManager.getAdmin().getAddress();

        EthGetTransactionCount ethGetTransactionCount =
                web3j.ethGetTransactionCount(adminAddress, LATEST).sendAsync().get();

        BigInteger nonce = ethGetTransactionCount.getTransactionCount();
        log.info("Address=" + address + " Nonce=" + nonce);
        return nonce;
    }

    protected String sendRawTransaction(String hexValue) throws ExecutionException, InterruptedException {
        EthSendTransaction ethSendTransaction = web3j.ethSendRawTransaction(hexValue).sendAsync().get();

        if (ethSendTransaction.hasError()) {
            Response.Error e = ethSendTransaction.getError();
            log.error(e.getMessage() + "\n" + e.getData());
            throw new RuntimeException("Error when creating contract");
        }

        return ethSendTransaction.getTransactionHash();
    }

    protected TransactionReceipt getTransactionReceipt(String transactionHash) throws IOException {

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
}
