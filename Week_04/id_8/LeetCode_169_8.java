class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int len = nums.length >> 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer v = map.get(num);
            if (v == null) {
                map.put(num, 1);
            } else {
                map.put(num, ++v);
            }
        }

        int result = 0;
        int longest = len;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= longest) {
                longest = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;    
    }
}