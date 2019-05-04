using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProblemSolutions
{
    public class Problem083 : IProblem
    {
        public class ListNode
        {
            public int val;
            public ListNode next;
            public ListNode(int x) { val = x; }
        }

        public void RunProblem()
        {
            throw new NotImplementedException();
        }

        public ListNode DeleteDuplicates(ListNode head)
        {
            /*
             * 当前结点，是在遍历的过程中做检测，是该移动一步，还是该排除掉一个重复的情况
             * 单链表基本操作的数量程度
             * 时间复杂度：O(n)，只是一次单链表的遍历
             * 空间复杂度：O(1)，使用的存储空间是固定的
             */

            ListNode cur = head;

            while(cur != null && cur.next != null)
            {
                if(cur.val != cur.next.val)
                {
                    cur = cur.next;
                    continue;
                }

                cur.next = cur.next.next;
            }

            return head;
        }
    }
}
