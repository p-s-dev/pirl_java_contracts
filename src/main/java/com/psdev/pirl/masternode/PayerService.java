package com.psdev.pirl.masternode;

import com.psdev.pirl.masternode.loader.UserCredentialsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
@Profile({"dev", "ropsten"})
public class PayerService {

    @Autowired
    BigInteger gasPrice;

    @Autowired
    BigInteger payerGasProvided;

    @Autowired
    Web3j web3j;

    @Autowired
    UserCredentialsManager userCredentialsManager;

    private Transfer transfer;

    public void pay(String payToAddress, BigDecimal amount, Convert.Unit unit) throws Exception {
        if (transfer == null) {
            init();
        }
        transfer.sendFunds(payToAddress, amount, unit, gasPrice, payerGasProvided).send();
    }

    private void init() {
        transfer = new Transfer(web3j, new RawTransactionManager(web3j, userCredentialsManager.getPayer()));
    }

}
