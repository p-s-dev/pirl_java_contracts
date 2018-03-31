package com.psdev.pirl.registration;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.web3j.utils.Convert.Unit.ETHER;

public class PayInvestorsIT extends BaseNodeRegistrationServiceIT {

    @Test
    public void pay() throws Exception {
        setupMasternode();

        // pay the splitter contract
        BigInteger userBalBeforePayment = userCredentialsManager.getUserBalance(0);
        BigInteger operatorBalBeforePayment = userCredentialsManager.getOperatorBalance();
        payerService.pay(rewardSplitterContractAddress, BigDecimal.valueOf(4.0), ETHER);
        verifyPaymentChangedBalances(userBalBeforePayment, operatorBalBeforePayment);
    }
}
