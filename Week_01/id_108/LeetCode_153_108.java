/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/04/24
 */
public class LeetCode_153_108 {

    class Solution1 {
        public int findMin(int[] nums) {
            if(nums.length == 1){
                return nums[0];
            }
            if(nums.length == 2){
                return nums[0] > nums[1] ? nums[1] : nums[0];
            }
            if(nums[0] < nums[nums.length-1]){
                return nums[0];
            }
            int min = 0;
            int high = nums.length - 1;
            int mid = 0;
            while(min <= high){
                //针对1、2、3这种情况
                if(min == high){
                    return nums[min];
                }
                mid = min + ((high-min) >> 1);
                if(nums[mid] > nums[high]){
                    if(nums[mid+1] < nums[mid]){
                        return nums[mid+1];
                    }
                    min = mid + 1;
                    continue;
                }
                if(nums[mid] < nums[min]){
                    if(nums[mid-1] > nums[mid]){
                        return nums[mid];
                    }
                    high = mid - 1;
                }
            }
            return -1;
        }

        //二分查找
        //分为两种情况
        //mid比最后一个元素大，判断它右边的值是否小于它，如果小于的话就返回右边的值，否则的话，min取mid+1
        //mid比第一个元素小，判断它左边的值是否比它大，如果大的话，直接返回它自己，否则的话high取mid-1
    }

    class Solution2 {
        public int findMin(int[] nums) {
            if(nums.length == 1){
                return nums[0];
            }
            int min = 0;
            int high = nums.length - 1;
            int mid = 0;
            while(min < high){
                mid = min + ((high-min) >> 1);
                if(nums[mid] > nums[high]){
                    min = mid + 1;
                } else {
                    high = mid;
                }
            }
            return nums[min];
        }

        //二分查找
        //分为两种情况
        //mid比最后一个元素大，判断它右边的值是否小于它，如果小于的话就返回右边的值，否则的话，min取mid+1
        //mid比第一个元素小，判断它左边的值是否比它大，如果大的话，直接返回它自己，否则的话high取mid-1


    }
}
