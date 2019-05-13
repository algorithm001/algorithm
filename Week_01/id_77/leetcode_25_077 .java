/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null){
            return null;
        }
        
        //记录头节点
        ListNode headPointer = head;
        //记录尾节点
        ListNode tailPointer = head;
        //记录节点个数
        int n = 0;
        while(tailPointer != null){
             n++;
            if(n == k){
                //k以后的节点递归处理
                ListNode tmpTail = reverseKGroup(tailPointer.next,k);
                //反转前k个节点 并链接尾节点
                reverseK(headPointer,k).next = tmpTail;
                break;
            }
             tailPointer = tailPointer.next;   
        }
        
        if(n < k){
            //不足k个节点 直接返回头节点
            return headPointer;
        }else{
            //有k个节点 返回反转后的头节点 即原来的尾节点
            return tailPointer; 
        }

       
    }
    
    public ListNode reverseK(ListNode head, int k){
        if(k == 1){
            return head;
        }
        ListNode headNew = reverseK(head.next,k-1);
        headNew.next = head;
        head.next = null;
     
        return head;
    }
    

}