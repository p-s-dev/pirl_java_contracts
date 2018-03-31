package com.psdev.pirl.registration;

import org.junit.Test;

public class InvestorExitIT extends BaseNodeRegistrationServiceIT {

    @Test
    public void exit() throws Exception {
        setupMasternode();
        sharingService.withdrawForUser(0);

    }
}
