pragma solidity ^0.4.2;

contract DepositInterface {
    function nodeRegistration() public payable;
    function disableNode() public;
    function withdrawStake() public;
    function getNodeEnabledStatus() constant returns(bool index);
}
