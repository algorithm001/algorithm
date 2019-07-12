public class Leetcode24 {

    public ListNode swapPairs(ListNode head) {

        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }

        ListNode dummyNode=new ListNode(0);

        dummyNode.next=head;

        ListNode curNode=dummyNode.next;

        ListNode nextNode=curNode.next;



        while(curNode!=null && nextNode !=null){

            ListNode secNode=nextNode.next;


            nextNode.next=curNode;

            curNode.next=secNode;

            curNode=secNode;

            nextNode=secNode.next;

        }
        return dummyNode.next;
    }
}
