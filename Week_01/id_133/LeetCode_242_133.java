class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        HashMap<Character, Integer> sMap = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if (sMap.get(ch) == null) {
                sMap.put(ch, 1);
            } else {
                Integer integer = sMap.get(ch);
                integer++;
                sMap.put(ch,integer);
            }
        }

        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            Integer integer = sMap.get(c);
            if (integer == null) {
                return false;
            } else {
                Integer integer1 = --integer == 0 ? sMap.remove(c) : sMap.put(c, integer);
            }
        }
        
        if (sMap.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
