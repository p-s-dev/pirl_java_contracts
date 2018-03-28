package com.psdev.pirl.masternode.events;

import lombok.ToString;
import org.web3j.protocol.core.methods.response.Transaction;

import java.math.BigInteger;

@ToString
public class SimpleMasternodeTransaction {

    BigInteger blockNumber;
    BigInteger value;
    String creates;

    public SimpleMasternodeTransaction(Transaction transaction) {
        blockNumber = transaction.getBlockNumber();
        value = transaction.getValue();
        creates = transaction.getCreates();
    }
}
