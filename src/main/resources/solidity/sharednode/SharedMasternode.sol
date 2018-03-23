pragma solidity ^0.4.2;

/**


Rules:

  a majority of contributors can end payment period at any time?
  funds are locked for a minimum period, no matter if operator is active?
  lock period can be ended if operator shown to be inactive? (contributor can claim mn is not getting paid like it should be)
  operator has time period in which to dispute inactive claim. ( they can submit a transaction which shows mn is getting paid)



**/

contract SharedMasternode {

//address[] users = {};
//int count_users = 0;
//int partitions = 1;  // number of funders to divide the 20k between
//
//address mn_deposit_contract = 0xFFFF;
//address developer = 0x000;
//address operator = 0x1111;
//address min_lock_period; // number of blocks that deposits will be locked, no matter if operator is active
//
//int balance_at_freeze = 0;
//int contributor_payment_share = 0;
//
//int operator_fee_percent = 9;
//int developer_fee_percent = 1;
//int operator_fee = 0;
//int developer_fee = 0;
//
//bool started = false;
//
//public contribute(int positionId) {
//assert (positionId > 0 && positionId < partitions)
//assert (msg.value=20k/partitions);
//assert (count_users < partitions);
//assert (users[positionId] == 0x000)
//assert(started == false)
//
//address[positionId] = msg.sender;
//count_users++;
//}
//
//public unncontribute(int positionId) {
//
//assert (msg.value=0);
//assert (users[positionId] == msg.sender)
//
//assert (count_users < partitions);
//assert(started == false)
//
//address[positionId] = 0x0;
//count_users--;
//}
//
//
//public start_lockout(int userid) {
//assert(this.value = 20k)
//assert(started == false)
//assert(users[userid] == msg.sender) // only member can initiate the deposit
//msg.send(this.value)(	mn_deposit_contract )
//started = true;
//
//}
//
////TODO when to allow end payment period?  How to prove operator inactive?
//public end_lockout(int userid) {
//// freeze claims.  future mn payments will not be available to be claimed.
//
//// if current block
//
//balance_at_freeze = this.value;
//// take total, minus dev, minus operator, divide by participants, save in contributor_payment_share;
//
//}
//
//
//
//public claim (int positionId) {
//
//if (users[positionId] == msg.sender) {
//users[positionId] = 0x0;
//msg.send(msg.sender)(contributor_payment_share);
//
//}
//
//}
//



}