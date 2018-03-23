package com.psdev.pirl.masternode;

import java.math.BigInteger;

public interface ContractService {
    void enableNodeRegistration() throws Exception;

    void registerNodeForUser(int userId) throws Exception;

    BigInteger getNodeCount() throws Exception;
}
