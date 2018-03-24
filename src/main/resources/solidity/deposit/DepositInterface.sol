pragma solidity ^0.4.2;

contract MockMasternodeRegistrationContract {
    bool nodeEnabled = false;
    function nodeRegistration() public payable;
    function disableNode() public;
    function withdrawStake() public;
    function getNodeEnabledStatus() public constant returns(bool) {

    }
    function nodeCost() public constant returns(uint256);
}
