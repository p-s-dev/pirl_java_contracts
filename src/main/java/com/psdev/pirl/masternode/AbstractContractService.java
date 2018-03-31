package com.psdev.pirl.masternode;

import com.psdev.pirl.masternode.loader.UserCredentialsManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.tx.Contract;

import java.math.BigInteger;

import static org.springframework.util.StringUtils.isEmpty;

@Service
@Slf4j
abstract class AbstractContractService {

    @Autowired
    Web3j web3j;

    @Autowired
    UserCredentialsManager userCredentialsManager;

    @Autowired
    BigInteger gasPrice;

    @Autowired
    BigInteger gasLimit;

    protected Contract contract;

    abstract Contract deployContract() throws Exception;

    protected boolean contractDeployed() throws Exception {
        if (contract == null || isEmpty(contractAddress())) {
            contract = deployContract();
        }

        return contract != null && !isEmpty(contractAddress());
    }

    protected String contractAddress() {
        return contract.getContractAddress();
    }

    public void resetContract() {
        contract = null;
    }

}
