1. set
//执行用时 : 17 ms, 在Linked List Cycle II的Java提交中击败了18.90% 的用户
//内存消耗 : 35.9 MB, 在Linked List Cycle II的Java提交中击败了6.94% 的用户

public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<Object> set = new HashSet(); 
        while(head != null){
            if (set.contains(head)) return head;    
            else{
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }
}




2，快慢指针
解题思路：分两个步骤，首先通过快慢指针的方法判断链表是否有环；接下来如果有环，
则寻找入环的第一个节点。具体的方法为，首先假定链表起点到入环的第一个节点A的长度为a【未知】，
到快慢指针相遇的节点B的长度为（a + b）【这个长度是已知的】。现在我们想知道a的值，
注意到快指针p2始终是慢指针p走过长度的2倍，所以慢指针p从B继续走（a + b）又能回到B点，
如果只走a个长度就能回到节点A。但是a的值是不知道的，解决思路是曲线救国，注意到起点到A的长度是a，
那么可以用一个从起点开始的新指针q和从节点B开始的慢指针p同步走，相遇的地方必然是入环的第一个节点A。 
文字有点绕，画个图就一目了然了~~·

public class Solution { public ListNode detectCycle(ListNode head) { if (head == null) return null;
  ListNode p = head, p2 = head;
    boolean hasCycle = false;
    while (p2.next != null && p2.next.next != null) {
        p = p.next;
        p2 = p2.next.next;
        if (p == p2) {
            hasCycle = true;
            break;
        }
    }
    
    // 步骤二：若有环，找到入环开始的节点
    if (hasCycle) {
        ListNode q = head;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return q;
    } else 
        return null;
}

