using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace leetcode
{

    public class ListNode
    {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    public class 删除排序链表中的重复元素
    {
        public ListNode DeleteDuplicates(ListNode head)
        {
            if (head == null)
            {
                return null;
            }

            if (head.next == null)
            {
                return head;
            }

            if (head.val == head.next.val)
            {
                head.next = head.next.next;
                DeleteDuplicates(head);
            }
            else
            {
                DeleteDuplicates(head.next);
            }

            return head;
        }

        public ListNode DeleteDuplicates_recursive(ListNode head)
        {
            if (head == null)
            {
                return null;
            }


            ListNode currentNode = head;
            while (currentNode.next != null)
            {
                if (currentNode.val == currentNode.next.val)
                {
                    currentNode.next = currentNode.next.next;
                }
                else
                {
                    currentNode = currentNode.next;
                }
            }

            return head;
        }
    }
}
