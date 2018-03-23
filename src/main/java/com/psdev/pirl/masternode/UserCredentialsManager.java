package com.psdev.pirl.masternode;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;

import java.util.Arrays;
import java.util.List;

@Service
public class UserCredentialsManager {

    private Credentials testrpc0 = Credentials.create("4f3edf983ac636a65a842ce7c78d9aa706d3b113bce9c46f30d7d21715b23b1d");
    private Credentials testrpc1 = Credentials.create("6cbed15c793ce57650b9877cf6fa156fbef513c4e6134f022a85b1ffdd59b2a1");
    private Credentials testrpc2 = Credentials.create("6370fd033278c143179d81c5526140625662b8daa446c22ee2d73db3707e620c");
    private Credentials testrpc3 = Credentials.create("646f1ce2fdad0e6deeeb5c7e8e5543bdde65e86029e2fd9fc169899c440a7913");

    private List<Credentials> users;

    UserCredentialsManager() {
        users = Arrays.asList(testrpc1,testrpc2,testrpc3);
    }

    public Credentials getAdmin() {
        return testrpc0;
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


}
