package algorithm.Week_01.id_58;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

/**
 * 21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.*
 * 分析：
 * 由于是排好序的，直接用归并排序的算法即可
 * @auther: guangjun.ma 
 * @date: 2019/4/18 10:33
 * @version: 1.0
 */
public class LeetCode_21_058 {

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //创建一个虚拟头结点
            ListNode dummyHead = new ListNode(0);
            //声明一个当前操作指针
            ListNode current = dummyHead;

            //当两个链表都不为空
            while (l1 !=  null && l2 !=  null){
                //从第一个链表l1取值，从第二个链表l2取值，如果小于l1值小，则加入到新的链表中
                if (l1.val < l2.val){
                    current.next = l1;
                    //各后移一位，两个操作可以互换，不影响
                    //l1后移
                    //current当前指针后移
                    l1 = l1.next;
                    current = current.next;
                }else{
                    //如果l1的值大，则将l2加入到新链表中
                    current.next = l2;
                    l2 = l2.next;
                    current = current.next;
                }
            }

            //如果都插入完毕后，发现还有剩余的元素，则把剩下的元素全部，连接到新的链表中
            if (l1 == null){
                current.next = l2;
            }else{
                current.next = l1;
            }
            //返回链表头结点
            //注意这里是dummyHead.next，虚拟结点的下一个结点
            return dummyHead.next;
        }
    }


}
