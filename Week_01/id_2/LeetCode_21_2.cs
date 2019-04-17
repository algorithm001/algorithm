using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace leetcode.合并两个有序链表
{
    public class ListNode
    {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    public class 合并两个有序链表
    {
        public ListNode MergeTwoLists(ListNode l1, ListNode l2)
        {
            ListNode head = new ListNode(int.MinValue);
            ListNode tail = head;
            while (l1 != null && l2 != null)
            {
                if (l1.val < l2.val)
                {
                    tail.next = l1;
                    l1 = l1.next;
                }
                else
                {
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }

            if (l1 != null)
            {
                tail.next = l1;
            }

            if (l2 != null)
            {
                tail.next = l2;
            }
            head = head.next;
            return head;
        }
    }
}
