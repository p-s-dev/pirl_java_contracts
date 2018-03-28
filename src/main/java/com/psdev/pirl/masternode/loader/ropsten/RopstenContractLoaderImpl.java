package com.psdev.pirl.masternode.loader.ropsten;

import com.psdev.pirl.contracts.generated.PirlMasternodeDeposit;
import com.psdev.pirl.contracts.generated.RewardSplitter;
import com.psdev.pirl.masternode.loader.ContractLoader;
import com.psdev.pirl.masternode.loader.UserCredentialsManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
@Profile("ropsten")
public class RopstenContractLoaderImpl implements ContractLoader {
    @Autowired
    Web3j web3j;

    @Autowired
    UserCredentialsManager userCredentialsManager;

    @Autowired
    BigInteger gasPrice;

    @Autowired
    BigInteger gasLimit;

    private static final String DEPOSIT_CONTRACT_ADDRESS = "0xD0dD0cdb81E03b6Be7c954A9Cd3A4A128eF84F83";
    private static final BigInteger DEPOSIT_CREATION_BLOCK =
            new BigInteger("2879576").subtract(BigInteger.ONE);

    private static final String SPLITTER_CONTRACT_ADDRESS = "0x72d2292FB10ad2BCB08F1fE16C898aC677c383E4";

    @Override
    public PirlMasternodeDeposit loadPirlMasternodeDeposit() throws ExecutionException, InterruptedException, IOException {
        Credentials admin = userCredentialsManager.getAdmin();
        return PirlMasternodeDeposit.load(DEPOSIT_CONTRACT_ADDRESS, web3j, admin, gasPrice, gasLimit);
    }

    @Override
    public BigInteger getPirlMasternodeDepositCreationBlock() {
        return DEPOSIT_CREATION_BLOCK;
    }

    @Override
    public RewardSplitter loadRewardSplitterContract(String pirlMasternodeDepositAddress) throws Exception {
        Credentials admin = userCredentialsManager.getAdmin();
        return RewardSplitter.load(SPLITTER_CONTRACT_ADDRESS, web3j, admin, gasPrice, gasLimit);
    }

}
