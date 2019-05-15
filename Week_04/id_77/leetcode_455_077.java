class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int lg = g.length;
        int ls = s.length;
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int currChild = -1;
        for(int i = 0;i<ls;i++){
            for(int j = currChild + 1;j<lg;j++){
                if(s[i]>=g[j]){
                    currChild = j;
                    count ++;
                    break;
                }
            }
        }

        return count;
    }
}