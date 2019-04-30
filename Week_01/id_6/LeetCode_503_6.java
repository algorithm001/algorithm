


	// LeetCode 503
    // 遍历数组，每个数都和其后面的数据比较，直到循环回到自己的位置
    // 100,      1, 11, 1, 110, 109
    // 当前值   小  小  小  大
    // 那么[当前值 -> 110] 之间的数据，都应该用110替换。
    // 可以用栈来暂存这些数据。栈空表明区间内的所有数据都替换完成
	
    // 由于我们是替换数据，所以栈中存的应该是元素的索引值
	
	// 取一个元素，如果该元素比栈顶元素小，直接压栈
    // 如果比栈顶元素大，则开始替换栈中元素。最后将该元素压栈
    public int[] nextGreaterElements2(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        int[] rst = new int[len];
        Arrays.fill(rst, -1);

        // 由于是循环数组，遍历时长度取2*len
		// 长度超过len时，不再入栈
        for (int i = 0; i < 2 * len; i++) {
            int ii = i % len;
            // 出栈条件判断
            while (!stack.isEmpty() && nums[ii] > nums[stack.peek()]) {
                rst[stack.pop()] = nums[ii];
            }

            // 入栈条件判断
            // 由于当前元素可能导致出栈操作，所以要等出栈完成后，再做入栈判断
            if (i < len){
                stack.push(ii);
            }
        }

        return rst;
    }
	
	
	public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        int[] rst = new int[len];
        Arrays.fill(rst, -1);

        // 由于是循环数组，遍历时长度取2*len
        for (int i = 0; i < 2 * len; i++) {
            int ii = i % len;
            // 出栈条件判断
            if (!stack.isEmpty() && nums[ii] > nums[stack.peek()]) {
                while (!stack.isEmpty()) {
                    // 当前值不再大于栈顶值结束出栈
                    if (nums[ii] <= nums[stack.peek()]){
                        break;
                    }
                    rst[stack.pop()] = nums[ii];
                }
            }
            // 入栈条件判断
            // 由于当前元素可能导致出栈操作，所以要等出栈完成后，再做入栈判断
            if (i < len && stack.isEmpty()) {
                stack.push(ii);
                continue;
            }
            if (!stack.isEmpty() && nums[ii] <= nums[stack.peek()]) {
                if (i < len) {
                    stack.push(ii);
                }
            }

        }

        return rst;
    }