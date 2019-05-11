package testForLC24;

import testForLC24.LC24;
import testForLC24.ListNode;

public class LC24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		LC24 lc = new LC24();
		ListNode res =  lc.swapPairs(node1);
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	
	public ListNode swapPairs(ListNode head) {
        if(null == head || null == head.next) return head;
        ListNode res = head.next;
        ListNode current = head;
        ListNode next = head.next;
        ListNode temp = null;
        ListNode pre = head.next;
        while( current !=null && current.next != null){
            temp = current.next.next;
            next = current.next;
            
            pre.next = next;
            next.next = current;
            current.next = temp;
            
            pre = current;
            current = temp;
        }
        return res;
    }
	
}
