/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
class Solution {
    public int search(int[] nums, int target) {
        // 递归解法。重新整理了一下思路，优化了一些逻辑。
        
        if(nums.length<1){
            return -1;
        }
        
        int left =0;
        int right = nums.length-1;
        return findRegion(nums,target,left,right);        
    }
    
    
    // 查找有序区间，找到后二分。
    int findRegion(int[] nums,int target,int left,int right){
        if(left>right){
            return -1;
        }
        
        // 旋转有序，分情况判断
        int middle = left + (right-left)/2;
        
        if(target==nums[middle]){
            return middle;
        }else if(nums[middle] >= nums[left]){
            if(target < nums[middle] && target>=nums[left]){
                // middle在左侧有序区间，且target在middle左侧
                return findRegion(nums,target,left,middle-1);
            }else{
                // middle在左侧有序区间，且target在middle右侧
                return findRegion(nums,target,middle+1,right);
            }
        }else if(nums[middle] <= nums[right]){
            if(target > nums[middle] && target<=nums[right]){
                // middle在右侧有序区间，且target在middle右侧
                return findRegion(nums,target,middle+1,right);
            }else{
                // middle在右侧有序区间，且target在middle左侧
                return findRegion(nums,target,left,middle-1);
            }
        }else{
            return -1;
        }
    }
    
}
