package com.psdev.pirl.masternode.loader.ropsten;

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
@Profile("ropsten")
public class RopstenUserCredentialsManagerImpl implements UserCredentialsManager {

    @Autowired
    Web3j web3j;

    // 0xc272b7c1cc44c7df576697c34f1d84e531e79730 : 10k - 20k
    private Credentials ropstenAdmin = Credentials.create("34123fdc64e16fe166327d61f4a88da3fee7730c00f668ae5915b8e8e89c47c0");

    // 0x86468c9184a97C5B9DE672076F205Bc880BCa4D0 : 20k - 30k
    private Credentials ropstenPayer = Credentials.create("168fafb70e4a380a805dfb6fe4bffc6d481225eff42a8cda93761fd283c4395c");

    // 0x439e0F8278713BD6cC05515916f88Ef56f60AC18 : 2-10 eth
    private Credentials ropstenUser1 = Credentials.create("e43224b23e75a60fe73cf7f037e48febf03d79b989c6b0b31bd84bcce0bcabfb");

    // 0xF89725260Fd65E972B74eE797E35CdA9b9F7bA47 : 2-10 eth
    private Credentials ropstenUser2 = Credentials.create("5e7c1ab0ad7e4df4b52cfb3c141ad87de9408b318fab541985d536a1d67e9261");

    // 0x2f3e4F5e079652d9FC9B610d55fd8d864123f9ab : 2-10 eth
    private Credentials ropstenUser3 = Credentials.create("4bc1dc4c59316d4c27e45667df645c46c435bfda44897fa2e1ebf662b16307d3");

    private List<Credentials> users;

    RopstenUserCredentialsManagerImpl() {
        users = Arrays.asList(ropstenUser1, ropstenUser2, ropstenUser3);
    }

    @Override
    public Credentials getAdmin() {
        return ropstenAdmin;
    }
    @Override
    public Credentials getPayer() {
        return ropstenPayer;
    }

    @Override
    public String getPayerAddress() {
        return getPayer().getAddress();
    }

    @Override
    public Credentials getOperator() {
        return getPayer();
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
