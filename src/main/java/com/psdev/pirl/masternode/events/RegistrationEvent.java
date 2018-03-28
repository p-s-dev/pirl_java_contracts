package com.psdev.pirl.masternode.events;

import com.psdev.pirl.contracts.generated.PirlMasternodeDeposit;
import lombok.ToString;

import java.math.BigInteger;

@ToString
public class RegistrationEvent {
    public Boolean nodeEnabled;
    public BigInteger dateStatusChange;
    public String uniqueLogHash;
    public String updatedBy;

    public RegistrationEvent(PirlMasternodeDeposit.MasterNodeRegistrationEnabledEventResponse event) {
        nodeEnabled = true;

        dateStatusChange = event._dateEnabled;
        updatedBy = event._invoker;

        uniqueLogHash = event.log.getTransactionHash() +
                event.log.getTransactionIndexRaw() +
                event.log.getLogIndexRaw();

        if (event._registrationEnabled == false) {
            throw new RuntimeException("registration events contain false value");
        }
    }

    public RegistrationEvent(PirlMasternodeDeposit.MasterNodeRegistrationDisabledEventResponse event) {
        nodeEnabled = false;

        dateStatusChange = event._dateDisabled;
        updatedBy = event._invoker;

        uniqueLogHash = event.log.getTransactionHash() +
                event.log.getTransactionIndexRaw() +
                event.log.getLogIndexRaw();

        if (event._registrationDisabled == false) {
            throw new RuntimeException("registration events contain false value");
        }
    }
}
