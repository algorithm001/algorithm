

    // LeetCode 241

	
	// [ 1. 分治 ]

    // 已运算符为界，  分为left和right，递归的计算
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> rst = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int val = 0;
        for (i = 0; i < input.length(); i++) {
            List<Integer> left = new ArrayList<Integer>();
            List<Integer> right = new ArrayList<Integer>();
            char c = input.charAt(i);
            if (c=='+' || c=='-' || c=='*'){
                left = diffWaysToCompute(input.substring(0, i));
                right = diffWaysToCompute(input.substring(i+1, input.length()));

                // 返回的两个集合再根据运算符合并
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        if (c == '+'){
                            val = left.get(j) + right.get(k);
                        }else if (c == '-'){
                            val = left.get(j) - right.get(k);
                        }else {
                            val = left.get(j) * right.get(k);
                        }
                        rst.add(val);
                    }
                }
            }
        }
        // 纯数字时
        if (rst.size() == 0){
            rst.add(Integer.valueOf(input));
        }
        return rst;
    }