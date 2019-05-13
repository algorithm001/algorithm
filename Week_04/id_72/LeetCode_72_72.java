class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        if (word1.length() == 0 && word2.length() == 0) {
            return 0;
        }
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        char[] array1 = word1.toCharArray();
        char[] array2 = word2.toCharArray();
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (array1[i - 1] == array2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[n][m];
    }

    private int min(int x, int y, int z) {
        int min = Integer.MAX_VALUE;
        if (x < min) {
            min = x;
        }
        if (y < min) {
            min = y;
        }
        if (z < min) {
            min = z;
        }
        return min;
    }
}