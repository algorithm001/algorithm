class Solution {
    public boolean isAnagram(String s, String t) {
        boolean result = false;
        if (s != null && t != null) {
            if (s.length() == t.length()) {
                char[] s_char = s.toCharArray();
                char[] t_char = t.toCharArray();
                int r = 0;
                for (int i = 0; i < s_char.length; i++) {
                    for (int j = 0; j < t_char.length; j++) {
                        if (s_char[i] == t_char[j]) {
                            r++;
                            break;
                        }
                    }
                }
                if (r == s.length() && r == t.length()) {
                    result = true;
                }
            }
        }
        return result;
    }
}
