static int findSecondMinimumValue(BinaryTree.TreeNode root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(Integer.MAX_VALUE);
        queue.add(Integer.MAX_VALUE);
        Stack<BinaryTree.TreeNode> s = new Stack<>();
        BinaryTree.TreeNode p = root;
        while (p != null || !s.isEmpty()) {
            while (p != null) {
                if (p.val < queue.peek()) {
                    int head = queue.poll();       //get the head.
                    if (p.val > queue.peek()) {
                        int tmp = queue.poll();
                        queue.add(p.val);
                        queue.add(tmp);
                    } else if (p.val < queue.peek()) {
                        queue.add(p.val);
                    } else {
                        queue.add(head);
                        int tmp = queue.poll();
                        queue.add(tmp);
                    }

                }
                s.push(p);
                p = p.left;
            }
            p = s.pop();
            p = p.right;
        }
        if (queue.peek() == Integer.MAX_VALUE) return -1;
        else return queue.poll();
    }