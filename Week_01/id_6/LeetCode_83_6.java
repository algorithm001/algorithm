


    public ListNode deleteDuplicates(ListNode head) {

        if (head == null){
            return head;
        }

        // ���������ȡÿ���ڵ㣬����ǲ��ظ��ڵ������������
        // �жϽڵ��Ƿ��ظ��ķ�����
        // ÿ�ζ����ڵ㣬��ȥhash���в�ѯ��������ڣ���Ϊ�ظ��ڵ㣻���򣬲���hash���������
		// ����hash��Ϊ�˿���֧�����������

        HashMap<Integer, Integer> map = new HashMap<>();
		
        // ��������Ľڵ�ָ��. head�ڵ��ǵ�һ������Ȼ��������Ϊ�ظ�Ҫɾ���Ľڵ�
        map.put(head.val, head.val);
		
        ListNode current = head.next;
        // �������β�ڵ�.  �����βʱ��
        ListNode tail = head;

        while (current != null){
            // û�ҵ���˵�������ظ��ڵ㣬�ýڵ�����������hash��
            if (!map.containsKey(current.val)){
                System.out.println(current.val);
                map.put(current.val, current.val);
                tail.next = current;
                tail = current;
            }
            current = current.next;
        }
        tail.next = null;
        this.printNodes(head);
        return head;
    }