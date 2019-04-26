

    // LeetCode 671
	
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

    