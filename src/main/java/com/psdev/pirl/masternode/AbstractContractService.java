package com.psdev.pirl.masternode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.Response;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

import static org.springframework.util.StringUtils.isEmpty;
import static org.web3j.protocol.core.DefaultBlockParameterName.LATEST;

@Service
@Slf4j
abstract class AbstractContractService {

    @Autowired
    Web3j web3j;

    @Autowired
    UserCredentialsManager userCredentialsManager;

    @Autowired
    BigInteger gasPrice;

    @Autowired
    BigInteger gasLimit;

    abstract Contract deployContract() throws Exception;

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

    protected boolean contractDeployed(Contract contract) throws Exception {
        if (contract == null || isEmpty(contractAddress(contract))) {
            contract = deployContract();
        }

        return contract != null && !isEmpty(contractAddress(contract));
    }

    protected String contractAddress(Contract contract) {
        return contract.getContractAddress();
    }

}
