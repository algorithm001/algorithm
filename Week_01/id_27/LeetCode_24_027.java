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

	   ListNode dummyHead = new ListNode(0);
	   dummyHead.next = head;

	   if(null == head || null == head.next) return head;
	   ListNode tail = dummyHead;
       ListNode cur = head;
       ListNode next = head.next;

       while(null !=cur && null != next) {
    	   ListNode tmp = next.next;
    	   cur.next = tmp;
    	   next.next = cur;
    	   if(null != tail) tail.next = next;//与上次操作做连接

    	   tail = cur;//记录这次操作的尾节点

    	   //开启新的一轮操作
    	   cur = tmp;
    	   if(null == cur) break;
    	   next = cur.next;
       }
       return dummyHead.next;

    }
}
