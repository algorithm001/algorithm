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
        Map<Character,Integer> sMaps=new HashMap();
        Map<Character,Integer> tMaps=new HashMap();
        //默认值
        int defaultNum=0;
        Character tmpChar;
        Integer v;
        // 初始化字典集合 用空间换时间
        for(int i=0;i<s.length();i++){
            Integer n=sMaps.get(s.charAt(i));
            sMaps.put(s.charAt(i),(n==null?1:++n));
        }
        // 3.遍历字符串，判断其中字符是否在另外一个字符串中存在，不存在则退出
        for(int i=0;i<t.length();i++){
            tmpChar=t.charAt(i);
            v=sMaps.get(tmpChar);
            if(v==null ){
                break;
            }
            v--;
            sMaps.put(tmpChar,v);
            if(v==0){
                sMaps.remove(tmpChar);
            }
        }
        System.out.println(sMaps.size());
        return sMaps.size()==0;
    }
}g