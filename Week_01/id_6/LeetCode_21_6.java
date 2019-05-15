

	// 将两个链表通过比较，有序的插入到新的链表
    // 引入哨兵节点，减少代码复杂度
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        System.out.println("mergeTwoLists2");
        if (l1 == null){
            return l2;
        }
            if (l2 == null){
            return l1;
        }

        // 哨兵节点
        ListNode temp = new ListNode(0);
        ListNode head = temp;
        ListNode tail = temp;
        // 不改变原始参数
        ListNode current1 = l1;
        ListNode current2 = l2;
            while (current1 != null && current2 != null){
            // 谁小谁插入新链表
            if (current1.val <= current2.val){
                tail.next = current1;
                tail = current1;
                current1 = current1.next;
            }
            else {
                tail.next = current2;
                tail = current2;
                current2 = current2.next;
            }
        }
        // 剩余列表并入新链表
            if (current1 == null){
            tail.next = current2;
        }else {
            tail.next = current1;
        }

        return head.next;
    }