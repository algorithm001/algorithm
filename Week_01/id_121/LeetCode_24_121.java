/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null ){
            return null;
        }
        if(head.next == null){
            return head;
        }

        ListNode preNode = head;
        ListNode curNode = head.next;
        ListNode retNode = curNode;
        ListNode newPreNode = null;
        while(preNode != null && curNode != null){
            removeCurNode(preNode,curNode);
            insertBeforeCurNode(newPreNode,preNode,curNode);
            preNode = curNode.next.next;
            newPreNode = curNode.next;
            if(preNode != null){
                curNode = preNode.next;
            }
        }
        return retNode;
    }

    private void removeCurNode(ListNode preNode,ListNode curNode){
        if(preNode != null){
            preNode.next = curNode.next;
        }
        curNode.next = null;
    }
    private void insertBeforeCurNode(ListNode preNode,ListNode curNode,ListNode node){
        node.next = curNode;
        if(preNode != null){
            preNode.next = node;
        }
    }
}