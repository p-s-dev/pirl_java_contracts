package com.psdev.pirl.masternode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.BigInteger;

@Service
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

    @PostConstruct
    public void init() {
        transfer = new Transfer(web3j, new RawTransactionManager(web3j, userCredentialsManager.getPayer()));
    }

    public void pay(String payToAddress, BigDecimal amount, Convert.Unit unit) throws Exception {
        transfer.sendFunds(payToAddress, amount, unit, gasPrice, payerGasProvided).send();
    }
}
