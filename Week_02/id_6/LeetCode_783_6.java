

    // LeetCode 938


    // [ 1. 遍历树 ]
    // 中序遍历得到一个，得到数组，然后计算两两差值
    // 效率比较低
    public int minDiffInBST(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        traverseBSF(root, stack);

        int[] array = new int[stack.size()];
        for (int i = 0; !stack.isEmpty(); i++) {
            array[i] = stack.pop();
        }

        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int m = array[i] - array[j];
                if (stack.isEmpty()){
                    stack.push(m);
                }else {
                    if (m < stack.peek()){
                        stack.pop();
                        stack.push(m);
                    }
                }
            }
        }

        return stack.pop();
    }

    // 中序遍历，有序输出
    public void traverseBSF(TreeNode root, Stack<Integer> stack){
        if (root == null){
            return;
        }

        traverseBSF(root.left, stack);
        stack.push(root.val);
        traverseBSF(root.right, stack);
    }


