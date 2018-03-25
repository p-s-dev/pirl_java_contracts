package com.psdev.pirl.masternode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.web3j.protocol.core.DefaultBlockParameterName.LATEST;

@Service
public class UserCredentialsManager {

    @Autowired
    Web3j web3j;

    private Credentials testrpc0 = Credentials.create("4f3edf983ac636a65a842ce7c78d9aa706d3b113bce9c46f30d7d21715b23b1d");
    private Credentials testrpc1 = Credentials.create("6cbed15c793ce57650b9877cf6fa156fbef513c4e6134f022a85b1ffdd59b2a1");
    private Credentials testrpc2 = Credentials.create("6370fd033278c143179d81c5526140625662b8daa446c22ee2d73db3707e620c");
    private Credentials testrpc3 = Credentials.create("646f1ce2fdad0e6deeeb5c7e8e5543bdde65e86029e2fd9fc169899c440a7913");
    private Credentials testrpc4 = Credentials.create("add53f9a7e588d003326d1cbf9e4a43c061aadd9bc938c843a79e7b4fd2ad743");
    private Credentials testrpc5 = Credentials.create("395df67f0c2d2d9fe1ad08d1bc8b6627011959b79c53d7dd6a3536a33ab8a4fd");
    private Credentials testrpc6 = Credentials.create("e485d098507f54e7733a205420dfddbe58db035fa577fc294ebd14db90767a52");
    private Credentials testrpc7 = Credentials.create("a453611d9419d0e56f499079478fd72c37b251a94bfde4d19872c44cf65386e3");
    private Credentials testrpc8 = Credentials.create("829e924fdf021ba3dbbc4225edfece9aca04b929d6e75613329ca6f1d31c0bb4");
    private Credentials testrpc9 = Credentials.create("b0057716d5917badaf911b193b12b910811c1497b5bada8d7711f758981c3773");

    private List<Credentials> users;

    UserCredentialsManager() {
        users = Arrays.asList(testrpc1,testrpc2,testrpc3,testrpc4,testrpc5,testrpc6,testrpc7);
    }

    public Credentials getAdmin() {
        return testrpc0;
    }
    public Credentials getPayer() {
        return testrpc9;
    }
    public Credentials getOperator() {
        return testrpc8;
    }

    public Credentials getUser(int userNumber) {
        if (userNumber > users.size()) {
            throw new RuntimeException("no such user");
        }
        return users.get(userNumber);
    }

    public String getUserAddress(int userNumber) {
        if (userNumber > users.size()) {
            throw new RuntimeException("no such user");
        }
        return users.get(userNumber).getAddress();
    }

    public BigInteger getUserBalance(int userNumber) throws IOException {
        if (userNumber > users.size()) {
            throw new RuntimeException("no such user");
        }
        return web3j.ethGetBalance(getUserAddress(userNumber), LATEST).send().getBalance();
    }

    public BigInteger getOperatorBalance() throws IOException {
        return web3j.ethGetBalance(getOperator().getAddress(), LATEST).send().getBalance();
    }

}
