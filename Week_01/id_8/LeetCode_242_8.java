class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        
        int[] as = new int[128];
        char[] acs = s.toCharArray();
        // Arrays.fill(as, -1);
        for (char c : acs) {
            if (as[c] == 0) {
                as[c] = 1;
            }
            as[c] = ++as[c];
        }
        int i = 0;
        for (i = 0; i < t.length(); ++i) {
            int index = t.charAt(i);
            if (as[index] == -1) {
                break;
            } else {
                as[index] = --as[index];
            }
        }
        for (char c : acs) {
            if (as[c] != 1) {
                return false;
            }
        }

        return true;
    }
}