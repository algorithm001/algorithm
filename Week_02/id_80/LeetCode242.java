class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() == t.length()) {
            HashMap<Character, Integer> sMap = new HashMap<>();
            //HashMap<Character, Integer> tMap = new HashMap<>();
            char[] chars = s.toCharArray();
            char[] chart = t.toCharArray();
            for (char cs:chars){
                if (sMap.containsKey(cs)) {
                    int count = sMap.get(cs);
                    count++;
                    sMap.put(cs, count);
                } else {
                    sMap.put(cs, 1);
                }
            }
            for (char ct:chart){
                if(sMap.containsKey(ct)){
                    int count=sMap.get(ct);
                    count--;
                    if(count==0){
                        sMap.remove(ct);
                    }else{
                        sMap.put(ct,count);
                    }
                }else{
                    return false;
                }
            }
            return sMap.keySet().size() == 0;
        } else {
            return false;
        }
        
    }
}