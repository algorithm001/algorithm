


    public ListNode deleteDuplicates(ListNode head) {

        if (head == null){
            return head;
        }

        // 遍历链表读取每个节点，如果是不重复节点插入新链表中
        // 判断节点是否重复的方法：
        // 每次读出节点，先去hash表中查询，如果存在，则为重复节点；否则，插入hash表和新链表
		// 引入hash表，为了可以支持无序的链表

        HashMap<Integer, Integer> map = new HashMap<>();
		
        // 遍历链表的节点指针. head节点是第一个，必然不会是因为重复要删除的节点
        map.put(head.val, head.val);
		
        ListNode current = head.next;
        // 新链表的尾节点.  插入队尾时用
        ListNode tail = head;

        while (current != null){
            // 没找到，说明不是重复节点，该节点加入新链表和hash表
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