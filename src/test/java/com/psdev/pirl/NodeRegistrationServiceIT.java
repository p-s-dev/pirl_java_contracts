package com.psdev.pirl;

import com.psdev.pirl.masternode.NodeRegistrationServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NodeRegistrationServiceIT {

    @Autowired
    NodeRegistrationServiceImpl contractService;

    @Test
    public void canDeployAndRegister() throws Exception {

        contractService.enableNodeRegistration();

        contractService.registerNodeForUser(0);
        contractService.registerNodeForUser(1);
        contractService.registerNodeForUser(2);
        log.info("nodeCount=" + contractService.getNodeCount());

        Assert.assertTrue(BigInteger.valueOf(3).equals(contractService.getNodeCount()));

    }
}
