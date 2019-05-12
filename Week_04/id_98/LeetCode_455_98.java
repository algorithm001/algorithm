import java.util.Arrays;
class Solution {


    public int findContentChildren(int[] g, int[] s) {
        int res = 0,index = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for(int i=0;i<s.length;i++){
            if(s[i]>=g[index]){
                res++;
                index++;
                if(index>=g.length){
                    break;
                }
            }
        }
        return res;
    }
}