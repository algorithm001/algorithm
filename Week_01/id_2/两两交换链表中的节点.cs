using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace leetcode.两两交换链表中的节点
{

    public class ListNode
    {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    public class 两两交换链表中的节点
    {
        public ListNode SwapPairs(ListNode head)
        {
            ListNode a = new ListNode(int.MinValue);
            ListNode b = head;
            ListNode c = head?.next;
            a.next = head;
            head = a;

            while (b != null && c != null)
            {
                var temp = c.next;
                c.next = b;
                b.next = temp;
                a.next = c;
                a = b;
                b = b?.next;
                c = b?.next;
            }
            head = head.next;

            return head;
        }

        public ListNode SwapPairs_recursive(ListNode head)
        {
            if (head == null || head.next == null)
            {
                return head;
            }

            var next = head.next;
            head.next = SwapPairs_recursive(next.next);
            next.next = head;
            return next;
        }

        public void Printf(ListNode ListNode)
        {
            while (ListNode != null)
            {
                Console.WriteLine(ListNode.val);
                ListNode = ListNode.next;
            }
        }
    }
}
