class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int child = 0;
        int cookie = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (child < g.length && cookie < s.length ){
            if (g[child] <= s[cookie]){
                child++;
            }
            cookie++;
        }
        return child;
    }
}