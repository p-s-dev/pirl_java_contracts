package com.psdev.pirl.masternode.tasks;

import com.psdev.pirl.masternode.events.NodeRegistrationListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;

import java.io.IOException;

@Slf4j
@ConditionalOnProperty("tasks.payer.enabled")
@Profile({"dev", "ropsten"})
public class PayerTask {

    @Autowired
    NodeRegistrationListener nodeRegistrationListener;

//    @Scheduled(initialDelay = 10000, fixedRate = 5000)
    public void testPayMasternodes() throws IOException {

        for (String nodeAddress : nodeRegistrationListener.getActiveMasternodes()) {

        }
    }





    private static final long DAY = 86400000l;
    private static final long PER_HOUR = 3600000l;

//    @Scheduled(initialDelay = DAY, fixedRate = PER_HOUR)
    public void payMasternodes() throws IOException {

        // get active masternodes

        // check last payment

        // check if some have been paid already

        // pay them


    }

}
