package com.psdev.pirl.contracts.generated;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class DepositProxy extends Contract {
    private static final String BINARY = "606060405260008055341561001357600080fd5b6040516020806102658339810160405280805160018054600160a060020a03909216600160a060020a0319909216919091179055505061020d806100586000396000f30060606040526004361061003d5763ffffffff60e060020a6000350416630225873081146100b9578063baf3ef13146100c1578063bed9d861146100d4575b60008054111561004c576100b7565b6000805460019081019091555473ffffffffffffffffffffffffffffffffffffffff1663bed9d8616040518163ffffffff1660e060020a028152600401600060405180830381600087803b15156100a257600080fd5b6102c65a03f115156100b357600080fd5b5050505b005b6100b76100e7565b34156100cc57600080fd5b6100b7610149565b34156100df57600080fd5b6100b7610195565b60015473ffffffffffffffffffffffffffffffffffffffff1663022587306040518163ffffffff1660e060020a028152600401600060405180830381600087803b151561013357600080fd5b6102c65a03f1151561014457600080fd5b505050565b60015473ffffffffffffffffffffffffffffffffffffffff1663baf3ef136040518163ffffffff1660e060020a028152600401600060405180830381600087803b151561013357600080fd5b60015473ffffffffffffffffffffffffffffffffffffffff1663bed9d8616040518163ffffffff1660e060020a028152600401600060405180830381600087803b151561013357600080fd00a165627a7a72305820322d91824091c62dc14e2feaec11428b2f92fd70699b5e7e1af740af03ee86f00029";

    protected DepositProxy(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DepositProxy(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> nodeRegistration(BigInteger weiValue) {
        final Function function = new Function(
                "nodeRegistration", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
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

    public static RemoteCall<DepositProxy> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _depositAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_depositAddress)));
        return deployRemoteCall(DepositProxy.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<DepositProxy> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _depositAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_depositAddress)));
        return deployRemoteCall(DepositProxy.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static DepositProxy load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DepositProxy(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static DepositProxy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DepositProxy(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
