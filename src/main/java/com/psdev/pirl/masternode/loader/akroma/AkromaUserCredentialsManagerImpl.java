package com.psdev.pirl.masternode.loader.akroma;

import com.psdev.pirl.masternode.loader.UserCredentialsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.web3j.protocol.core.DefaultBlockParameterName.LATEST;

@Service
@Profile("akroma")
public class AkromaUserCredentialsManagerImpl implements UserCredentialsManager {

    @Autowired
    Web3j web3j;

    // 0x686786814271d47C3eD41a5584C4a0DDE8F77535 : 2-20 aka
    private Credentials admin = Credentials.create("925ef9269f8fe77e44f8cf7fddaaad1888bd470eb2294df1eed93ec800631e32");

    private List<Credentials> users;

    AkromaUserCredentialsManagerImpl() {
        users = Arrays.asList();
    }

    @Override
    public Credentials getAdmin() {
        return admin;
    }
    @Override
    public Credentials getPayer() {
        throw new RuntimeException("no such user");
    }
    @Override
    public String getPayerAddress() {
        throw new RuntimeException("no such user");
    }
    @Override
    public Credentials getOperator() {
        throw new RuntimeException("no such user");
    }

    @Override
    public Credentials getUser(int userNumber) {
        validate(userNumber);
        return users.get(userNumber);
    }

    @Override
    public String getUserAddress(int userNumber) {
        validate(userNumber);
        return users.get(userNumber).getAddress();
    }

    @Override
    public BigInteger getUserBalance(int userNumber) throws IOException {
        validate(userNumber);
        return web3j.ethGetBalance(getUserAddress(userNumber), LATEST).send().getBalance();
    }

    @Override
    public BigInteger getOperatorBalance() throws IOException {
        return web3j.ethGetBalance(getOperator().getAddress(), LATEST).send().getBalance();
    }

    private void validate(int userNumber) {
        if (userNumber >= users.size()) {
            throw new RuntimeException("no such user");
        }
    }

}
