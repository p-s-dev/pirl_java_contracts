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
}

contract fundinglimited is owned {
    function fundinglimited() public {
        payer = address(0xdd870fa1b7c4700f2bd7f44238821c26f7392148);
    }
    address payer;

    function changepayer(address _newpayer) public onlyOwner {
        payer = _newpayer;
    }

    modifier onlyPayer {
        require(msg.sender == payer);
        _;
    }

    modifier onlyNonContracts {
        require(msg.sender == tx.origin);
        // uint size;
        // address addr = msg.sender;
        // assembly { size := extcodesize(addr) }
        // require(size == 0);
        _;
    }

}

contract RewardSplitter is fundinglimited {

    address[] public investors;

    uint public lastPayBlock;
    uint256 public investorDeposit;
    bool public masternodeCancelled = false;

    MockMasternodeRegistrationContract registrationContract;

    function RewardSplitter(address _registrationContractAddr) public {
        registrationContract = MockMasternodeRegistrationContract(_registrationContractAddr);
        investorDeposit = registrationContract.nodeCost() / 4;
        lastPayBlock = now - 1 days;
    }

    function() public payable onlyPayer {
        require(investors.length == 4);

        // uint share = (msg.value - 0.1 ether) / 3;           // fixed fee
        uint share = (msg.value - (msg.value / 20)) / 3;    // 5% fee to operator

        if (share > 0.5 ether) {
            lastPayBlock = block.timestamp;
        }

        investors[0].transfer(share);
        investors[1].transfer(share);
        investors[2].transfer(share);
        investors[3].transfer(share);
        owner.transfer(address(this).balance);
    }

    function register() public payable onlyNonContracts {
        require(investors.length < 4);
        //require(msg.value == 5000 ether);
        require(msg.value == investorDeposit);
        investors.push(tx.origin);
        if (investors.length == 4) {
            if (!address(registrationContract).call.value(registrationContract.nodeCost()).gas(200000)(
                bytes4(keccak256("nodeRegistration()")), 4)) {
                revert();
            }

            // if (!address(registrationContract).call.value(registrationContract.nodeCost()).gas(200000)(
            //     bytes4(sha3("nodeRegistration()")), 4)) {
            //         revert();
            //     }
        }
    }

    function cancelInactiveNode(uint256 _userId) public {
        require(masternodeCancelled == false);
        require(_userId >= 0 && _userId < investors.length);
        require(tx.origin == investors[_userId]);
        if (now - 1 days > lastPayBlock) {
            masternodeCancelled = true;
            registrationContract.disableNode();
            registrationContract.withdrawStake();
        }
    }

    function withdraw(uint256 _userId) public onlyNonContracts {
        require(masternodeCancelled == true || investors.length < 4);
        require(_userId >= 0 && _userId < investors.length);
        require(tx.origin == investors[_userId]);
        investors[_userId] = address(0x0);
        //tx.origin.transfer(5000 ether);
        tx.origin.transfer(investorDeposit);
    }

    function getBalance() public constant returns(uint){
        return address(this).balance;
    }

    function canCancelInactiveNode() public constant returns(bool){
        if (masternodeCancelled == false && now - 1 days > lastPayBlock) {
            return true;
        } else {
            return false;
        }
    }

    function getInvestorAddress(uint256 _userId) public constant returns(address){
        if (_userId >= 0 && _userId < investors.length) {
            return address(0x0);
        } else {
            return investors[_userId];
        }
    }

}

