

	// ����������ͨ���Ƚϣ�����Ĳ��뵽�µ�����
    // �����ڱ��ڵ㣬���ٴ��븴�Ӷ�
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        System.out.println("mergeTwoLists2");
        if (l1 == null){
            return l2;
        }
            if (l2 == null){
            return l1;
        }

        // �ڱ��ڵ�
        ListNode temp = new ListNode(0);
        ListNode head = temp;
        ListNode tail = temp;
        // ���ı�ԭʼ����
        ListNode current1 = l1;
        ListNode current2 = l2;
            while (current1 != null && current2 != null){
            // ˭С˭����������
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
        // ʣ���б���������
            if (current1 == null){
            tail.next = current2;
        }else {
            tail.next = current1;
        }

        return head.next;
    }