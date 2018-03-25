package com.psdev.pirl;

import com.psdev.pirl.contracts.generated.RewardSplitter;
import com.psdev.pirl.masternode.NodeRegistrationService;
import com.psdev.pirl.masternode.NodeSharingService;
import com.psdev.pirl.masternode.UserCredentialsManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.web3j.protocol.Web3j;

import java.math.BigInteger;

@Slf4j
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
    UserCredentialsManager userCredentialsManager;

    RewardSplitter rewardSplitterContract;

    @Before
    public void setUp() throws Exception {
        rewardSplitterContract = sharingService.getRewardSplitter();
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

    }

    // test if the same address registers twice
    public void testSomething() {

    }

}
