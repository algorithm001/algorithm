class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0;
        for (int gi = 0, si = 0; gi < g.length && si < s.length; si++) {
            if (g[gi] <= s[si]) {
                cnt ++;
                gi ++;
            }
        }
        return cnt;
    }
}
