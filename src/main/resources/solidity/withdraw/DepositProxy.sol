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

}
