    static HeadList.ListNode swapPairs(HeadList.ListNode head){
        HeadList.ListNode pre, tmp, tail;
        pre = head;
        while (true){
            if (pre.next == null)   break;
            if (pre.next.next == null)  break;
            tmp = pre.next;
            tail = pre.next.next.next;
            pre.next = pre.next.next;
            pre.next.next = tmp;
            tmp.next = tail;
            pre = pre.next.next;
        }
        return head;
    }
