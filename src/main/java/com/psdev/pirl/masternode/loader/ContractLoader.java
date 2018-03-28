package com.psdev.pirl.masternode.loader;

import com.psdev.pirl.contracts.generated.PirlMasternodeDeposit;
import com.psdev.pirl.contracts.generated.RewardSplitter;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

public interface ContractLoader {
    PirlMasternodeDeposit loadPirlMasternodeDeposit() throws ExecutionException, InterruptedException, IOException;

    BigInteger getPirlMasternodeDepositCreationBlock();

    RewardSplitter loadRewardSplitterContract(String pirlMasternodeDepositAddress) throws Exception;
}
