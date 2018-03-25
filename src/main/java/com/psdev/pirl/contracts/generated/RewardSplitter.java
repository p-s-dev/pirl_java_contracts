package com.psdev.pirl.contracts.generated;

import org.web3j.abi.FunctionEncoder;
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
public class RewardSplitter extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b60405160608061094983398101604052808051919060200180519190602001805160018054600160a060020a03808816600160a060020a03199283161790925560028054878416908316179055600580548385169216919091179081905591935060049250166331deb7e16000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15156100ca57600080fd5b6102c65a03f115156100db57600080fd5b505050604051805190508115156100ee57fe5b0460045550505042620151800160035561083c8061010d6000396000f3006060604052600436106100cc5763ffffffff60e060020a6000350416630e9f8abf81146101d2578063127effb2146101f95780631aa3a008146102285780631e522c3e1461023257806321fe5d7c1461024557806326f2d67d1461026a5780632b2f1e141461027d5780633ccfd60b146102905780633feb5f2b146102a35780637076c657146102b957806384ffd655146102cc578063960524e3146102df5780639c1e554c146102f2578063dab855a3146102f2578063e87508be14610305578063eb566e9114610318575b6000805481906004146100de57600080fd5b60055433600160a060020a03908116911614156100fa576101ce565b60015433600160a060020a0390811691161461011557600080fd5b670de0b6b3a764000034111561012a57426003555b5050600460143490810490030460005b600481101561019557600080548290811061015157fe5b600091825260209091200154600160a060020a031682156108fc0283604051600060405180830381858888f19350505050151561018d57600080fd5b60010161013a565b600254600160a060020a039081169030163180156108fc0290604051600060405180830381858888f1935050505015156101ce57600080fd5b5050005b34156101dd57600080fd5b6101e561032b565b604051901515815260200160405180910390f35b341561020457600080fd5b61020c610358565b604051600160a060020a03909116815260200160405180910390f35b610230610367565b005b341561023d57600080fd5b61020c6104d4565b341561025057600080fd5b6102586104e3565b60405190815260200160405180910390f35b341561027557600080fd5b6102586104e8565b341561028857600080fd5b61020c6104ee565b341561029b57600080fd5b6102306104fd565b34156102ae57600080fd5b61020c60043561071b565b34156102c457600080fd5b610258610743565b34156102d757600080fd5b610258610748565b34156102ea57600080fd5b61025861074d565b34156102fd57600080fd5b610258610753565b341561031057600080fd5b61025861075a565b341561032357600080fd5b610258610760565b6000805460041480156103445750600354620151804203115b1561035157506001610355565b5060005b90565b600254600160a060020a031681565b32600160a060020a031633600160a060020a031614151561038757600080fd5b6000546004901061039757600080fd5b60045434146103a557600080fd5b60008054600181016103b783826107c9565b5060009182526020822001805473ffffffffffffffffffffffffffffffffffffffff191632600160a060020a031617905554600414156104d257600554600160a060020a0316806331deb7e16000604051602001526040518163ffffffff1660e060020a028152600401602060405180830381600087803b151561043a57600080fd5b6102c65a03f1151561044b57600080fd5b505050604051805162030d4091506040517f6e6f6465526567697374726174696f6e282900000000000000000000000000008152601201604051809103902060e060020a90049190600460405160e060020a63ffffffff861602815260ff9091166004820152602401600060405180830381858988f194505050505015156104d257600080fd5b565b600554600160a060020a031681565b600581565b60035481565b600154600160a060020a031681565b600032600160a060020a031633600160a060020a031614151561051f57600080fd5b600080541161052d57600080fd5b6105363261076c565b905060008181548110151561054757fe5b60009182526020909120015432600160a060020a0390811691161461056b57600080fd5b60005460041480156105835750600354620151804203115b1561063057600554600160a060020a031663baf3ef136040518163ffffffff1660e060020a028152600401600060405180830381600087803b15156105c757600080fd5b6102c65a03f115156105d857600080fd5b5050600554600160a060020a0316905063bed9d8616040518163ffffffff1660e060020a028152600401600060405180830381600087803b151561061b57600080fd5b6102c65a03f1151561062c57600080fd5b5050505b60008054600019810190811061064257fe5b60009182526020822001548154600160a060020a0390911691908390811061066657fe5b60009182526020822001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039390931692909217909155805460001981019081106106ac57fe5b60009182526020822001805473ffffffffffffffffffffffffffffffffffffffff191690558054906106e29060001983016107c9565b5032600160a060020a03166108fc6004549081150290604051600060405180830381858888f19350505050151561071857600080fd5b50565b600080548290811061072957fe5b600091825260209091200154600160a060020a0316905081565b601481565b600481565b60005490565b6201518081565b60045481565b670de0b6b3a764000081565b6000805b6000548110156107be5782600160a060020a031660008281548110151561079357fe5b600091825260209091200154600160a060020a031614156107b6578091506107c3565b600101610770565b600491505b50919050565b8154818355818115116107ed576000838152602090206107ed9181019083016107f2565b505050565b61035591905b8082111561080c57600081556001016107f8565b50905600a165627a7a72305820f84f343adb2944a03048266bff7c97764ef419bb00693cc95f4d8dab67cac9860029";

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

    public RemoteCall<String> operatorAddress() {
        final Function function = new Function("operatorAddress", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> register(BigInteger weiValue) {
        final Function function = new Function(
                "register", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<String> registrationContract() {
        final Function function = new Function("registrationContract", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    public RemoteCall<String> payerAddress() {
        final Function function = new Function("payerAddress", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    public RemoteCall<BigInteger> getInvestorCount() {
        final Function function = new Function("getInvestorCount", 
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

    public RemoteCall<BigInteger> MIN_PAYMENT() {
        final Function function = new Function("MIN_PAYMENT", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<RewardSplitter> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _payerAddress, String _operatorAddress, String _registrationContractAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_payerAddress), 
                new org.web3j.abi.datatypes.Address(_operatorAddress), 
                new org.web3j.abi.datatypes.Address(_registrationContractAddress)));
        return deployRemoteCall(RewardSplitter.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<RewardSplitter> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _payerAddress, String _operatorAddress, String _registrationContractAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_payerAddress), 
                new org.web3j.abi.datatypes.Address(_operatorAddress), 
                new org.web3j.abi.datatypes.Address(_registrationContractAddress)));
        return deployRemoteCall(RewardSplitter.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RewardSplitter load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RewardSplitter(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static RewardSplitter load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RewardSplitter(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
