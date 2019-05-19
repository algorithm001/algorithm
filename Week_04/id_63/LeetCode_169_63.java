class Solution {
  public int majorityElement(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      Integer count = map.get(nums[i]);
      if (count == null) {
        map.put(nums[i], 1);
      } else {
        if (count + 1 > nums.length / 2) {
          return nums[i];
        }
        map.put(nums[i], count + 1);
      }
    }
    if (nums.length == 1) {
      return nums[0];
    }
    return -1;
  }
}