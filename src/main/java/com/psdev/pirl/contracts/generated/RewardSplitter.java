package com.psdev.pirl.contracts.generated;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
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
    private static final String BINARY = "6060604052341561000f57600080fd5b60405160608061097583398101604052808051919060200180519190602001805160018054600160a060020a03808816600160a060020a03199283161790925560028054878416908316179055600580548385169216919091179081905591935060049250166331deb7e16000604051602001526040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15156100ca57600080fd5b6102c65a03f115156100db57600080fd5b505050604051805190508115156100ee57fe5b046004555050504262015180016003556108688061010d6000396000f3006060604052600436106100d75763ffffffff60e060020a6000350416630e9f8abf81146101dd57806312065fe014610204578063127effb2146102295780631aa3a008146102585780631e522c3e1461026257806321fe5d7c1461027557806326f2d67d146102885780632b2f1e141461029b5780633ccfd60b146102ae5780633feb5f2b146102c15780637076c657146102d757806384ffd655146102ea578063960524e3146102fd5780639c1e554c14610310578063dab855a314610310578063e87508be14610323578063eb566e9114610336575b6000805481906004146100e957600080fd5b60055433600160a060020a0390811691161415610105576101d9565b60015433600160a060020a0390811691161461012057600080fd5b670de0b6b3a764000034111561013557426003555b5050600460143490810490030460005b60048110156101a057600080548290811061015c57fe5b600091825260209091200154600160a060020a031682156108fc0283604051600060405180830381858888f19350505050151561019857600080fd5b600101610145565b600254600160a060020a039081169030163180156108fc0290604051600060405180830381858888f1935050505015156101d957600080fd5b5050005b34156101e857600080fd5b6101f0610349565b604051901515815260200160405180910390f35b341561020f57600080fd5b610217610376565b60405190815260200160405180910390f35b341561023457600080fd5b61023c610384565b604051600160a060020a03909116815260200160405180910390f35b610260610393565b005b341561026d57600080fd5b61023c610500565b341561028057600080fd5b61021761050f565b341561029357600080fd5b610217610514565b34156102a657600080fd5b61023c61051a565b34156102b957600080fd5b610260610529565b34156102cc57600080fd5b61023c600435610747565b34156102e257600080fd5b61021761076f565b34156102f557600080fd5b610217610774565b341561030857600080fd5b610217610779565b341561031b57600080fd5b61021761077f565b341561032e57600080fd5b610217610786565b341561034157600080fd5b61021761078c565b6000805460041480156103625750600354620151804203115b1561036f57506001610373565b5060005b90565b600160a060020a0330163190565b600254600160a060020a031681565b32600160a060020a031633600160a060020a03161415156103b357600080fd5b600054600490106103c357600080fd5b60045434146103d157600080fd5b60008054600181016103e383826107f5565b5060009182526020822001805473ffffffffffffffffffffffffffffffffffffffff191632600160a060020a031617905554600414156104fe57600554600160a060020a0316806331deb7e16000604051602001526040518163ffffffff1660e060020a028152600401602060405180830381600087803b151561046657600080fd5b6102c65a03f1151561047757600080fd5b505050604051805162030d4091506040517f6e6f6465526567697374726174696f6e282900000000000000000000000000008152601201604051809103902060e060020a90049190600460405160e060020a63ffffffff861602815260ff9091166004820152602401600060405180830381858988f194505050505015156104fe57600080fd5b565b600554600160a060020a031681565b600581565b60035481565b600154600160a060020a031681565b600032600160a060020a031633600160a060020a031614151561054b57600080fd5b600080541161055957600080fd5b61056232610798565b905060008181548110151561057357fe5b60009182526020909120015432600160a060020a0390811691161461059757600080fd5b60005460041480156105af5750600354620151804203115b1561065c57600554600160a060020a031663baf3ef136040518163ffffffff1660e060020a028152600401600060405180830381600087803b15156105f357600080fd5b6102c65a03f1151561060457600080fd5b5050600554600160a060020a0316905063bed9d8616040518163ffffffff1660e060020a028152600401600060405180830381600087803b151561064757600080fd5b6102c65a03f1151561065857600080fd5b5050505b60008054600019810190811061066e57fe5b60009182526020822001548154600160a060020a0390911691908390811061069257fe5b60009182526020822001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039390931692909217909155805460001981019081106106d857fe5b60009182526020822001805473ffffffffffffffffffffffffffffffffffffffff1916905580549061070e9060001983016107f5565b5032600160a060020a03166108fc6004549081150290604051600060405180830381858888f19350505050151561074457600080fd5b50565b600080548290811061075557fe5b600091825260209091200154600160a060020a0316905081565b601481565b600481565b60005490565b6201518081565b60045481565b670de0b6b3a764000081565b6000805b6000548110156107ea5782600160a060020a03166000828154811015156107bf57fe5b600091825260209091200154600160a060020a031614156107e2578091506107ef565b60010161079c565b600491505b50919050565b8154818355818115116108195760008381526020902061081991810190830161081e565b505050565b61037391905b808211156108385760008155600101610824565b50905600a165627a7a72305820bec84272f6fcc93b7daaae4ed6b5aa3cab327d02d730c1e3dd2177b91a3fde830029";

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
