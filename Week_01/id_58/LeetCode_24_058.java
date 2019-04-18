package algorithm.Week_01.id_58;

/**
 * 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 *分析：这里主要考察就是链表的指针操作，需要用三个指针操作，注意这里需要做的就每次跳步是2步！！
 * 1-2  3-4  5-6，即 cur先指向1 然后指向3，以此类推。。
 * @auther: guangjun.ma 
 * @date: 2019/4/18 13:04
 * @version: 1.0
 */
public class LeetCode_24_058 {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    class Solution {
        public ListNode swapPairs(ListNode head) {
            //定义一个虚拟结点
            ListNode dummy = new ListNode(-1);
            //定义一个前结点指针  pre
            ListNode pre = null;
            //定义一个当前结点指针 cur
            ListNode cur = null;

            //初始化位置
            //让虚拟结点和head结点链接，最后直接返回虚拟结点的下一个结点即是头结点
            dummy.next = head;
            //pre的初始位置，是当前虚拟结点，
            // 即当前结点的前面的结点，
            // 即操作的两个结点的前面的一个结点，来维护操作的两个结点和前面结点的关系的
            pre = dummy;
            //当前结点，指向当前操作的两个结点中的第一个结点，初始化是dummy.next，即head头结点
            // 也可以写为cur = head;
            cur = dummy.next;

            //这里是核心操作！！！
            // 判断条件是结点非空，当前结点的后的一个结点非空，
            // 即保证操作的元素必须是两个结点的单位，1-2  3-4
            // 如果是只有一个结点，则不操作，
            // 如果是空结点也不操作
            while(cur != null && cur.next != null){
                //声明一个last结点指针，主要是操作两个两个结点的后一个结点，
                // last的初始位置是cur的下一个结点
                ListNode last = cur.next;
                //当前结点的next指针指向last的下一个元素，即cur结点的下一个结点的指针变化为第三个元素
                //假设初始结点是0- 1 - 2 - 3 - 4  ，现在是 0-1-3-4  2
                // 2结点的位置保存在last中
                cur.next = last.next;
                //last结点的next指针变成了当前结点 ，现在是 2-1
                //还有上一个步骤结果 0-1-3-4
                //   0-1-3-4
                //     \
                //      2
                last.next = cur;
                //现在就是要链接两个片段
                //pre结点的next指向了last结点，即虚拟结点指向了2结点   0-2-1   即0-2-1-3-4
                //这样就完成了1 2 结点的位置互换
                //     1-3-4
                //     \
                //      2
                //       \
                //        0
                pre.next = last;

                //接下来就是移动元素，开始操作3 、4元素
                //pre指向当前结点，cur=1
                //注意这里不是往后移了一位而是两位，  pre指向了0-2-1-3-4 中的1
                pre = cur;
                //cur指针后移一位，就是3。这样就开始了以3-4为操作单元的的操作单元
                cur = cur.next;
            }

            return dummy.next;
        }
      }
}
