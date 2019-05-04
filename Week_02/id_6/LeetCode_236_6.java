

    // LeetCode 236


    // [ 1. 遍历树 ]
    // 查询节点，利用栈记录路径
    // 比对路径中最近的共同节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        // 遍历查询节点p
        findValToStack(root, p, stack);
        // 因为路径有顺序，所以val放入数组，用于比对
        // node存入hash表，用来查询
        int len = stack.size();
        int[] pPathVal = new int[len];
        HashMap<Integer, TreeNode> pMap = new HashMap<>();
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            pMap.put(treeNode.val, treeNode);
            pPathVal[len-1] = treeNode.val;
            len --;
        }

        stack.push(root);
        // 遍历查询节点q
        findValToStack(root, q, stack);
        len = stack.size();
        int[] qPathVal = new int[len];
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            qPathVal[len-1] = treeNode.val;
            len --;
        }

        // 比对数组中的数据，找到最后一个相同值
        len = Math.min(pPathVal.length, qPathVal.length);
        int j = 0;
        for (j = 0; j < len; j++) {
            if (pPathVal[j] != qPathVal[j]){
                break;
            }
        }

        return pMap.get(pPathVal[j-1]);
    }

    public void findValToStack(TreeNode node, TreeNode obj, Stack<TreeNode> stack){
        if (node == null){
            return;
        }

        // 前序遍历
        if (node.val == obj.val){
            stack.push(obj);
            return;
        }
        if (node.left != null){
            stack.push(node.left);
            // 找到结束递归
            if (node.left.val == obj.val){
                return;
            }else {
                findValToStack(node.left, obj, stack);
            }
        }
        if (node.right != null){
            stack.push(node.right);
            if (node.right.val == obj.val){
                return;
            }else {
                findValToStack(node.right, obj, stack);
            }
        }
        // 栈顶已经是查询值
        if (stack.peek().val == obj.val){
            return;
        }
        // 左右子树都没找到
        stack.pop();
    }

