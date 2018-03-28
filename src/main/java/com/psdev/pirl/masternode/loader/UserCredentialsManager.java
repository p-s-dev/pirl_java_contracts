package com.psdev.pirl.masternode.loader;

import org.web3j.crypto.Credentials;

import java.io.IOException;
import java.math.BigInteger;

public interface UserCredentialsManager {
    Credentials getAdmin();

    Credentials getPayer();

    String getPayerAddress();

    Credentials getOperator();

    Credentials getUser(int userNumber);

    String getUserAddress(int userNumber);

    BigInteger getUserBalance(int userNumber) throws IOException;

    BigInteger getOperatorBalance() throws IOException;
}
