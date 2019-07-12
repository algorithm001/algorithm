




public class Leetcode83 {


    public ListNode deleteDuplicates(ListNode head) {

        if(head==null){
            return null;
        }

        ListNode curNode=head;

        while(curNode!=null){
            if( curNode.next!=null && curNode.val==curNode.next.val){
                curNode.next=curNode.next.next;
            }
            curNode=curNode.next;
        }
        return head;
    }
}
