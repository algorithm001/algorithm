class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] stat = new int[26];
        char[] arr = s.toCharArray();
        for (char item : arr) {
            stat[item - 'a']++;
        }
        char[] brr = t.toCharArray();
        for (char item : brr) {
            stat[item - 'a']--;
        }
        for (int c : stat) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
