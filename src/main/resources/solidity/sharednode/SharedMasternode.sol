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

contract owned {
    function owned() public { owner = msg.sender; }
    address owner;

    modifier onlyOwner {
        require(msg.sender == owner);
        _;
    }

    modifier onlyNonContracts {
        require(msg.sender == tx.origin);
        _;
    }
}

contract RewardSplitter is owned {

    address[] public investors;
    address payer;
    uint public lastPayTimestamp;
    uint256 public investorDeposit;
    bool public masternodeCancelled = false;

    MockMasternodeRegistrationContract registrationContract;

    function RewardSplitter(address _registrationContractAddr) public {
        registrationContract = MockMasternodeRegistrationContract(_registrationContractAddr);
        investorDeposit = registrationContract.nodeCost() / 4;
        lastPayTimestamp = now - 1 days;
        payer = address(0x2f3e4F5e079652d9FC9B610d55fd8d864123f9ab);
    }

    function() public payable {
        require(investors.length == 4);

        if (msg.sender == address(registrationContract)) {
            return;
        }

        require(msg.sender == payer);

        // 5% fee to operator
        uint share = (msg.value - (msg.value / 20)) / 4;

        if (share > 0.5 ether) {
            lastPayTimestamp = block.timestamp;
        }

        investors[0].transfer(share);
        investors[1].transfer(share);
        investors[2].transfer(share);
        investors[3].transfer(share);
        owner.transfer(address(this).balance);
    }

    function register() public payable onlyNonContracts {
        require(investors.length < 4);
        require(msg.value == investorDeposit);
        investors.push(tx.origin);
        if (investors.length == 4) {
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

        if (investors.length == 4 && now - 1 days > lastPayTimestamp) {
            registrationContract.disableNode();
            registrationContract.withdrawStake();
        }

        investors[userId] = investors[investors.length-1];
        delete investors[investors.length-1];
        investors.length--;
        tx.origin.transfer(investorDeposit);
    }

    function changepayer(address _newpayer) public onlyOwner {
        payer = _newpayer;
    }

    function getInvestorId(address _investorAddress) private constant returns(uint256) {
        for (uint256 i = 0; i < investors.length; i++){
            if (investors[i] == _investorAddress) {
                return i;
            }
        }
        return 4;
    }

    function canCancelInactiveNode() public constant returns(bool) {
        if (masternodeCancelled == false && now - 1 days > lastPayTimestamp) {
            return true;
        } else {
            return false;
        }
    }

    function getBalance() public constant returns(uint){
        return address(this).balance;
    }

}

