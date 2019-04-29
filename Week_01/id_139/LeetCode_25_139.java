1，正常做


//执行用时 : 2 ms, 在Reverse Nodes in k-Group的Java提交中击败了88.82% 的用户
//内存消耗 : 40 MB, 在Reverse Nodes in k-Group的Java提交中击败了46.14% 的用户

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //先处理空链表，单节点链表
        //k=1，不用处理，直接返回
        if(head == null || head.next == null || k <= 1) return head;
        
        //dummyhead，维持初始位置
        ListNode dummyhead = new ListNode(-1);
        ListNode pre;
        ListNode temp;
        ListNode[] list = new ListNode[k];
        
        int total = 0;
        temp = head;
        //计算总长和循环次数
        while(temp != null){
            ++total;
            temp = temp.next;
        }
        int n = total/k;
        
        //temp回到head位置
        temp = head;
        //初始化dummyhead位置
        dummyhead.next = head;
        //初始化pre
        pre = dummyhead;
        
        int x = 1;
        int j; //在whie循环外声明j，会使得内存占用变高，38.5 ->40m
        while(x <= n){
            j = 0;
            
            //拿到k个节点
            for (;j<k;j++ ){
                list[j] = temp;
                temp = temp.next;
            }
            //把第一个节点和下一个循环第一个节点连上
            list[0].next = temp;
            for(j = 1;j <= k-1;j++){
                list[j].next = list[j-1];
            }
            //for语句里j++，k=2，会使得list[2]报错，所以要--
            j--;
            
            //将上一个循环连上此循环，并移动pre节点到此循环最后一个节点
            pre.next = list[j];
            pre = list[0];
            
            ++x;
        }
        return dummyhead.next;
    }
}


2，
leetcode里有递归做法
时间100%；
递归用到O(n)的栈空间。++
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        ListNode check = head;
        int canProceed = 0;
        int count = 0;
        // 检查链表长度是否满足翻转
        while (canProceed < k && check != null) {
            check = check.next;
            canProceed++;
        }
        // 满足条件，进行翻转
        if (canProceed == k) {
            while (count < k && cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                count++;
            }
            if (next != null) {
                // head 为链表翻转后的尾节点
                head.next = reverseKGroup(next, k);
            }
            // prev 为链表翻转后的头结点
            return prev;
        } else {
            // 不满住翻转条件，直接返回 head 即可
            return head;
        }
    }
}