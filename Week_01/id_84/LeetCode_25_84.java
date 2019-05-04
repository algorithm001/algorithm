/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//思路：每遇到k个元素，就将原链段成子链，然后对断开的子链进行逆序。再合并。
class Solution {
    int length = 0;

    public ListNode reverseKGroup(ListNode head, int k) {
        length = this.ListLength(head);
        if ( length == 1 || k > length ) return head;
        //如果k=length，直接反转
        if(length  == k){
            return reverseList(head);
        }

        ListNode p1 = head; //p1为遍历指针
        ListNode p2 = head; //p2为指向子链
        int count = 1;
        head = null;
        while ( count <= length) {
            if (count % k != 0){
                p1 = p1.next;
            }

            else {

                ListNode temp = p1;
                p1 = p1.next;
                temp.next = null;
                temp = head;
                head = reverseList(p2);
                //head = mergeList(head, p1);
                head = mergeList(temp,head);
                p2 = p1;

            }
            ++count;


        }
        mergeList(head,p2);
        return head;
    }
//  链表长度
    public int ListLength(ListNode head) {
        int length = 0;
        if(head == null ){ return length;}
        while (head.next != null) {
            ++length;
            head = head.next;
        }
        return length + 1;
    }
//反转链表
    public ListNode reverseList(ListNode head) {
        if (head  == null) return null;
        if (head.next == null) return head;
        ListNode p = reverseList(head.next);;
        head.next.next = head;
        head.next = null;
        return p;

    }
//合并两个链表
    public ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode temp = head1;
        if (temp != null) {
            while (head1.next != null) {
                head1 = head1.next;
            }
            head1.next = head2;
            return temp;
        }
        else return head2;
    }


}