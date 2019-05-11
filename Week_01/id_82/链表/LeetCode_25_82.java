    static HeadList.ListNode reverseKGroup(HeadList.ListNode head, int k){
        if(k == 1 || k == 0) return head;
        HeadList.ListNode detect, pre, segPre, segTmp, tail, tailNext;
        if (head.next == null)  return head;
        segPre = head;
        detect = pre = segTmp = head.next;
        if (head.next.next == null) return head;
        tail = pre.next;
        tailNext = tail.next;
        while (true){
            int i = 0;
            for ( ; i < k; i++){
            if (detect == null){
                segPre.next = tailNext;
                return head;
            }
            else detect = detect.next;
            }
            for (int j = 0; j < k - 1; j++){    //K-1:N elements need N reverses.
                tail.next = pre;
                pre = tail;

                tail = tailNext;
                if (tailNext != null)  tailNext = tailNext.next;

            }
            segPre.next = pre;
            pre = tail;
            tail = tailNext;
            if (tailNext != null)  tailNext = tailNext.next;
            segPre = segTmp;
            segTmp = pre;
        }
    }
