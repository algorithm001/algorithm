// https://leetcode-cn.com/problems/assign-cookies/
// 455.分发饼干
// 解法：每次选一个胃口最小的孩子，给尺寸最小的饼干
class Solution {
    public int findContentChildren(int[] g, int[] s) {
       
        // 分别排序
        Arrays.sort(g);
        Arrays.sort(s);
        
        int i=0;
        int lastMatchIndex = -1;
    
        // 对每一个孩子 i ，从 s 里找第一个比它大的 j，能满足 s[j]>=g[i]（尺寸>=胃口）。
        // 若某个孩子 i 找不到比它大的 j，则终止，后面的孩子也一定得不到满足
        for(i=0;i<g.length;i++){
            boolean found = false;
            for(int j=lastMatchIndex+1;j<s.length;j++){
                if(s[j]>=g[i]){
                    lastMatchIndex = j;
                    found=true;
                    break;
                }
            }
            if(found==false){
                break;
            }
        }
        
        return i;
    }
    
}
