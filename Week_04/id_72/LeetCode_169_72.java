class Solution {
    public int majorityElement(int[] nums) {
        int result = Integer.MAX_VALUE;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            Integer count = countMap.getOrDefault(num, 0);
            count++;
            if (count > nums.length / 2) {
                result = num;
                break;
            }
            countMap.put(num, count);
        }
        return result;
    }
}