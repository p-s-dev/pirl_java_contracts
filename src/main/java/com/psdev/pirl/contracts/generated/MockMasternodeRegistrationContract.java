package com.psdev.pirl.contracts.generated;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class MockMasternodeRegistrationContract extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b6101688061001e6000396000f30060606040526004361061006c5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166302258730811461007157806312065fe01461007b57806331deb7e1146100a0578063baf3ef13146100b3578063bed9d861146100be575b600080fd5b6100796100d1565b005b341561008657600080fd5b61008e6100d3565b60405190815260200160405180910390f35b34156100ab57600080fd5b61008e6100ee565b341561007157600080fd5b34156100c957600080fd5b6100796100fa565b565b73ffffffffffffffffffffffffffffffffffffffff30163190565b671bc16d674ec8000090565b73ffffffffffffffffffffffffffffffffffffffff33166000671bc16d674ec80000604051600060405180830381858888f1935050505015156100d157600080fd00a165627a7a72305820e13fa85424b9645aed1ee203c94a5c8dad4884e127e0ee9a6015a085ae3957f70029";

    protected MockMasternodeRegistrationContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MockMasternodeRegistrationContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> nodeRegistration(BigInteger weiValue) {
        final Function function = new Function(
                "nodeRegistration", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<BigInteger> getBalance() {
        final Function function = new Function("getBalance", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> nodeCost() {
        final Function function = new Function("nodeCost", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> disableNode() {
        final Function function = new Function(
                "disableNode", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> withdrawStake() {
        final Function function = new Function(
                "withdrawStake", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<MockMasternodeRegistrationContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MockMasternodeRegistrationContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<MockMasternodeRegistrationContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MockMasternodeRegistrationContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static MockMasternodeRegistrationContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MockMasternodeRegistrationContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static MockMasternodeRegistrationContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MockMasternodeRegistrationContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
