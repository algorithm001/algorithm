class Solution {
    List<String> ret = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        if (S == null || S.length() <= 0)
            return ret;
        dfs(S.toCharArray(), 0);
        return ret;
    }
    
    public void dfs(char[] chs, int idx) {
        if (chs.length == idx) {
            ret.add(new String(chs));
            return;
        }
        if (Character.isLetter(chs[idx])) {
            chs[idx] = Character.toLowerCase(chs[idx]);
            dfs(chs, idx+1);
            chs[idx] = Character.toUpperCase(chs[idx]);
        }
        dfs(chs, idx+1);
    }
}
