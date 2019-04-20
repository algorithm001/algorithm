/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //1 遍历集合
        Set<Integer> sets=new HashSet();
        if(head==null){
            return head;
        }
        ListNode cur=head;
        while(cur.next!=null){
            //将当前元素值 存在Set集合里 进行判重
            sets.add(cur.val);
            //3 判断下个元素是否已经在map中存在 如果存在则删除此元素
            if(sets.contains(cur.next.val)){
                cur = removeNextNode(cur);             
            }
            if(cur==null){
                //异常数据 跳出循环 
                break;
            }
            cur=cur.next;      
        }
        //4 打印最后的对象
        ListNode printNode=head;
        while(printNode!=null){
            System.out.println(printNode.val);
            printNode=printNode.next;
        }
        return head;
    }
    
    /**
    * 删除下一个元素
    * node 当前元素
    **/
    private ListNode removeNextNode(ListNode node){
         if(node==null){
             return null;
         }
         if(nodex.next==null){
             return node;
         }
         node.next=nodex.next.next;
         return node;
          
    }
}