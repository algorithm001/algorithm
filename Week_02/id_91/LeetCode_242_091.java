class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }
        //hash表 可以用map 和 数组 实现 下标可以作为key
        //一个++ 一个--
        //想办法用hashmap 存储
        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else{
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
            if(!map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),-1);
            }else{
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
            }
        }

        for(Map.Entry<Character,Integer> entry:map.entrySet()){

            if(entry.getValue()!=0){
                return false;
            }

        }
        return true;

    }
}