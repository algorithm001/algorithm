    static HeadList.ListNode mergeTwoLists(HeadList.ListNode l1, HeadList.ListNode l2){
        HeadList list = new HeadList();
        HeadList.ListNode tmp1 = l1.next;   //because of head node.
        HeadList.ListNode tmp2 = l2.next;
        while (true){
            if (tmp1 == null){
                for( ; tmp2 != null; tmp2 = tmp2.next){
                    list.insert(tmp2.val);
                }
                break;
            }
            else if (tmp2 == null){
                for( ; tmp1 != null; tmp1 = tmp1.next){
                    list.insert(tmp1.val);
                }
                break;
            }
            else if (tmp1.val > tmp2.val){
                list.insert(tmp2.val);
                tmp2 = tmp2.next;
            }
            else {
                list.insert(tmp1.val);
                tmp1 = tmp1.next;
            }
        }
        return list.getHead();
    }
