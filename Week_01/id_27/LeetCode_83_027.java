/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode curNode = head;
    	while(null != curNode && null != curNode.next) {
    		ListNode nextNode = curNode.next;
    		while(curNode.val == nextNode.val) {
    			curNode.next = nextNode.next;
    			nextNode = curNode.next;
    			if(null == nextNode) break;
    		}
    		curNode = nextNode;
    	}
    	return head;
    }
}
