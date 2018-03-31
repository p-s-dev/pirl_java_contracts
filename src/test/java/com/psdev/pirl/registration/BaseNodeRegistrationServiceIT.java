package com.psdev.pirl.registration;

import com.psdev.pirl.contracts.generated.RewardSplitter;
import com.psdev.pirl.masternode.NodeRegistrationService;
import com.psdev.pirl.masternode.NodeRegistrationServiceImpl;
import com.psdev.pirl.masternode.NodeSharingService;
import com.psdev.pirl.masternode.NodeSharingServiceImpl;
import com.psdev.pirl.masternode.PayerService;
import com.psdev.pirl.masternode.loader.testrpc.TestRpcUserCredentialsManagerImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.web3j.protocol.Web3j;

import java.io.IOException;
import java.math.BigInteger;

@Slf4j
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract class BaseNodeRegistrationServiceIT {

    @Autowired
    Web3j web3j;

    @Autowired
    NodeRegistrationService registrationService;

    @Autowired
    NodeSharingService sharingService;

    @Autowired
    TestRpcUserCredentialsManagerImpl userCredentialsManager;

    @Autowired
    PayerService payerService;

    RewardSplitter rewardSplitterContract;
    String rewardSplitterContractAddress;

    @Before
    public void setUp() throws Exception {
        ((NodeRegistrationServiceImpl)registrationService).resetContract();
        ((NodeSharingServiceImpl)sharingService).resetContract();
        rewardSplitterContract = sharingService.getRewardSplitter();
        rewardSplitterContractAddress = rewardSplitterContract.getContractAddress();
    }

    protected void setupMasternode() throws Exception {
        // register 4 investors
        sharingService.registerForUser(0);
        sharingService.registerForUser(1);
        sharingService.registerForUser(2);
        verifyRegistrationBalanceBeforeLastInvestor(registrationService.getBalance());
        verifySharingBalanceBeforeLastInvestor(sharingService.getBalance());
        sharingService.registerForUser(3);
        verifyRegistrationBalanceAfterLastInvestor(registrationService.getBalance());
        verifySharingBalanceAfterLastInvestor(sharingService.getBalance());
        verifyInvestorAddresses();
    }

    protected void verifyPaymentChangedBalances(BigInteger userBalBeforePayment, BigInteger operatorBalBeforePayment) throws IOException {
        Assert.assertTrue(
                "user balance should have changed",
                !userBalBeforePayment.equals(userCredentialsManager.getUserBalance(0)));
        Assert.assertTrue(
                "operator balance should have changed",
                !operatorBalBeforePayment.equals(userCredentialsManager.getOperatorBalance()));
    }

    protected void verifyInvestorAddresses() throws Exception {
        Assert.assertEquals(
                "Registered user doesn't match shared investor",
                userCredentialsManager.getUser(0).getAddress(),
                sharingService.getInvestorAddress(new BigInteger("0")));

        Assert.assertEquals(
                "Registered user doesn't match shared investor",
                userCredentialsManager.getUser(1).getAddress(),
                sharingService.getInvestorAddress(new BigInteger("1")));

        Assert.assertEquals(
                "Registered user doesn't match shared investor",
                userCredentialsManager.getUser(2).getAddress(),
                sharingService.getInvestorAddress(new BigInteger("2")));

        Assert.assertEquals(
                "Registered user doesn't match shared investor",
                userCredentialsManager.getUser(3).getAddress(),
                sharingService.getInvestorAddress(new BigInteger("3")));

    }

    protected void verifySharingBalanceAfterLastInvestor(BigInteger balAfterLastRegister) {
        Assert.assertTrue("reg contract before last user reg should be 0",
                balAfterLastRegister.equals(new BigInteger("0")));

    }

    protected void verifyRegistrationBalanceAfterLastInvestor(BigInteger regBalAfterLastRegister) {
        Assert.assertTrue("reg contract before last user reg should be 2000000000000000000",
                regBalAfterLastRegister.equals(new BigInteger("2000000000000000000")));

    }

    protected void verifySharingBalanceBeforeLastInvestor(BigInteger balBeforeLastRegister) {
        Assert.assertTrue("splitter contract before last user reg should be 1500000000000000000",
                balBeforeLastRegister.equals(new BigInteger("1500000000000000000")));
    }

    protected void verifyRegistrationBalanceBeforeLastInvestor(BigInteger regBalBeforeLastRegister) {
        Assert.assertTrue("reg contract before last user reg should be 0",
                regBalBeforeLastRegister.equals(new BigInteger("0")));
    }

}
