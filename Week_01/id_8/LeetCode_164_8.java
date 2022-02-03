class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        // for (int i = 1; i < nums.length; ++i) {
        //     int v = nums[i];
        //     int j = i - 1;
        //     for (; j >= 0; --j) {
        //         if (v < nums[j]) {
        //             nums[j + 1] = nums[j];
        //         } else {
        //             break;
        //         }
        //     }
        //     nums[j + 1] = v;
        // }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; ++i) {
            int val = nums[i] - nums[i - 1];
            if (val > result) {
                result = val;
            }
        }
        return result;
    }
}