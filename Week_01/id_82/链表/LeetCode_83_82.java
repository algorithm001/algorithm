static HeadList.ListNode deleteDuplicates(HeadList.ListNode head) {
        Map<Integer,HeadList.ListNode> map = new HashMap<>();
        HeadList.ListNode tmp = head;
        while (tmp != null){  //JC:   tmp.next == null
            if(map.get(tmp.val) == null){  //JC:   map.get() return something
                map.put(tmp.val,tmp);
            }
            else HeadList.delete(head,tmp);
            tmp = tmp.next;
        }
        return head;
    }