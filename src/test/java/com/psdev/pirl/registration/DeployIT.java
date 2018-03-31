package com.psdev.pirl.registration;

import com.psdev.pirl.contracts.generated.RewardSplitter;
import org.junit.Assert;
import org.junit.Test;

public class DeployIT extends BaseNodeRegistrationServiceIT {

    @Test
    public void deploy() throws Exception {
        RewardSplitter splitterContract = sharingService.getRewardSplitter();
        Assert.assertNotNull(splitterContract.investorDeposit().send());
        Assert.assertNotNull(splitterContract.lastPayTimestamp().send());
        Assert.assertNotNull(splitterContract.operatorAddress().send());
        Assert.assertNotNull(splitterContract.payerAddress().send());
        Assert.assertNotNull(splitterContract.registrationContract().send());
    }
}
