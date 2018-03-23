package com.psdev.pirl.contracts.generated.solidity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes20;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class DepositSolidityTypes extends Contract {
    private static final String BINARY = "60606040526004361061011c5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166302258730811461013157806311f217c71461014d57806314d0f1ba14610188578063189a5a17146101a75780631a6f19741461021557806331deb7e11461022857806356a49b7a1461024d5780636da49b831461026c578063704b6c021461027f5780638da5cb5b1461029e5780639ced5c29146102b1578063aba222ed146102c4578063baf3ef13146102d7578063bed9d861146102ea578063c4d77090146102fd578063c886594d14610313578063cfbf92a914610332578063d1a132f914610351578063dc29da2214610364578063f4162530146103a5578063f851a440146103b8575b6101246103cb565b151561012f57600080fd5b005b6101396103cb565b604051901515815260200160405180910390f35b341561015857600080fd5b61016c600160a060020a0360043516610624565b604051600160a060020a03909116815260200160405180910390f35b341561019357600080fd5b610139600160a060020a0360043516610642565b34156101b257600080fd5b6101c6600160a060020a0360043516610657565b604051600160a060020a03909516855260208501939093526bffffffffffffffffffffffff199091166040808501919091529015156060840152901515608083015260a0909101905180910390f35b341561022057600080fd5b6101396106a7565b341561023357600080fd5b61023b610744565b60405190815260200160405180910390f35b341561025857600080fd5b610139600160a060020a036004351661074a565b341561027757600080fd5b61023b610772565b341561028a57600080fd5b610139600160a060020a0360043516610778565b34156102a957600080fd5b61016c6107f5565b34156102bc57600080fd5b610139610804565b34156102cf57600080fd5b610139610980565b34156102e257600080fd5b610139610989565b34156102f557600080fd5b610139610ab5565b341561030857600080fd5b61016c600435610c62565b341561031e57600080fd5b610139600160a060020a0360043516610c8a565b341561033d57600080fd5b61023b600160a060020a0360043516610cb2565b341561035c57600080fd5b610139610cd0565b341561036f57600080fd5b610383600160a060020a0360043516610d70565b6040516bffffffffffffffffffffffff19909116815260200160405180910390f35b34156103b057600080fd5b61023b610d9d565b34156103c357600080fd5b61016c610da3565b600754600090819060ff1615156103e157600080fd5b60055434146103ef57600080fd5b600554600160a060020a03331660009081526008602052604090206001015461041e903463ffffffff610db216565b1461042857600080fd5b600380546001810161043a8382610de0565b5060009182526020822001805473ffffffffffffffffffffffffffffffffffffffff191633600160a060020a0381169190911790915560039160405160200152604051600160a060020a03919091166c010000000000000000000000000281527f6e6f646520726567697374726174696f6e000000000000000000000000000000601482015260250160206040518083038160008661646e5a03f115156104e057600080fd5b50506040515133600160a060020a03166000818152600860205260409020805473ffffffffffffffffffffffffffffffffffffffff19908116909217815560028101805460a060020a93166c010000000000000000000000009485029485041774ff0000000000000000000000000000000000000000191692909217909155600101549091506105709034610db2565b600160a060020a0333166000908152600860205260409020600180820192909255600201805475ff000000000000000000000000000000000000000000191660a860020a1790556004546105c99163ffffffff610db216565b60045560016bffffffffffffffffffffffff198216600160a060020a0333167f874e5cd02e9cafc0c9b56b48507e49128ef5e82708c69977d96a58db5c67187c4260405190815260200160405180910390a4600191505b5090565b600160a060020a039081166000908152600860205260409020541690565b60026020526000908152604090205460ff1681565b600860205260009081526040902080546001820154600290920154600160a060020a0390911691906c0100000000000000000000000081029060ff60a060020a820481169160a860020a90041685565b600033600160a060020a031615156106be57600080fd5b60005433600160a060020a03908116911614806106e9575060015433600160a060020a039081169116145b15156106f457600080fd5b6007805460ff191690556001600160a060020a0333167f2bc38014d1ed4c8d460666df86813d8072271592f5ca25dab3291ab5613ced9c4260405190815260200160405180910390a35060015b90565b60055481565b600160a060020a031660009081526008602052604090206002015460a060020a900460ff1690565b60045481565b600033600160a060020a0316151561078f57600080fd5b60005433600160a060020a039081169116146107aa57600080fd5b600154600160a060020a03838116911614156107c557600080fd5b5060018054600160a060020a03831673ffffffffffffffffffffffffffffffffffffffff19909116178155919050565b600054600160a060020a031681565b600033600160a060020a038116151561081c57600080fd5b600160a060020a03811660009081526008602052604090206002015460a060020a900460ff161561084c57600080fd5b33600160a060020a038116151561086257600080fd5b600160a060020a03811660009081526008602052604090206002015460a860020a900460ff161561089257600080fd5b600554600160a060020a033316600090815260086020526040902060010154146108bb57600080fd5b600160a060020a03331660008181526008602052604090819020600201805474ff00000000000000000000000000000000000000001975ff0000000000000000000000000000000000000000001990911660a860020a171660a060020a17908190556001926bffffffffffffffffffffffff196c0100000000000000000000000090920291909116917f0aca9d4eaa2de0b8616f206ab9f76986ef228f6a5cc21914b7f59b46a8728c609042905190815260200160405180910390a460019250505090565b60075460ff1681565b600033600160a060020a03811615156109a157600080fd5b600160a060020a03811660009081526008602052604090206002015460a060020a900460ff1615156109d257600080fd5b33600160a060020a03811615156109e857600080fd5b600160a060020a03811660009081526008602052604090206002015460a860020a900460ff161515610a1957600080fd5b33600160a060020a031660008181526008602052604090819020600201805475ffff00000000000000000000000000000000000000001916908190556001926c010000000000000000000000009091026bffffffffffffffffffffffff1916917f72e6fe61d6779a94a624b75d0648bdee4db83404b469edf59d0ea52f194c66809042905190815260200160405180910390a460019250505090565b60008033600160a060020a0381161515610ace57600080fd5b600160a060020a03811660009081526008602052604090206002015460a060020a900460ff1615610afe57600080fd5b33600160a060020a0381161515610b1457600080fd5b600160a060020a03811660009081526008602052604090206002015460a860020a900460ff1615610b4457600080fd5b600160a060020a0333166000908152600860205260409020600101546005549093508314610b7157600080fd5b600454600090610b8890600163ffffffff610dcb16565b1015610b9357600080fd5b600454610ba790600163ffffffff610dcb16565b60045533600160a060020a03166000818152600860205260408082206001808201939093556002015491926c010000000000000000000000009092026bffffffffffffffffffffffff191691907faa1be5397bda92136f0c983f881f4cff07e39c44d1ba66207f7baff0ac40d7589042905190815260200160405180910390a4600160a060020a03331683156108fc0284604051600060405180830381858888f193505050501515610c5857600080fd5b6001935050505090565b6003805482908110610c7057fe5b600091825260209091200154600160a060020a0316905081565b600160a060020a031660009081526008602052604090206002015460a860020a900460ff1690565b600160a060020a031660009081526008602052604090206001015490565b600033600160a060020a03161515610ce757600080fd5b60005433600160a060020a0390811691161480610d12575060015433600160a060020a039081169116145b1515610d1d57600080fd5b6007805460ff19166001908117909155600160a060020a0333167fddd4bc3fefa8b16f2e50f753f28d8f29b0a08a40afe8cbfaef54fd17d3d725db4260405190815260200160405180910390a350600190565b600160a060020a03166000908152600860205260409020600201546c010000000000000000000000000290565b60065481565b600154600160a060020a031681565b600082820183811015610dc457600080fd5b9392505050565b600082821115610dda57600080fd5b50900390565b815481835581811511610e0457600083815260209020610e04918101908301610e09565b505050565b61074191905b808211156106205760008155600101610e0f5600a165627a7a72305820cba1f19ff0082debe72ccdc3563005a3e2162f4f824dcbca0833d797d7e5a6c00029";

    protected DepositSolidityTypes(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DepositSolidityTypes(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<MasterNodeRegisteredEventResponse> getMasterNodeRegisteredEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("MasterNodeRegistered", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes20>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<MasterNodeRegisteredEventResponse> responses = new ArrayList<MasterNodeRegisteredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MasterNodeRegisteredEventResponse typedResponse = new MasterNodeRegisteredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._pirlAddress = (Address) eventValues.getIndexedValues().get(0);
            typedResponse._nodeHash = (Bytes20) eventValues.getIndexedValues().get(1);
            typedResponse._nodeRegistered = (Bool) eventValues.getIndexedValues().get(2);
            typedResponse._dateRegistered = (Uint256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MasterNodeRegisteredEventResponse> masterNodeRegisteredEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("MasterNodeRegistered", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes20>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, MasterNodeRegisteredEventResponse>() {
            @Override
            public MasterNodeRegisteredEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                MasterNodeRegisteredEventResponse typedResponse = new MasterNodeRegisteredEventResponse();
                typedResponse.log = log;
                typedResponse._pirlAddress = (Address) eventValues.getIndexedValues().get(0);
                typedResponse._nodeHash = (Bytes20) eventValues.getIndexedValues().get(1);
                typedResponse._nodeRegistered = (Bool) eventValues.getIndexedValues().get(2);
                typedResponse._dateRegistered = (Uint256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public List<MasterNodeDisabledEventResponse> getMasterNodeDisabledEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("MasterNodeDisabled", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes20>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<MasterNodeDisabledEventResponse> responses = new ArrayList<MasterNodeDisabledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MasterNodeDisabledEventResponse typedResponse = new MasterNodeDisabledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._pirlAddress = (Address) eventValues.getIndexedValues().get(0);
            typedResponse._nodeHash = (Bytes20) eventValues.getIndexedValues().get(1);
            typedResponse._nodeDisabled = (Bool) eventValues.getIndexedValues().get(2);
            typedResponse._dateDisabled = (Uint256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MasterNodeDisabledEventResponse> masterNodeDisabledEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("MasterNodeDisabled", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes20>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, MasterNodeDisabledEventResponse>() {
            @Override
            public MasterNodeDisabledEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                MasterNodeDisabledEventResponse typedResponse = new MasterNodeDisabledEventResponse();
                typedResponse.log = log;
                typedResponse._pirlAddress = (Address) eventValues.getIndexedValues().get(0);
                typedResponse._nodeHash = (Bytes20) eventValues.getIndexedValues().get(1);
                typedResponse._nodeDisabled = (Bool) eventValues.getIndexedValues().get(2);
                typedResponse._dateDisabled = (Uint256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public List<MasterNodeEnabledEventResponse> getMasterNodeEnabledEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("MasterNodeEnabled", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes20>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<MasterNodeEnabledEventResponse> responses = new ArrayList<MasterNodeEnabledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MasterNodeEnabledEventResponse typedResponse = new MasterNodeEnabledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._pirlAddress = (Address) eventValues.getIndexedValues().get(0);
            typedResponse._nodeHash = (Bytes20) eventValues.getIndexedValues().get(1);
            typedResponse._nodeEnabled = (Bool) eventValues.getIndexedValues().get(2);
            typedResponse._dateEnabled = (Uint256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MasterNodeEnabledEventResponse> masterNodeEnabledEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("MasterNodeEnabled", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes20>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, MasterNodeEnabledEventResponse>() {
            @Override
            public MasterNodeEnabledEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                MasterNodeEnabledEventResponse typedResponse = new MasterNodeEnabledEventResponse();
                typedResponse.log = log;
                typedResponse._pirlAddress = (Address) eventValues.getIndexedValues().get(0);
                typedResponse._nodeHash = (Bytes20) eventValues.getIndexedValues().get(1);
                typedResponse._nodeEnabled = (Bool) eventValues.getIndexedValues().get(2);
                typedResponse._dateEnabled = (Uint256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public List<MasterNodeRewardedEventResponse> getMasterNodeRewardedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("MasterNodeRewarded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes20>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<MasterNodeRewardedEventResponse> responses = new ArrayList<MasterNodeRewardedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MasterNodeRewardedEventResponse typedResponse = new MasterNodeRewardedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._pirlAddress = (Address) eventValues.getIndexedValues().get(0);
            typedResponse._nodeHash = (Bytes20) eventValues.getIndexedValues().get(1);
            typedResponse._nodePaid = (Bool) eventValues.getIndexedValues().get(2);
            typedResponse._datePaid = (Uint256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MasterNodeRewardedEventResponse> masterNodeRewardedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("MasterNodeRewarded", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes20>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, MasterNodeRewardedEventResponse>() {
            @Override
            public MasterNodeRewardedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                MasterNodeRewardedEventResponse typedResponse = new MasterNodeRewardedEventResponse();
                typedResponse.log = log;
                typedResponse._pirlAddress = (Address) eventValues.getIndexedValues().get(0);
                typedResponse._nodeHash = (Bytes20) eventValues.getIndexedValues().get(1);
                typedResponse._nodePaid = (Bool) eventValues.getIndexedValues().get(2);
                typedResponse._datePaid = (Uint256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public List<StakeWithdrawnEventResponse> getStakeWithdrawnEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("StakeWithdrawn", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes20>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<StakeWithdrawnEventResponse> responses = new ArrayList<StakeWithdrawnEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            StakeWithdrawnEventResponse typedResponse = new StakeWithdrawnEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._pirlAddress = (Address) eventValues.getIndexedValues().get(0);
            typedResponse._nodeHash = (Bytes20) eventValues.getIndexedValues().get(1);
            typedResponse._stakeWithdrawn = (Bool) eventValues.getIndexedValues().get(2);
            typedResponse._dateWithdrawn = (Uint256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<StakeWithdrawnEventResponse> stakeWithdrawnEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("StakeWithdrawn", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bytes20>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, StakeWithdrawnEventResponse>() {
            @Override
            public StakeWithdrawnEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                StakeWithdrawnEventResponse typedResponse = new StakeWithdrawnEventResponse();
                typedResponse.log = log;
                typedResponse._pirlAddress = (Address) eventValues.getIndexedValues().get(0);
                typedResponse._nodeHash = (Bytes20) eventValues.getIndexedValues().get(1);
                typedResponse._stakeWithdrawn = (Bool) eventValues.getIndexedValues().get(2);
                typedResponse._dateWithdrawn = (Uint256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public List<MasterNodeRegistrationEnabledEventResponse> getMasterNodeRegistrationEnabledEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("MasterNodeRegistrationEnabled", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<MasterNodeRegistrationEnabledEventResponse> responses = new ArrayList<MasterNodeRegistrationEnabledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MasterNodeRegistrationEnabledEventResponse typedResponse = new MasterNodeRegistrationEnabledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._invoker = (Address) eventValues.getIndexedValues().get(0);
            typedResponse._registrationEnabled = (Bool) eventValues.getIndexedValues().get(1);
            typedResponse._dateEnabled = (Uint256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MasterNodeRegistrationEnabledEventResponse> masterNodeRegistrationEnabledEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("MasterNodeRegistrationEnabled", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, MasterNodeRegistrationEnabledEventResponse>() {
            @Override
            public MasterNodeRegistrationEnabledEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                MasterNodeRegistrationEnabledEventResponse typedResponse = new MasterNodeRegistrationEnabledEventResponse();
                typedResponse.log = log;
                typedResponse._invoker = (Address) eventValues.getIndexedValues().get(0);
                typedResponse._registrationEnabled = (Bool) eventValues.getIndexedValues().get(1);
                typedResponse._dateEnabled = (Uint256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public List<MasterNodeRegistrationDisabledEventResponse> getMasterNodeRegistrationDisabledEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("MasterNodeRegistrationDisabled", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<MasterNodeRegistrationDisabledEventResponse> responses = new ArrayList<MasterNodeRegistrationDisabledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MasterNodeRegistrationDisabledEventResponse typedResponse = new MasterNodeRegistrationDisabledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._invoker = (Address) eventValues.getIndexedValues().get(0);
            typedResponse._registrationDisabled = (Bool) eventValues.getIndexedValues().get(1);
            typedResponse._dateDisabled = (Uint256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MasterNodeRegistrationDisabledEventResponse> masterNodeRegistrationDisabledEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("MasterNodeRegistrationDisabled", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, MasterNodeRegistrationDisabledEventResponse>() {
            @Override
            public MasterNodeRegistrationDisabledEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                MasterNodeRegistrationDisabledEventResponse typedResponse = new MasterNodeRegistrationDisabledEventResponse();
                typedResponse.log = log;
                typedResponse._invoker = (Address) eventValues.getIndexedValues().get(0);
                typedResponse._registrationDisabled = (Bool) eventValues.getIndexedValues().get(1);
                typedResponse._dateDisabled = (Uint256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public List<SetAdminEventResponse> getSetAdminEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("SetAdmin", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList());
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<SetAdminEventResponse> responses = new ArrayList<SetAdminEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SetAdminEventResponse typedResponse = new SetAdminEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._invoker = (Address) eventValues.getIndexedValues().get(0);
            typedResponse._admin = (Address) eventValues.getIndexedValues().get(1);
            typedResponse._adminSet = (Bool) eventValues.getIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<SetAdminEventResponse> setAdminEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("SetAdmin", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, SetAdminEventResponse>() {
            @Override
            public SetAdminEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                SetAdminEventResponse typedResponse = new SetAdminEventResponse();
                typedResponse.log = log;
                typedResponse._invoker = (Address) eventValues.getIndexedValues().get(0);
                typedResponse._admin = (Address) eventValues.getIndexedValues().get(1);
                typedResponse._adminSet = (Bool) eventValues.getIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public List<TransferOwnershipEventResponse> getTransferOwnershipEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("TransferOwnership", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList());
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<TransferOwnershipEventResponse> responses = new ArrayList<TransferOwnershipEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferOwnershipEventResponse typedResponse = new TransferOwnershipEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._invoker = (Address) eventValues.getIndexedValues().get(0);
            typedResponse._newOwner = (Address) eventValues.getIndexedValues().get(1);
            typedResponse._ownerChanged = (Bool) eventValues.getIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferOwnershipEventResponse> transferOwnershipEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("TransferOwnership", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Bool>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, TransferOwnershipEventResponse>() {
            @Override
            public TransferOwnershipEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                TransferOwnershipEventResponse typedResponse = new TransferOwnershipEventResponse();
                typedResponse.log = log;
                typedResponse._invoker = (Address) eventValues.getIndexedValues().get(0);
                typedResponse._newOwner = (Address) eventValues.getIndexedValues().get(1);
                typedResponse._ownerChanged = (Bool) eventValues.getIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> nodeRegistration(BigInteger weiValue) {
        final Function function = new Function(
                "nodeRegistration", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<Address> getNodeAddress(Address _pirlAddress) {
        final Function function = new Function("getNodeAddress", 
                Arrays.<Type>asList(_pirlAddress), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Bool> moderators(Address param0) {
        final Function function = new Function("moderators", 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Tuple5<Address, Uint256, Bytes20, Bool, Bool>> nodes(Address param0) {
        final Function function = new Function("nodes", 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bytes20>() {}, new TypeReference<Bool>() {}, new TypeReference<Bool>() {}));
        return new RemoteCall<Tuple5<Address, Uint256, Bytes20, Bool, Bool>>(
                new Callable<Tuple5<Address, Uint256, Bytes20, Bool, Bool>>() {
                    @Override
                    public Tuple5<Address, Uint256, Bytes20, Bool, Bool> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<Address, Uint256, Bytes20, Bool, Bool>(
                                (Address) results.get(0), 
                                (Uint256) results.get(1), 
                                (Bytes20) results.get(2), 
                                (Bool) results.get(3), 
                                (Bool) results.get(4));
                    }
                });
    }

    public RemoteCall<TransactionReceipt> disableNodeRegistration() {
        final Function function = new Function(
                "disableNodeRegistration", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Uint256> nodeCost() {
        final Function function = new Function("nodeCost", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Bool> getStakeLockedStatus(Address _pirlAddress) {
        final Function function = new Function("getStakeLockedStatus", 
                Arrays.<Type>asList(_pirlAddress), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint256> nodeCount() {
        final Function function = new Function("nodeCount", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> setAdmin(Address _admin) {
        final Function function = new Function(
                "setAdmin", 
                Arrays.<Type>asList(_admin), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Address> owner() {
        final Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> enableNode() {
        final Function function = new Function(
                "enableNode", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Bool> nodeRegistrationEnabled() {
        final Function function = new Function("nodeRegistrationEnabled", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
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

    public RemoteCall<Address> nodeAddresses(Uint256 param0) {
        final Function function = new Function("nodeAddresses", 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Bool> getNodeEnabledStatus(Address _pirlAddress) {
        final Function function = new Function("getNodeEnabledStatus", 
                Arrays.<Type>asList(_pirlAddress), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint256> getNodeStake(Address _pirlAddress) {
        final Function function = new Function("getNodeStake", 
                Arrays.<Type>asList(_pirlAddress), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> enableNodeRegistration() {
        final Function function = new Function(
                "enableNodeRegistration", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Bytes20> getNodeHash(Address _pirlAddress) {
        final Function function = new Function("getNodeHash", 
                Arrays.<Type>asList(_pirlAddress), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes20>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Uint256> nodeFee() {
        final Function function = new Function("nodeFee", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<Address> admin() {
        final Function function = new Function("admin", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public static RemoteCall<DepositSolidityTypes> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DepositSolidityTypes.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<DepositSolidityTypes> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DepositSolidityTypes.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static DepositSolidityTypes load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DepositSolidityTypes(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static DepositSolidityTypes load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DepositSolidityTypes(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class MasterNodeRegisteredEventResponse {
        public Log log;

        public Address _pirlAddress;

        public Bytes20 _nodeHash;

        public Bool _nodeRegistered;

        public Uint256 _dateRegistered;
    }

    public static class MasterNodeDisabledEventResponse {
        public Log log;

        public Address _pirlAddress;

        public Bytes20 _nodeHash;

        public Bool _nodeDisabled;

        public Uint256 _dateDisabled;
    }

    public static class MasterNodeEnabledEventResponse {
        public Log log;

        public Address _pirlAddress;

        public Bytes20 _nodeHash;

        public Bool _nodeEnabled;

        public Uint256 _dateEnabled;
    }

    public static class MasterNodeRewardedEventResponse {
        public Log log;

        public Address _pirlAddress;

        public Bytes20 _nodeHash;

        public Bool _nodePaid;

        public Uint256 _datePaid;
    }

    public static class StakeWithdrawnEventResponse {
        public Log log;

        public Address _pirlAddress;

        public Bytes20 _nodeHash;

        public Bool _stakeWithdrawn;

        public Uint256 _dateWithdrawn;
    }

    public static class MasterNodeRegistrationEnabledEventResponse {
        public Log log;

        public Address _invoker;

        public Bool _registrationEnabled;

        public Uint256 _dateEnabled;
    }

    public static class MasterNodeRegistrationDisabledEventResponse {
        public Log log;

        public Address _invoker;

        public Bool _registrationDisabled;

        public Uint256 _dateDisabled;
    }

    public static class SetAdminEventResponse {
        public Log log;

        public Address _invoker;

        public Address _admin;

        public Bool _adminSet;
    }

    public static class TransferOwnershipEventResponse {
        public Log log;

        public Address _invoker;

        public Address _newOwner;

        public Bool _ownerChanged;
    }
}
