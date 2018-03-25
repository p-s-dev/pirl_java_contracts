package com.psdev.pirl.contracts.generated;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
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
public class RewardSplitter extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b60038054600160a060020a031916732f3e4f5e079652d9fc9b610d55fd8d864123f9ab1790819055600490600160a060020a03166331deb7e16000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b151561009857600080fd5b6102c65a03f115156100a957600080fd5b505050604051805190508115156100bc57fe5b04600255426201518001600155610833806100d86000396000f3006060604052600436106100cc5763ffffffff60e060020a6000350416630e9f8abf81146101fc57806312065fe0146102235780631aa3a0081461024857806321fe5d7c1461025257806326f2d67d146102655780633ccfd60b146102785780633feb5f2b1461028b578063405d6b2b146102bd5780637076c657146102d057806384ffd655146102e35780639c1e554c146102f6578063dab855a3146102f6578063e87508be14610309578063e87d862c146102bd578063eb566e911461031c578063ed335645146102bd575b6000805481906004146100de57600080fd5b33600160a060020a0316732f3e4f5e079652d9fc9b610d55fd8d864123f9ab1415610108576101f8565b33600160a060020a0316732f3e4f5e079652d9fc9b610d55fd8d864123f9ab1461013157600080fd5b670de0b6b3a764000034111561014657426001555b5050600460143490810490030460005b60048110156101b157600080548290811061016d57fe5b600091825260209091200154600160a060020a031682156108fc0283604051600060405180830381858888f1935050505015156101a957600080fd5b600101610156565b732f3e4f5e079652d9fc9b610d55fd8d864123f9ab30600160a060020a03163180156108fc0290604051600060405180830381858888f1935050505015156101f857600080fd5b5050005b341561020757600080fd5b61020f61032f565b604051901515815260200160405180910390f35b341561022e57600080fd5b61023661035c565b60405190815260200160405180910390f35b61025061036a565b005b341561025d57600080fd5b6102366104d7565b341561027057600080fd5b6102366104dc565b341561028357600080fd5b6102506104e2565b341561029657600080fd5b6102a1600435610700565b604051600160a060020a03909116815260200160405180910390f35b34156102c857600080fd5b6102a1610728565b34156102db57600080fd5b610236610740565b34156102ee57600080fd5b610236610745565b341561030157600080fd5b61023661074a565b341561031457600080fd5b610236610751565b341561032757600080fd5b610236610757565b6000805460041480156103485750600154620151804203115b1561035557506001610359565b5060005b90565b600160a060020a0330163190565b32600160a060020a031633600160a060020a031614151561038a57600080fd5b6000546004901061039a57600080fd5b60025434146103a857600080fd5b60008054600181016103ba83826107c0565b5060009182526020822001805473ffffffffffffffffffffffffffffffffffffffff191632600160a060020a031617905554600414156104d557600354600160a060020a0316806331deb7e16000604051602001526040518163ffffffff1660e060020a028152600401602060405180830381600087803b151561043d57600080fd5b6102c65a03f1151561044e57600080fd5b505050604051805162030d4091506040517f6e6f6465526567697374726174696f6e282900000000000000000000000000008152601201604051809103902060e060020a90049190600460405160e060020a63ffffffff861602815260ff9091166004820152602401600060405180830381858988f194505050505015156104d557600080fd5b565b600581565b60015481565b600032600160a060020a031633600160a060020a031614151561050457600080fd5b600080541161051257600080fd5b61051b32610763565b905060008181548110151561052c57fe5b60009182526020909120015432600160a060020a0390811691161461055057600080fd5b60005460041480156105685750600154620151804203115b1561061557600354600160a060020a031663baf3ef136040518163ffffffff1660e060020a028152600401600060405180830381600087803b15156105ac57600080fd5b6102c65a03f115156105bd57600080fd5b5050600354600160a060020a0316905063bed9d8616040518163ffffffff1660e060020a028152600401600060405180830381600087803b151561060057600080fd5b6102c65a03f1151561061157600080fd5b5050505b60008054600019810190811061062757fe5b60009182526020822001548154600160a060020a0390911691908390811061064b57fe5b60009182526020822001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0393909316929092179091558054600019810190811061069157fe5b60009182526020822001805473ffffffffffffffffffffffffffffffffffffffff191690558054906106c79060001983016107c0565b5032600160a060020a03166108fc6002549081150290604051600060405180830381858888f1935050505015156106fd57600080fd5b50565b600080548290811061070e57fe5b600091825260209091200154600160a060020a0316905081565b732f3e4f5e079652d9fc9b610d55fd8d864123f9ab81565b601481565b600481565b6201518081565b60025481565b670de0b6b3a764000081565b6000805b6000548110156107b55782600160a060020a031660008281548110151561078a57fe5b600091825260209091200154600160a060020a031614156107ad578091506107ba565b600101610767565b600491505b50919050565b8154818355818115116107e4576000838152602090206107e49181019083016107e9565b505050565b61035991905b8082111561080357600081556001016107ef565b50905600a165627a7a7230582000772732a4a30101332c1ca130a62bb33e5ee5a65ff63497b0a620b33f925a350029";

    protected RewardSplitter(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RewardSplitter(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<Boolean> canCancelInactiveNode() {
        final Function function = new Function("canCancelInactiveNode", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> getBalance() {
        final Function function = new Function("getBalance", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> register(BigInteger weiValue) {
        final Function function = new Function(
                "register", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<BigInteger> OPERATOR_FEE_PERCENT() {
        final Function function = new Function("OPERATOR_FEE_PERCENT", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> lastPayTimestamp() {
        final Function function = new Function("lastPayTimestamp", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> withdraw() {
        final Function function = new Function(
                "withdraw", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> investors(BigInteger param0) {
        final Function function = new Function("investors", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> MN_DEPOSIT_CONTRACT() {
        final Function function = new Function("MN_DEPOSIT_CONTRACT", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> OPERATOR_FEE() {
        final Function function = new Function("OPERATOR_FEE", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> NUM_PARTICIPANTS() {
        final Function function = new Function("NUM_PARTICIPANTS", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> OPERATOR_OFFLINE_FORGIVENESS_DAYS() {
        final Function function = new Function("OPERATOR_OFFLINE_FORGIVENESS_DAYS", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> OPERATOR_STARTUP_DAYS() {
        final Function function = new Function("OPERATOR_STARTUP_DAYS", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> investorDeposit() {
        final Function function = new Function("investorDeposit", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> PAYER_ADDRESS() {
        final Function function = new Function("PAYER_ADDRESS", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> MIN_PAYMENT() {
        final Function function = new Function("MIN_PAYMENT", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> OPERATOR_ADDRESS() {
        final Function function = new Function("OPERATOR_ADDRESS", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static RemoteCall<RewardSplitter> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RewardSplitter.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<RewardSplitter> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RewardSplitter.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static RewardSplitter load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RewardSplitter(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static RewardSplitter load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RewardSplitter(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
