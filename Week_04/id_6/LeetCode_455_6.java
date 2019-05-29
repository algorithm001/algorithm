

    // LeetCode 455

	
	// [ 1. 贪心算法 ]


    // 遍历每个孩子，依次选出适合他的最小饼干
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int num = 0;
        int curr = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = curr; j < s.length; j++) {
                curr++;
                if (g[i] <= s[j]){
                    num ++;
                    break;
                }

            }
            if (curr > s.length){
                break;
            }
        }

        return num;
    }