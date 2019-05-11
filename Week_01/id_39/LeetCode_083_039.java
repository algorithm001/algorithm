package com.paula.algorithmsAndDataStructure.leetCode_83;

public class LeetCode_083_039 {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return null;
		
		ListNode p = head;
		ListNode q = null;
        while(p.next != null) {
        	if(p.val == p.next.val) {
        		if(q == null || (q != null && q.val != p.val)) {
        			q = p;
        		}
        	}else {
        		if(q != null && q.val == p.val) {
        			q.next = p.next;
        		}
        	}
        	p = p.next;
        }
        
        if(q != null && p.val == q.val && p.next == null) {
        	q.next = null;
        } 
		return head;
    }

}
