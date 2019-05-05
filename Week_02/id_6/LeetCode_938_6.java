

    // LeetCode 938


    // [ 1. 遍历树 ]
    // 遍历，把值在 [L,R] 之间的所有节点找出来
    public int rangeSumBST1(TreeNode root, int L, int R) {
        if (root == null){
            return 0;
        }
        // 栈保存合法值
        Stack<Integer> stack = new Stack<>();
        findValInRegion(root, L, R, stack);
        // 累加
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }

    // 属于区间的存入栈，同时利用搜索树的特点
    public void findValInRegion(TreeNode root, int L, int R, Stack<Integer> stack){
        if (root == null){
            return;
        }

        if (root.val >= L && root.val <= R){
            stack.push(root.val);
        }
        if (root.val <= L){
            findValInRegion(root.right, L, R, stack);
        }else if (root.val >= R){
            findValInRegion(root.left, L, R, stack);
        }else {
            findValInRegion(root.left, L, R, stack);
            findValInRegion(root.right, L, R, stack);
        }
    }


    // 属于区间的存入栈，当做普通二叉树，遍历所有节点
    public void findValInRegion(TreeNode root, int L, int R, Stack<Integer> stack){
        if (root == null){
            return;
        }
        // left小于
        if (root.val >= L && root.val <= R){
            stack.push(root.val);
        }

        findValInRegion1(root.left, L, R, stack);
        findValInRegion1(root.right, L, R, stack);
    }


