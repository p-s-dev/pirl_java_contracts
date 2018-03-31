package com.psdev.pirl.masternode;

import com.psdev.pirl.contracts.generated.RewardSplitter;

import java.math.BigInteger;

public interface NodeSharingService {

    RewardSplitter getRewardSplitter() throws Exception;

    void registerForUser(int userId) throws Exception;
    void withdrawForUser(int userId) throws Exception;
    String getInvestorAddress(BigInteger investorId) throws Exception;
    BigInteger getBalance() throws Exception;
}
