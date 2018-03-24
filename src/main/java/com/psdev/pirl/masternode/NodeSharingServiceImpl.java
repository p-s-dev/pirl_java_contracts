package com.psdev.pirl.masternode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;

@Service
public class NodeSharingServiceImpl implements NodeSharingService {

    @Autowired
    Web3j web3j;


    @Override
    public void joinNodeShare() {

    }

    @Override
    public void withdrawReward() {

    }

    @Override
    public void withdrawStake() {

    }

    @Override
    public void dispute() {

    }
}
