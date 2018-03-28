package com.psdev.pirl.masternode.loader.pirl;

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
@Profile("pirl")
public class PirlUserCredentialsManagerImpl implements UserCredentialsManager {

    @Autowired
    Web3j web3j;

    // 0xe4b78Bb7C20da0789918bE4B9D8fDa9afCC3d0e3 : 2-20 pirl
    private Credentials pirlAdmin = Credentials.create("2ff2538229810610061a1ccda84af3464260d504cea5235ef414aa3fc88eb00d");
    private static final String PIRL_MN_PAYER = "0xe2052723a18115a15fd985107f18c190347e5059";

    private List<Credentials> users;

    PirlUserCredentialsManagerImpl() {
        users = Arrays.asList();
    }

    @Override
    public Credentials getAdmin() {
        return pirlAdmin;
    }
    @Override
    public Credentials getPayer() {
        throw new RuntimeException("no such user");
    }
    @Override
    public String getPayerAddress() {
        return PIRL_MN_PAYER;
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
