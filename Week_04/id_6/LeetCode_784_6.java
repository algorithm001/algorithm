

    // LeetCode 784


    // [ 2. 回溯  ]

    // "a1b2"
    // 每个字符有两种选择
    // 第一种选择时，计算后面字符的所有组合（递归）
    // 第二种选择时，同样方式
    public List<String> letterCasePermutation(String S) {
        if (S.length() == 0){
            List<String> lt = new ArrayList<>();
            lt.add("");
            return lt;
        }

        List<String> rst = new ArrayList<>();
        dfs("", S, S.length(), rst);
        return rst;
    }


    public void dfs(String curr, String other, int len, List<String> rst){
        if (curr.length() == len){
            rst.add(curr);
            return;
        }

        for (int i = 0; i < other.length(); i++) {
            char c = other.charAt(i);
            if (Character.isAlphabetic(c)){
                // 每个字符有两种选择
                dfs(curr + Character.toLowerCase(c), other.substring(i+1, other.length()), len, rst);
                dfs(curr + Character.toUpperCase(c), other.substring(i+1, other.length()), len, rst);
                return;
            }else {
                curr = curr + c;
            }
        }

        // 都是数字 可以用递归，也可以i==length直接加入rst
        dfs(curr, "", len, rst);
    }


	
	// [ 1. 分治  ]

    // 第一个字符的集合 与 其它剩余字符集合 的组合
    // 其它剩余字符集合 递归用此方法
    public List<String> letterCasePermutation(String S) {
        if (S.length() == 0){
            List<String> lt = new ArrayList<>();
            lt.add("");
            return lt;
        }

        List<String> rst = new ArrayList<>();
        String num = "";
        int i = 0;
        for (i = 0; i < S.length(); i++) {
            // 找到字母停止循环
            char c = S.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                break;
            }
        }
        List<String> left = new ArrayList<>();
        List<String> right = new ArrayList<>();
        // 没找到字符
        if (i == S.length()){
            left.add(S);
            right.add("");
        }else {
            left.add(S.substring(0, i) + Character.toLowerCase(S.charAt(i)));
            left.add(S.substring(0, i) + Character.toUpperCase(S.charAt(i)));
            right = letterCasePermutation(S.substring(i+1, S.length()));
        }

        // 合并
        for (String p : left){
            for (String q : right){
                rst.add(p + q);
            }
        }

        return rst;
    }