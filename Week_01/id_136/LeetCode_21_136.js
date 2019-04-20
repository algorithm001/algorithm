/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    let p1 =l1;
    let p2 =l2;
    let dummy = new ListNode(null);
    dummy.next = p1;
    let prev = dummy;
    while(p1 && p2){
        if(p1.val < p2.val){
            prev = p1;
            p1 = p1.next;
        }else{
            prev.next = p2;
            p2 = p2.next;
            prev = prev.next;
            prev.next = p1;
        }
    }
    if(p2){
        prev.next = p2;
    }
    
    return dummy.next;
    
};