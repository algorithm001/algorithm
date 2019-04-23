    static HeadList.ListNode detectCycle(HeadList.ListNode head){
        Map<HeadList.ListNode,Integer> map = new HashMap<>();
        HeadList.ListNode tmp = head;
        int pos = 0;
        while (tmp != null){    //JC:   tmp.next == null
            if (map.get(tmp) == null){  //JC:   map.get() return something
                map.put(tmp,pos);
                tmp = tmp.next;
                pos++;
            }
            else break;
        }
        return tmp;
    }
