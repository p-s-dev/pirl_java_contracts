package com.psdev.pirl;

import com.psdev.pirl.contracts.generated.RewardSplitter;
import com.psdev.pirl.masternode.NodeRegistrationService;
import com.psdev.pirl.masternode.NodeSharingService;
import com.psdev.pirl.masternode.PayerService;
import com.psdev.pirl.masternode.loader.testrpc.TestRpcUserCredentialsManagerImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.web3j.protocol.Web3j;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.web3j.utils.Convert.Unit.ETHER;

@Slf4j
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NodeRegistrationServiceIT {

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
        rewardSplitterContract = sharingService.getRewardSplitter();
        rewardSplitterContractAddress = rewardSplitterContract.getContractAddress();
    }

//    @Test
//    public void canDeployAndRegister() throws Exception {
//
//        contractService.enableNodeRegistration();
//
//        contractService.registerNodeForUser(0);
//        contractService.registerNodeForUser(1);
//        contractService.registerNodeForUser(2);
//        log.info("nodeCount=" + contractService.getNodeCount());
//
//        Assert.assertTrue(BigInteger.valueOf(3).equals(contractService.getNodeCount()));
//
//    }

    @Test
    public void canShareReward() throws Exception {

        sharingService.registerForUser(0);
        sharingService.registerForUser(1);
        sharingService.registerForUser(2);

        BigInteger regBalBeforeLastRegister = registrationService.getBalance();
        Assert.assertTrue("reg contract before last user reg should be 0",
                regBalBeforeLastRegister.equals(new BigInteger("0")));

        BigInteger balBeforeLastRegister = sharingService.getBalance();
        Assert.assertTrue("splitter contract before last user reg should be 1500000000000000000",
                balBeforeLastRegister.equals(new BigInteger("1500000000000000000")));

        sharingService.registerForUser(3);

        BigInteger regBalAfterLastRegister = registrationService.getBalance();
        Assert.assertTrue("reg contract before last user reg should be 2000000000000000000",
                regBalAfterLastRegister.equals(new BigInteger("2000000000000000000")));

        BigInteger balAfterLastRegister = sharingService.getBalance();
        Assert.assertTrue("reg contract before last user reg should be 0",
                balAfterLastRegister.equals(new BigInteger("0")));

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

        BigInteger userBalBeforePayment = userCredentialsManager.getUserBalance(0);
//        log.info("user balance before payment=" + userBalBeforePayment);

        BigInteger operatorBalBeforePayment = userCredentialsManager.getOperatorBalance();
//        log.info("operator balance before payment=" + operatorBalBeforePayment);

        payerService.pay(rewardSplitterContractAddress, BigDecimal.valueOf(4.0), ETHER);
//        log.info("user balance after  payment=" + userCredentialsManager.getUserBalance(0));
//        log.info("operator balance after  payment=" + userCredentialsManager.getOperatorBalance());

        Assert.assertTrue(
                "user balance should have changed",
                !userBalBeforePayment.equals(userCredentialsManager.getUserBalance(0)));
        Assert.assertTrue(
                "operator balance should have changed",
                !userBalBeforePayment.equals(userCredentialsManager.getOperatorBalance()));

        sharingService.withdrawForUser(0);


    }

    // test if the same address registers twice
    public void testSomething() {

    }

}
