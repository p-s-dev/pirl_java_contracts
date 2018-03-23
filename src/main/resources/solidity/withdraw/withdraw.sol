pragma solidity ^0.4.2;

contract DepositInterface {
    function nodeRegistration() public payable;
    function disableNode() public;
    function withdrawStake() public;
}


contract DepositProxy {

    uint loops = 0;
    DepositInterface deposit;

    function DepositProxy(address _depositAddress) public {
        deposit = DepositInterface(_depositAddress);
    }

    function() public payable {
        if (loops > 0) {
            return;
        } else {
            loops++;
            deposit.withdrawStake();
        }
    }

    function nodeRegistration() public payable {
        deposit.nodeRegistration();
    }

    function disableNode() public {
        deposit.disableNode();
    }


    function withdrawStake() public {
        deposit.withdrawStake();
    }


  function callSetN(address _e, uint _n) {
    _e.call(bytes4(sha3("setN(uint256)")), _n); // E's storage is set, D is not modified
  }

  function callcodeSetN(address _e, uint _n) {
    _e.callcode(bytes4(sha3("setN(uint256)")), _n); // D's storage is set, E is not modified
  }

  function delegatecallSetN(address _e, uint _n) {
    _e.delegatecall(bytes4(sha3("setN(uint256)")), _n); // D's storage is set, E is not modified
  }


}
