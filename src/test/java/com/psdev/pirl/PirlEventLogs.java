package com.psdev.pirl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.generated.Bytes20;
import org.web3j.abi.datatypes.generated.Uint256;

import java.util.Arrays;

@Slf4j
public class PirlEventLogs {

    @Test
    public void testGetEventLogHashes() {

        Event event = new Event("MasterNodeRegistered",
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes20>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        log.info("eventName=" + event.getName() + "encodedEvent=" + EventEncoder.encode(event));

        event = new Event("MasterNodeDisabled",
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes20>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        log.info("eventName=" + event.getName() + "encodedEvent=" + EventEncoder.encode(event));

        event = new Event("MasterNodeEnabled",
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes20>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        log.info("eventName=" + event.getName() + "encodedEvent=" + EventEncoder.encode(event));

        event = new Event("MasterNodeRewarded",
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes20>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        log.info("eventName=" + event.getName() + "encodedEvent=" + EventEncoder.encode(event));

        event = new Event("StakeWithdrawn",
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes20>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        log.info("eventName=" + event.getName() + "encodedEvent=" + EventEncoder.encode(event));

        event = new Event("MasterNodeRegistrationEnabled",
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        log.info("eventName=" + event.getName() + "encodedEvent=" + EventEncoder.encode(event));

        event = new Event("MasterNodeRegistrationDisabled",
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        log.info("eventName=" + event.getName() + "encodedEvent=" + EventEncoder.encode(event));

        event = new Event("SetAdmin",
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList());
        log.info("eventName=" + event.getName() + "encodedEvent=" + EventEncoder.encode(event));

        event = new Event("TransferOwnership",
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList());
        log.info("eventName=" + event.getName() + "encodedEvent=" + EventEncoder.encode(event));



//        web3j.ethLogObservable()


    }

}
