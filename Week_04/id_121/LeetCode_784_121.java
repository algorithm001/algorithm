class Solution {
    public List<String> ret = new ArrayList<String>();
    public List<String> letterCasePermutation(String S) {

        char[] chars = S.toCharArray();
        int len = S.length();
        f(0,len,chars);
        return ret;
    }
    private void f(int i,int len,char[] chars){
        if(i == len ){
            //i == len - 1 会漏掉只有一个字符的情况
            ret.add(new String(chars));
            return;
        }
        if(chars[i] >= '0' && chars[i] <= '9'){
            f(i + 1,len,chars);
            return;
        }
        chars[i] =  Character.toLowerCase(chars[i]);
        f(i + 1,len,chars);

        chars[i] = Character.toUpperCase(chars[i]);
        f(i + 1,len,chars);
    }
}