
//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/

//Given a sorted linked list, delete all duplicates such that each element appear only once.

//1，前后节点比对（注意发生重复时，pre保持不变。不重复时，pre前移）
//执行用时 : 2 ms, 在Remove Duplicates from Sorted List的Java提交中击败了57.30% 的用户
//内存消耗 : 36.5 MB, 在Remove Duplicates from Sorted List的Java提交中击败了68.83% 的用户

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;  //防止 head为null
        ListNode p = head.next;
        ListNode pre = head;
        while( p != null ){
            if (pre.val == p.val){
                pre.next = p.next;
                p = p.next; 
            }
            else{
                pre = p;
                p = p.next;   
            }  
        }
        return head;
    }
}

//java.lang.NullPointerException具体意思是空指针异常，最常见的问题就是没有初始化。
//字符串等数据类型没有初始化，例：链表中的字符代码没加 if (head == null) return head;



//2，set做法（适合无序链表）
//执行用时 : 7 ms, 在Remove Duplicates from Sorted List的Java提交中击败了5.10% 的用户
//内存消耗 : 36.3 MB, 在Remove Duplicates from Sorted List的Java提交中击败了75.05% 的用户

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Object> set = new HashSet<>();
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode p = head;
        
        while( p != null ){
            if (set.contains(p.val)){
                pre.next = p.next;
                p = p.next; 
            }
            else{
                set.add(p.val);
                pre = p;
                p = p.next;   
            }  
        }
        return head;
    }
}


//3，递归（时间效率很差）
//执行用时 : 3 ms, 在Remove Duplicates from Sorted List的Java提交中击败了6.53% 的用户
//内存消耗 : 36.3 MB, 在Remove Duplicates from Sorted List的Java提交中击败了74.62% 的用户
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = deleteDuplicates(head.next);
        if (head.val == p.val) head.next = p.next;
        return head;
    }
}

//1,找终止条件：当head指向链表只剩一个元素的时候，自然是不可能重复的，因此return
//2,想想应该返回什么值：应该返回的自然是已经去重的链表的头节点
//3,每一步要做什么：宏观上考虑，此时head.next已经指向一个去重的链表了，而根据第二步，我应该返回一个去重的链表的头节点。
//因此这一步应该做的是判断当前的head和head.next是否相等，如果相等则说明重了，返回head.next，否则返回head