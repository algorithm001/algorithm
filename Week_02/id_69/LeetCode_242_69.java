class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) {
            return false;
        }

        // 假设字符串只包含小写字母
        int[] alphabet = new int[26];

        // 统计字符串s中小写字母出现的次数
        for(char ch : s.toCharArray()){
            alphabet[ch - 'a']++;
        }

        // 长度固定，所有字母出现的次数必须都相同
        for(char ch : t.toCharArray()){
            if(--alphabet[ch - 'a'] < 0)
                return false;
        }

        return true;
    }
    
}
