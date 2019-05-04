/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    //暴力解法
    public ListNode detectCycle(ListNode head) {


		Set<ListNode> set = new HashSet<ListNode>();
		while (head != null) {
			if (set.contains(head))
				break;
			set.add(head);
			head = head.next;
		}
		return head;


    }

    public ListNode detectCycle2( ListNode head ) {
	   if( head == null || head.next == null ){
	   	return null;
	   }

	   //1、寻找相遇点
       ListNode fp = head, sp = head;
       while( fp != null && fp.next != null){
       	sp = sp.next;
       	fp = fp.next.next;
       	if( fp == sp ){
       		break;
       	}
       }

	   //2、没有环的情况直接退出
       if( fp == null || fp.next == null ){
       	return null;
       }

	   //3、有环时，slow起点设置为head，fast从相遇点出发，相遇点即为入环点
       sp = head;
       while( fp != sp ){
       	sp = sp.next;
       	fp = fp.next;
       }
       return sp;
    }
}
