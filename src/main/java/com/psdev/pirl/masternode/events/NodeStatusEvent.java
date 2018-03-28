package com.psdev.pirl.masternode.events;

import com.psdev.pirl.contracts.generated.PirlMasternodeDeposit.MasterNodeDisabledEventResponse;
import com.psdev.pirl.contracts.generated.PirlMasternodeDeposit.MasterNodeEnabledEventResponse;
import com.psdev.pirl.contracts.generated.PirlMasternodeDeposit.MasterNodeRegisteredEventResponse;
import com.psdev.pirl.contracts.generated.PirlMasternodeDeposit.StakeWithdrawnEventResponse;
import lombok.ToString;

import java.math.BigInteger;

@ToString
public class NodeStatusEvent {
    public String pirlAddress;
    public Boolean nodeEnabled;
    public BigInteger dateStatusChange;
    public String uniqueLogHash;
    public String type;
    public BigInteger transactionIndex;
    public BigInteger logIndex;

    public NodeStatusEvent(StakeWithdrawnEventResponse event) {
        nodeEnabled = false;

        pirlAddress = event._pirlAddress;
        dateStatusChange = event._dateWithdrawn;
        uniqueLogHash = event.log.getTransactionHash() + "-" +
                event.log.getTransactionIndexRaw() + "-" +
                event.log.getLogIndexRaw();
        type = "withdraw";
        transactionIndex = event.log.getTransactionIndex();
        logIndex = event.log.getLogIndex();

        if (event._stakeWithdrawn == false) {
            throw new RuntimeException("withdraw events contain false value");
        }
    }

    public NodeStatusEvent(MasterNodeRegisteredEventResponse event) {
        nodeEnabled = true;

        pirlAddress = event._pirlAddress;
        dateStatusChange = event._dateRegistered;
        uniqueLogHash = event.log.getTransactionHash() + "-" +
                        event.log.getTransactionIndexRaw() + "-" +
                        event.log.getLogIndexRaw();
        type = "register";
        transactionIndex = event.log.getTransactionIndex();
        logIndex = event.log.getLogIndex();

        if (event._nodeRegistered == false) {
            throw new RuntimeException("registered events contain false value");
        }
    }

    public NodeStatusEvent(MasterNodeEnabledEventResponse event) {
        nodeEnabled = true;

        pirlAddress = event._pirlAddress;
        dateStatusChange = event._dateEnabled;
        uniqueLogHash = event.log.getTransactionHash() +
                        event.log.getTransactionIndexRaw() +
                        event.log.getLogIndexRaw();
        type = "enable";
        transactionIndex = event.log.getTransactionIndex();
        logIndex = event.log.getLogIndex();

        if (event._nodeEnabled == false) {
            throw new RuntimeException("enabled events contain false value");
        }
    }

    public NodeStatusEvent(MasterNodeDisabledEventResponse event) {
        nodeEnabled = false;

        pirlAddress = event._pirlAddress;
        dateStatusChange = event._dateDisabled;
        uniqueLogHash = event.log.getTransactionHash() +
                        event.log.getTransactionIndexRaw() +
                        event.log.getLogIndexRaw();
        type = "disable";
        transactionIndex = event.log.getTransactionIndex();
        logIndex = event.log.getLogIndex();

        if (event._nodeDisabled == false) {
            throw new RuntimeException("disabled events contain false value");
        }
    }
}
