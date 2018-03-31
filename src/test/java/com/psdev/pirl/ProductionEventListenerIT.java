package com.psdev.pirl;

import com.psdev.pirl.masternode.NodeRegistrationService;
import com.psdev.pirl.masternode.events.NodeRegistrationListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@ActiveProfiles("pirl")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductionEventListenerIT {

    @Autowired
    NodeRegistrationService registrationService;

    @Autowired
    NodeRegistrationListener nodeRegistrationListener;

    @Test
    public void testEventListener() throws Exception {

        registrationService.enableNodeRegistration();
        nodeRegistrationListener.getActiveMasternodes();

    }

}
