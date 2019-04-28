package testForLC83;

public class LC83 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(2);
		ListNode node6 = new ListNode(3);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		LC83 lc = new LC83();
		lc.deleteDuplicates(node1);
		while(node1 != null) {
			System.out.println(node1.val);
			node1 = node1.next;
		}
	}
	
//	class Solution {
	    public ListNode deleteDuplicates(ListNode head) {
	        ListNode current = head;
	        while(null != current.next && null != current){
	            if(current.val == current.next.val){
	                current.next = current.next.next;
	            }else{
	                current = current.next;
	            } 
	        }
	        return head;
	    }
//	}

}
