public class LeetCode_83_95 {//链表第一题
    public static ListNode deleteDuplicates(ListNode head) {
        
        //首先判断空
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode node = head;//相当于指针
        while(node.next != null){
            if(node.val == node.next.val){
                node.next = node.next.next;
            }else{
                node = node.next;//循环增加的条件
            }
        }
       return head;
    }
    
}

class ListNode{
    int val;//实际的值
    ListNode next;//下一节点
    public ListNode(int x){
        val = x;
    }
}