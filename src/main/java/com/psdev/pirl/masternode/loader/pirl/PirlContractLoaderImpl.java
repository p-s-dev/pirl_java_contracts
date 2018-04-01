package com.psdev.pirl.masternode.loader.pirl;

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
@Profile("pirl")
public class PirlContractLoaderImpl implements ContractLoader {
    @Autowired
    Web3j web3j;

    @Autowired
    UserCredentialsManager userCredentialsManager;

    @Autowired
    BigInteger gasPrice;

    @Autowired
    BigInteger gasLimit;

    private static final String DEPOSIT_CONTRACT_ADDRESS = "0x256b2b26Fe8eCAd201103946F8C603b401cE16EC";
    private static final String DEPOSIT_CONTRACT_ADDRESS_2PIRL = "0x7ca4b01f2dfdaae51be9ae476e9f21e19ee78ee3";
    private static final BigInteger DEPOSIT_CREATION_BLOCK =
            new BigInteger("442776").subtract(BigInteger.ONE);

    private static final String SPLITTER_CONTRACT_ADDRESS = "0xaf30e49541a1c2ff7f6f7cb797cca0d088e80129"; // constructor: "0xe2052723a18115a15fd985107f18c190347e5059","0x573e92262ff4971aaa15e3d045aca37d04ceeaa9","0x256b2b26Fe8eCAd201103946F8C603b401cE16EC"
    private static final String SPLITTER_CONTRACT_ADDRESS_2PIRL = "0xe476bad62cd14c2528d55d86100f4658e497a096"; // constructor: "0xBDEf849F7b6C94E560d5707a2E616cfdb940a04A","0xe4b78Bb7C20da0789918bE4B9D8fDa9afCC3d0e3","0x7ca4b01f2dfdaae51be9ae476e9f21e19ee78ee3"
    private static final String SPLITTER_CONTRACT_ADDRESS_2PIRL_v2 = "0x75dbe535ada026c1c20e60eafd13af2e31a78ba4"; // OPERATOR_STARTUP_DAYS=0
    private static final String SPLITTER_CONTRACT_ADDRESS_2PIRL_v3 = "0xa0438d9d3361ae430ef2329d4ab97af80f5e313f"; // OPERATOR_STARTUP_DAYS=0, OPERATOR_OFFLINE_FORGIVENESS_DAYS=0 constructor "0x1f822bc3ee9e515e85cf28a35be8ca56eb997465","0x573e92262ff4971aaa15e3d045aca37d04ceeaa9","0x7ca4b01f2dfdaae51be9ae476e9f21e19ee78ee3"

    @Override
    public PirlMasternodeDeposit loadPirlMasternodeDeposit() throws ExecutionException, InterruptedException, IOException {
        Credentials admin = userCredentialsManager.getAdmin();
        return PirlMasternodeDeposit.load(DEPOSIT_CONTRACT_ADDRESS_2PIRL, web3j, admin, gasPrice, gasLimit);
    }

    @Override
    public BigInteger getPirlMasternodeDepositCreationBlock() {
        return DEPOSIT_CREATION_BLOCK;
    }

    @Override
    public RewardSplitter loadRewardSplitterContract(String pirlMasternodeDepositAddress) throws Exception {
        Credentials admin = userCredentialsManager.getAdmin();
        return RewardSplitter.load(SPLITTER_CONTRACT_ADDRESS_2PIRL, web3j, admin, gasPrice, gasLimit);
    }

}
