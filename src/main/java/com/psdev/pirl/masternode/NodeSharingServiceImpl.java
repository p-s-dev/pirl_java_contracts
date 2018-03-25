package com.psdev.pirl.masternode;

import com.psdev.pirl.contracts.generated.RewardSplitter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.tx.Contract;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;
import static org.web3j.crypto.RawTransaction.createContractTransaction;
import static org.web3j.crypto.TransactionEncoder.signMessage;
import static org.web3j.utils.Numeric.toHexString;

@Slf4j
@Service
public class NodeSharingServiceImpl extends AbstractContractService implements NodeSharingService {

    private RewardSplitter rewardSplitter;
    private static final String BINARY = RewardSplitter.load(null,null,
                    Credentials.create("0"), ZERO, ZERO).getContractBinary();

    @Override
    public void deposit() {
    }

    @Override
    public void withdraw() {
    }

    protected Contract deployContract() throws Exception {

        Credentials admin = userCredentialsManager.getAdmin();

        BigInteger nonce = getNonce(admin.getAddress());
        RawTransaction rawTransaction =
                createContractTransaction(nonce, gasPrice, gasLimit, ZERO, BINARY);
        String transactionHash = sendRawTransaction(toHexString(signMessage(rawTransaction, admin)));
        String contractAddress = getTransactionReceipt(transactionHash).getContractAddress();

        rewardSplitter = RewardSplitter.load(contractAddress, web3j, admin, gasPrice, gasLimit);
        log.info("contractAddress=" + rewardSplitter.getContractAddress());
        log.info("rewardSplitter.isValid=" + rewardSplitter.isValid());
        if (!rewardSplitter.isValid()) {
            throw new RuntimeException("Contract not valid");
        }
        return rewardSplitter;
    }

}
