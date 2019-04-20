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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        HashSet key = new HashSet();
        key.add(head.val);
        ListNode node=head.next;
        ListNode pre = head;
        while(node!=null){
            if(key.contains(node.val)){
                pre.next = pre.next.next;
            }
            else{
                key.add(node.val);
                pre = node;
            } 
             node = node.next;
        }
        return head;
        
    }
}