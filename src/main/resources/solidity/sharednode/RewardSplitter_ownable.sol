pragma solidity ^0.4.2;

import "./MasternodeRegistrationInterface.sol";
import "./Ownable.sol";

contract RewardSplitter is Ownable {

    // custom values
    uint constant public NUM_PARTICIPANTS = 4;
    //    address constant public PAYER_ADDRESS = address(0x0);
    //    address constant public OPERATOR_ADDRESS = address(0x0);
    //    address constant public MN_DEPOSIT_CONTRACT = address(0x0);
    uint constant public OPERATOR_FEE_PERCENT = 5;
    uint constant public OPERATOR_STARTUP_DAYS = 1 days;
    uint constant public OPERATOR_OFFLINE_FORGIVENESS_DAYS = 1 days;
    uint constant public MIN_PAYMENT = 1 ether;

    address[] public investors;
    address public payerAddress;
    address public operatorAddress;
    uint public lastPayTimestamp;
    uint public investorDeposit;

    MasternodeRegistrationInterface public registrationContract;
    uint constant public OPERATOR_FEE = 100 / OPERATOR_FEE_PERCENT;

    modifier onlyNonContracts {
        require(msg.sender == tx.origin);
        _;
    }

    function RewardSplitter(
        address _payerAddress,
        address _operatorAddress,
        address _registrationContractAddress) public {
        payerAddress = _payerAddress;
        operatorAddress = _operatorAddress;
        registrationContract = MasternodeRegistrationInterface(_registrationContractAddress);
        investorDeposit = registrationContract.nodeCost() / NUM_PARTICIPANTS;
        lastPayTimestamp = now + OPERATOR_STARTUP_DAYS;
    }

    function() public payable {
        require(investors.length == NUM_PARTICIPANTS);

        if (msg.sender == address(registrationContract)) {
            return;
        }

        require(msg.sender == payerAddress);

        if (msg.value > MIN_PAYMENT) {
            lastPayTimestamp = block.timestamp;
        }

        uint share = (msg.value - (msg.value / OPERATOR_FEE)) / NUM_PARTICIPANTS;

        for (uint256 i = 0; i < NUM_PARTICIPANTS; i++) {
            investors[i].transfer(share);
        }

        operatorAddress.transfer(address(this).balance);
    }

    function register() public payable onlyNonContracts {
        require(investors.length < NUM_PARTICIPANTS);
        require(msg.value == investorDeposit);
        investors.push(tx.origin);
        if (investors.length == NUM_PARTICIPANTS) {
            if (!address(registrationContract).call.value(
                registrationContract.nodeCost()).gas(200000)(
                bytes4(keccak256("nodeRegistration()")), 4)) {
                revert();
            }
        }
    }

    function withdraw() public onlyNonContracts {
        require(investors.length > 0);
        uint256 userId = getInvestorId(tx.origin);
        require(tx.origin == investors[userId]);

        if (investors.length == NUM_PARTICIPANTS &&
        now - OPERATOR_OFFLINE_FORGIVENESS_DAYS > lastPayTimestamp) {
            registrationContract.disableNode();
            registrationContract.withdrawStake();
        }

        investors[userId] = investors[investors.length-1];
        delete investors[investors.length-1];
        investors.length--;
        tx.origin.transfer(investorDeposit);
    }

    function getInvestorId(address _investorAddress) private constant returns(uint256) {
        for (uint256 i = 0; i < investors.length; i++){
            if (investors[i] == _investorAddress) {
                return i;
            }
        }
        return NUM_PARTICIPANTS;
    }

    function canCancelInactiveNode() public constant returns(bool) {
        if (investors.length == NUM_PARTICIPANTS &&
        now - OPERATOR_OFFLINE_FORGIVENESS_DAYS > lastPayTimestamp) {
            return true;
        } else {
            return false;
        }
    }

    function getInvestorCount() public constant returns(uint){
        return investors.length;
    }

    function call(address _address, uint256 _value, uint256 _gas, bytes _data) onlyOwner {
        address(_address).call.value(_value).gas(_gas)(_data);
    }

    function escapeHatch(address _address) onlyOwner {
        address(_address).transfer(address(this).balance);
    }

}