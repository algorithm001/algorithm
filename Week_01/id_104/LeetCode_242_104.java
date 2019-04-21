class Solution {
    public boolean isAnagram(String s, String t) {
        // 1.判断两个字符长度是否相等 不等返回false
        if(s==null && t==null ){
            return true;
        }
        if(s==null || t==null){
            return false;
        }
        
        if(s.length()!=t.length()){
            return false;
        }
        boolean result=true;
        int[] sAry=new int[26];
        int[] tAry=new int[26];
        for(int i=0;i<s.length();i++){
            sAry[s.charAt(i)-'a']++;
            tAry[t.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(sAry[i]!=tAry[i]){
                result=false;
                break;
            }
        }
        
        return result;
        
    }
}