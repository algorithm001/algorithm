//执行用时 : 1 ms, 在Find Minimum in Rotated Sorted Array的Java提交中击败了92.41% 的用户
//内存消耗 : 37.5 MB, 在Find Minimum in Rotated Sorted Array的Java提交中击败了7.22%的用户

class Solution {
    public int findMin(int[] nums) {
        int i = 1;
        int min = nums[0];
        for(;i<nums.length;i++){
            if(min>nums[i]) min=nums[i];
        }
        return min;
    }
}
