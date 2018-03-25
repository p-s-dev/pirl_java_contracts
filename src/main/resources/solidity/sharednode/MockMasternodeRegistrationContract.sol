pragma solidity ^0.4.2;
contract MockMasternodeRegistrationContract {
    function nodeRegistration() public payable { }
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