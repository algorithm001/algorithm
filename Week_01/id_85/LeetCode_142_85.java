import java.util.HashMap;

public class LeetCode_142_85 {

}
/**
 * @Package:
 * @ClassName: LeetCode_142_85.LinkedListCycleII
 * @Description: 给定一个链表，返回链表开始入环的第一个结点。 如果链表无环，则返回 null 难度：中
 * @leetCode url : https://leetcode.com/problems/linked-list-cycle-ii/
 * @Author: wangzhao
 * @Date: 2019-04-16 13:24:35
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class LinkedListCycleII {

    /**
     *
     * 利用哈希表保存已出现的结点，
     * 如果该结点存在，则返回该结点
     *
     */
    public ListNode detectCycle(ListNode head) {
        if (head==null){
            return head;
        }
        HashMap<ListNode,Integer> map = new HashMap<>();
        while (head.next!=null){

            if (map.get(head)!=null){
                return head;
            }else {
                map.put(head,1);
            }
            head = head.next;
        }


        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head==null){
            return null;
        }

        return null;
    }


    public static void main(String[] args) {
        Integer[] arr = {0, 1, 2, 3, 4, 6, 7, 8};

        //初始化一个无用结点。去除边界问题
        ListNode cur = new ListNode(-1);
        ListNode head = cur;

        ListNode cycleNode = null;

        for (int i = 0; i < arr.length; i++) {

            cur.next = new ListNode(arr[i]);
            if (i == 4) {
                //摘取入环结点
                cycleNode = cur.next;
            }
            cur = cur.next;
            if (i == arr.length - 1) {
                //链表尾结点指向入环结点
                cur.next = cycleNode;
            }
        }


        /**
         * 循环去重
         */
        ListNode resultNode = new LinkedListCycleII().detectCycle(head.next);
        ListNode node = head.next;
        int i=-1;
        while (node != null&&resultNode!=null) {
            i++;
            if (node==resultNode){
                break;
            }
            node = node.next;
        }
        System.out.println("入环位置:"+i);
    }
}