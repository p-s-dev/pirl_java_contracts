pragma solidity ^0.4.2;

contract MockMasternodeRegistrationContract {
    bool nodeEnabled = false;
    function nodeRegistration() public payable {
    }
    function disableNode() public { }
    function withdrawStake() public {
        msg.sender.transfer(2 ether);
    }
    function nodeCost() public constant returns(uint256) {
        return 2 ether;
    }
    function getBalance() public constant returns(uint){
        return address(this).balance;
    }
}

contract RewardSplitter {

    // custom values
    uint constant public NUM_PARTICIPANTS = 4;
    address constant public PAYER_ADDRESS = address(0x2f3e4F5e079652d9FC9B610d55fd8d864123f9ab);
    address constant public OPERATOR_ADDRESS = address(0x2f3e4F5e079652d9FC9B610d55fd8d864123f9ab);
    uint constant public OPERATOR_FEE_PERCENT = 5;

    address[] public investors;
    uint public lastPayTimestamp;
    uint public investorDeposit;

    MockMasternodeRegistrationContract registrationContract;
    uint constant public OPERATOR_FEE = 100 / OPERATOR_FEE_PERCENT;

    modifier onlyNonContracts {
        require(msg.sender == tx.origin);
        _;
    }

    function RewardSplitter(address _registrationContractAddr) public {
        registrationContract =
        MockMasternodeRegistrationContract(_registrationContractAddr);
        investorDeposit = registrationContract.nodeCost() / NUM_PARTICIPANTS;
        lastPayTimestamp = now - 1 days;
    }

    function() public payable {
        require(investors.length == NUM_PARTICIPANTS);

        if (msg.sender == address(registrationContract)) {
            return;
        }

        require(msg.sender == PAYER_ADDRESS);

        uint share = (msg.value - (msg.value / OPERATOR_FEE)) / NUM_PARTICIPANTS;

        if (share > 0.5 ether) {
            lastPayTimestamp = block.timestamp;
        }

        for (uint256 i = 0; i < NUM_PARTICIPANTS; i++) {
            investors[i].transfer(share);
        }

        OPERATOR_ADDRESS.transfer(address(this).balance);
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
        now - 1 days > lastPayTimestamp) {
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
        if (investors.length == NUM_PARTICIPANTS && now - 1 days > lastPayTimestamp) {
            return true;
        } else {
            return false;
        }
    }

    function getBalance() public constant returns(uint){
        return address(this).balance;
    }

}

