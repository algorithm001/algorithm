2.0
//先设置链表头
//任一为空，直接连接另一条链表
//执行用时 : 2 ms, 在Merge Two Sorted Lists的Java提交中击败了99.44% 的用户
//内存消耗 : 35.3 MB, 在Merge Two Sorted Lists的Java提交中击败了90.56% 的用户
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode p = null;
        
        //if(l1 == null && l2 == null) return l1; 包含在下一句中
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        if(l1.val <= l2.val){
            head = l1;
            l1 = l1.next;
            p = head;
        }
        else{
            head = l2;
            l2 = l2.next;
            p = head;
        }
        
        while (l1 != null || l2 != null){
            ListNode t;
            if (l2 == null) {
                p.next = l1;
                break;
            }
            else if(l1 == null){
                p.next = l2;
                break;
            }
            else{
                if(l1.val <= l2.val){
                    t = l1;
                    l1 = l1.next;
                    p.next = t;
                p = p.next; 
                }
                else{
                    t = l2;
                    l2 = l2.next; 
                    p.next = t;
                    p = p.next;
                }
            }
        }
        return head;
    }
}


1.0
//先设置链表头
//任一为空，后续不高效
//执行用时 : 2 ms, 在Merge Two Sorted Lists的Java提交中击败了99.44% 的用户
//内存消耗 : 34.8 MB, 在Merge Two Sorted Lists的Java提交中击败了95.63% 的用户
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode p = null;
        
        //if(l1 == null && l2 == null) return l1; 包含在下一句中
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        if(l1.val <= l2.val){
            head = l1;
            l1 = l1.next;
            p = head;
        }
        else{
            head = l2;
            l2 = l2.next;
            p = head;
        }
        
        while (l1 != null || l2 != null){   //注意是 ||，不是&&
            ListNode t;
            if (l2 == null) {
                t = l1;
                l1 = l1.next;
                p.next = t;
                p = p.next;
            }
            else if(l1 == null){
                t = l2; 
                l2 = l2.next;
                p.next = t;
                p = p.next;
            }
            else{
                if(l1.val <= l2.val){
                    t = l1;
                    l1 = l1.next;
                    p.next = t;
                p = p.next; 
                }
                else{
                    t = l2;
                    l2 = l2.next; 
                    p.next = t;
                    p = p.next;
                }
            }
        }
        return head;
    }
}
