package com.psdev.pirl;

import com.psdev.pirl.masternode.events.PaymentListener;
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
public class PaymentListenerIT {

    @Autowired
    PaymentListener paymentListener;

    @Test
    public void testGetAllTransactions() throws Exception {
        paymentListener.checkMasternodePaymentTransactions();

    }

}
