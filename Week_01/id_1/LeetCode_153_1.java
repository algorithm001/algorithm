class Solution {
     public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int min = 0;
        int max = len - 1;
         
        if (nums[min] < nums[max]) {
            return nums[min];
        }

        int mid = (min + max) / 2;
        while (min <= max) {
            if (nums[min] <  nums[mid]) {
                min = mid;
                mid = (min + max) / 2;
            }else if (nums[min] > nums[mid]){
                max = mid;
                mid = (min + max) / 2;
            }else {
                break;
            }
        }
        
        if (min < len -1) {
            if (nums[min] > nums[min + 1]) {
                return nums[min + 1];
            }
        }
        return nums[min];
    }
}