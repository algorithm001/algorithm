package com.bugcodes.leetcode;

/**
 * Swap Nodes in Pairs
 *
 * @author bugcoder
 */
public class LeetCode_24_49 {

    /**
     * 非递归解决两两交换
     * @param head
     * @return
     */
    public ListNode swapPairsIterator(ListNode head){
        //先创建一个虚拟节点,并指向头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //创建一个游标节点cur，从dummy节点开始移动
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next !=null){
            //紧挨着dummy节点，再创建两个游标节点
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            //两两交换关键逻辑
            first.next = second.next;
            cur.next = second;
            cur.next.next = first;
            //把游标节点cur后移两位
            cur = cur.next.next;
        }
        return dummy.next;
    }

    /**
     * 递归解决两两交换
     * 把第一个节点看做一个节点，把剩余的几点看做一个节点
     * 1->2->3->4->5->6
     * 把节点1看做是一个节点A，把2->3->4->5->6这一大坨也看做是一个节点B
     * @param head
     * @return
     */
    public ListNode swapPairsRecursion(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        //创建一个游标节点，指向头指针的下一个节点
        // (这个节点反转以后会顶替前一个结点，1->2交换以后2->1)，
        ListNode next = head.next;
        //递归确定每个节点的next指针该指向哪个节点
        head.next = swapPairsRecursion(head.next.next);
        //游标节点需要指向上一个节点
        next.next = head;
        return next;
    }

}
