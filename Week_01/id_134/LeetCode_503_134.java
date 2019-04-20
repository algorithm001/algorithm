//https://leetcode.com/problems/next-greater-element-ii/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length <= 0)
            return new int[0];
        int[] ret = new int[nums.length];
        for (int i=0; i<ret.length; i++)
            ret[i] = -1;
        for (int i=0; i<nums.length; i++) {
            int flag = 0;
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j] > nums[i]) {
                    ret[i] = nums[j];
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                for (int k=0; k<i; k++) {
                    if (nums[k] > nums[i]) {
                        ret[i] = nums[k];
                        break;
                    }
                }
            }
        }
        return ret;
    }
}