package com.psdev.pirl.masternode;

import com.psdev.pirl.contracts.generated.PirlMasternodeDeposit;
import com.psdev.pirl.contracts.generated.RewardSplitter;
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
public class NodeSharingServiceImpl extends AbstractContractService implements NodeSharingService {

    @Autowired
    NodeRegistrationService nodeRegistrationService;

    @Autowired
    ContractLoader contractLoader;

    private RewardSplitter rewardSplitter;
    private BigInteger depositAmountWei;
    private BigInteger maxInvestors;

    @Override
    public RewardSplitter getRewardSplitter() throws Exception {
        isTrue(contractDeployed(), "Error deploying contract");
        return rewardSplitter;
    }

    @Override
    public void registerForUser(int userId) throws Exception {
        isTrue(contractDeployed(), "Error deploying contract");

        RewardSplitter userContract = getContractAuthorizedForUser(userId);

        BigInteger investorCount = userContract.getInvestorCount().send();
        if (investorCount.equals(maxInvestors)) {
            throw new RuntimeException("Registration is full, not accepting new investors.");
        }

        Boolean isRegistrationEnabled = nodeRegistrationService.isNodeRegistrationEnabled();
        if (!isRegistrationEnabled) {
            throw new RuntimeException("Do not register to a split contract unless registration contract enabled.");
        }

        BigInteger userBalance =
                web3j.ethGetBalance(userCredentialsManager.getUserAddress(userId),
                        DefaultBlockParameterName.LATEST).send().getBalance();

        if (userBalance.compareTo(depositAmountWei) < 0) {
            throw new RuntimeException("User does not have enough wei to register.");
        }

        userContract.register(depositAmountWei).send();
    }

    @Override
    public void withdrawForUser(int userId) throws Exception {
        isTrue(contractDeployed(), "Error deploying contract");
        RewardSplitter userContract = getContractAuthorizedForUser(userId);
        userContract.withdraw().send();
    }

    @Override
    public String getInvestorAddress(BigInteger investorId) throws Exception {
        isTrue(contractDeployed(), "Error deploying contract");
        return rewardSplitter.investors(investorId).send();
    }

    @Override
    public BigInteger getBalance() throws Exception {
        isTrue(contractDeployed(), "Error deploying contract");
        return web3j.ethGetBalance(rewardSplitter.getContractAddress(),
                DefaultBlockParameterName.LATEST).send().getBalance();
    }


    protected Contract deployContract() throws Exception {

        PirlMasternodeDeposit pirlMasternodeDeposit = nodeRegistrationService.enableNodeRegistration();
        contract = contractLoader.loadRewardSplitterContract(pirlMasternodeDeposit.getContractAddress());
        rewardSplitter = (RewardSplitter)contract;

        // TODO more verifications of correct initialization

        depositAmountWei = rewardSplitter.investorDeposit().send();
        maxInvestors = rewardSplitter.NUM_PARTICIPANTS().send();

        log.info("contractAddress=" + rewardSplitter.getContractAddress());
        log.info("rewardSplitter.isValid=" + rewardSplitter.isValid());
        if (!rewardSplitter.isValid()) {
            throw new RuntimeException("Contract not valid");
        }
        return rewardSplitter;
    }

    private RewardSplitter getContractAuthorizedForUser(int userNumber) throws Exception {

        RewardSplitter userContract =
                RewardSplitter.load(
                        contractAddress(), web3j, userCredentialsManager.getUser(userNumber),
                        gasPrice, gasLimit);
        log.info("userContract.isValid=" + userContract.isValid());

        return userContract;
    }

}
