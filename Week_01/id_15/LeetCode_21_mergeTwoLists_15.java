package com.haotone.week_01;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
    	ListNode hummy = new ListNode(-1);
    	ListNode cur = hummy;
    	while(l1!=null || l2!=null){
    		if(l1 == null){
    			cur.next = l2;
    			cur = l2;
    			l2 = l2.next;
    		}else if(l2 == null){
    			cur.next = l1;
    			cur = l1;
    			l1 = l1.next;
    		}else{
    			if(l1.val>l2.val){
        			cur.next = l2;
        			cur = l2;
        			l2 = l2.next;
        		}else{
        			cur.next = l1;
        			cur = l1;
        			l1 = l1.next;
        		}
    		}
    		
    	}
    	return hummy.next;
    }
}