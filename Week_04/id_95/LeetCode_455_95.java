class LeetCode_455_95 {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
 
        Arrays.sort(g);
        Arrays.sort(s);
 
        for (int i = 0,j = 0; i < g.length && j < s.length; ) 
            if (g[i] <= s[j]){
                count++;
                i++;
                j++;
            }else j++;
 
        return count;
    }
}