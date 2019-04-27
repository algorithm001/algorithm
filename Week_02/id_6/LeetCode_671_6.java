

    // LeetCode 671


    // [ 3. 遍历树，利用栈保存最小值 ]
    // root 一定是最小的
    // 子节点 不小于 父节点，所以子树中大于root的最小值就是第二小值
    // 遍历除root外的所有节点，找大于root的最小值。 最小值用栈保存
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null){
            return -1;
        }

        Stack<Integer> stack = new Stack<>();

        findMinValToStack(root.left, stack, root.val);
        findMinValToStack(root.right, stack, root.val);

        if (stack.isEmpty()){
            return -1;
        }
        return stack.pop();
    }

    public void findMinValToStack(TreeNode node, Stack<Integer> stack, int val){
        if (node == null){
            return;
        }

        // 前序遍历
        // 当前节点值 > root， 可能入栈
        if (node.val > val){
            // 当前值 < 栈顶，替换栈顶值
            if (stack.isEmpty()){
                stack.push(node.val);
            }else {
                if (node.val < stack.peek()){
                    stack.pop();
                    stack.push(node.val);
                }
            }
        }
        findMinValToStack(node.left, stack, val);
        findMinValToStack(node.right, stack, val);
    }



    // [ 2. 树的递归 ]
    // root 一定是最小的
    // 子节点不小于节点，所以子树中大于root的最小值就是第二小值
    // min(left中大于root的最小值，right中大于root的最小值)
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null){
            return -1;
        }
        int n = findMinValGreaterRoot(root, root.val);
        if (n == root.val){
            return -1;
        }
        return n;
    }
    public int findMinValGreaterRoot(TreeNode node, int val) {
        if (node.left==null && node.right==null){
            return node.val;
        }
        // 右子树中大于root的最小值
        int minRight = node.right.val;
        if (node.right!=null){
            // 相等继续递归查询
            if (node.right.val == val){
                minRight = findMinValGreaterRoot(node.right, val);
            }
        }
        // 左子树中大于root的最小值
        int minLeft = node.left.val;
        if (node.left!=null){
            if (node.left.val == val){
                minLeft = findMinValGreaterRoot(node.left, val);
            }
        }
        int n = 0;
        if (minLeft!=val && minRight!=val){
            n = Math.min(minLeft, minRight);
        }else {
            n = Math.max(minLeft, minRight);
        }

        return n;
    }


	// [ 1. 利用数组 ]
    // 算出最大深度，按满树申请空间，将数的节点放入数组(每个节点都是正数，数组默认-1)
    // root=1，左=2*i，右=2*i+1
    // 数组排序
    public int findSecondMinimumValue(TreeNode root) {
        // 数的最大深度
        int len = getBinTreeDepth(root);
        if (len <= 1){
            return -1;
        }

        // 节点放入数组
        len = 2 << len;
        int[] node = new int[len];
		// 节点都是正数，-1表示非节点
        Arrays.fill(node, -1);
        putNodeToArray(root, node, 0);

        // 数组排序
        Arrays.sort(node);

        // 找第二小的值. 倒数第二个元素和前面的比较，
        // 如果有小于它的，则返倒数第二个元素
        // 否则，返-1
        int j = 0;
        for (; j < len; j++) {
            if (node[j] != -1){
                break;
            }
        }
        for (int k=j+1; k < len; k++) {
            if (node[j] < node[k]){
                return node[k];
            }
        }

        return -1;
    }
    // 遍历节点放入数组，满二叉树规则
    public void putNodeToArray(TreeNode root, int[]array, int i){
        if (root == null){
            return;
        }

        array[i] = root.val;

        putNodeToArray(root.left, array, 2*i+1);
        putNodeToArray(root.right, array, 2*i+2);

    }
    public int getBinTreeDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        return Math.max(getBinTreeDepth(root.left) + 1, getBinTreeDepth(root.left) + 1);
    }

    