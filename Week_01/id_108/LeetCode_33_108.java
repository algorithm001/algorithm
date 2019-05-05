/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/04/29
 */
public class LeetCode_33_108 {
    class Solution {
        public int search(int[] nums, int target) {
            if(nums == null || nums.length == 0){
                return -1;
            }

            if(nums[0] == target){
                return 0;
            }
            if(nums[nums.length - 1] == target){
                return nums.length - 1;
            }

            int end = nums.length - 1;
            int min = min(nums);
            //如果没有旋转，并且最大的数小于target
            if(min == 0 && nums[end]<target){
                return -1;
            }

            if(nums[end] > target){
                //target处于旋转的后半段
                return binarySerach(nums,min,end,target);
            }else{
                //target有可能处于旋转的前半段
                return binarySerach(nums,0,min-1,target);
            }
        }

        //查找旋转点
        private int min(int[] nums){
            int low = 0;
            int high = nums.length - 1;
            int mid;
            while(low < high){
                mid = low + ((high-low)>>1);
                if(nums[mid]>nums[high]){
                    low = mid + 1;
                }else{
                    high = mid;
                }
            }
            return low;
        }

        //二分查找
        private int binarySerach(int[] nums,int left,int right,int target){
            int mid = 0;
            while(left<right){
                mid = left + ((right - left)>>1);
                if(nums[mid]==target){
                    return mid;
                }
                if(nums[mid]<target){
                    left = mid + 1;
                    continue;
                }
                if(nums[mid]>target){
                    right = mid - 1;
                    continue;
                }
            }
            if(nums[left] == target){
                return left;
            }
            return -1;
        }
    }
}
