package com.psdev.pirl.masternode;

import com.psdev.pirl.contracts.generated.PirlMasternodeDeposit;

import java.math.BigInteger;

public interface NodeRegistrationService {

    PirlMasternodeDeposit enableNodeRegistration() throws Exception;

    void registerNodeForUser(int userId) throws Exception;

    BigInteger getNodeCount() throws Exception;

    BigInteger getNodeCost() throws Exception;

    Boolean isNodeRegistrationEnabled() throws Exception;

    BigInteger getBalance() throws Exception;
}
