package com.psdev.pirl.registration;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class RegisterIT extends BaseNodeRegistrationServiceIT {

    @Test
    public void register() throws Exception {
        setupMasternode();
        Assert.assertTrue(BigInteger.valueOf(4).equals(sharingService.getRewardSplitter().getInvestorCount().send()));
    }
}
