class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int num = 0;
        while(child < g.length && num < s.length){
            if(g[child] <= s[num]){
                child ++;
            }
            num ++;
        }
        return child;
    }
}