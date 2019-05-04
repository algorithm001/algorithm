using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AlgorithmTest
{ 
    public class LeetCode_083_086
    {
        /// <summary>
        /// 92ms 23.9MB
        /// </summary>
        /// <param name="head"></param>
        /// <returns></returns>
        public ListNode MethodFor093_1(ListNode head)
        {
            if (head == null)
                return null;
            if (head.next == null)
                return head;
            else
            {
                ListNode listNode = head;
                while (listNode.next != null)
                {
                    if (listNode.next.val == listNode.val)
                    {
                        listNode.next = listNode.next.next;
                    }
                    else
                    {
                        listNode = listNode.next;
                    }
                }
            }

            return head;
        }
    }
}
