class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> stat = new HashMap<>();
        for(int i = 0 ;i < s.length();i ++){
            char c = s.charAt(i);
            Integer count = stat.get(c);
            if(count == null || count == 0){
                stat.put(c,1);
                continue;
            }
            stat.put(c,count + 1);
        }
        for(int i = 0; i < t.length(); i ++){
            char c = t.charAt(i);
            Integer count = stat.get(c);
            if(count == null){
                return false;
            }
            if(count == 1){
                stat.remove(c);
                continue;
            }
            if(count > 1){
                stat.put(c,count - 1);
            }
        }
        return stat.isEmpty();
    }
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}