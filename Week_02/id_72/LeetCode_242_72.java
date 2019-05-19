class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer count = countMap.get(c);
            if (count == null) {
                count = 0;
            }
            count++;
            countMap.put(c, count);
        }
        for (char c : t.toCharArray()) {
            Integer count = countMap.get(c);
            if (count == null) {
                return false;
            }
            count--;
            if (count > 0) {
                countMap.put(c, count);
            } else {
                countMap.remove(c);
            }
        }
        return countMap.isEmpty();
    }
}