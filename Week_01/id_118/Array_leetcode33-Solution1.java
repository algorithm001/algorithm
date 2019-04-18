/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
class Solution {
    public int search(int[] nums, int target) {
        // 这个逻辑，简直要疯了，等我捋捋的
        
        if(nums.length<1){
            return -1;
        }
        
        int left =0;
        int right = nums.length-1;
        return findRegion(nums,target,left,right);        
    }
    
    
    // 查找有序区间，找到后二分。
    int findRegion(int[] nums,int target,int left,int right){
        
        // 已有序，则二分查找
        if(nums[left] <= nums[right]){
            return findElementInSortedRegion(nums,target,left,right);
        }
        

        // 只有一个元素
        if(left==right){
            System.out.println("测试，只有一个节点:"+nums[left]);
            return nums[left]==target?left:-1;
        }
        
        // 只有2个元素
        if(left+1==right){
            if(nums[left]==target){
                return left;
            }else if(nums[right]==target){
                return right;
            }else{
                return -1;
            }
        }
        
        // 旋转有序，分情况判断
        int middle = left + (right-left)/2;
        
        if(nums[middle] >= nums[left]){
            if(target <= nums[middle] && target>=nums[left]){
                // middle在左侧有序区间，且target在middle左侧
                return findRegion(nums,target,left,middle);
            }else{
                // middle在左侧有序区间，且target在middle右侧
                return findRegion(nums,target,middle,right);
            }
        }else if(nums[middle] <= nums[right]){
            if(target >= nums[middle] && target<=nums[right]){
                // middle在右侧有序区间，且target在middle右侧
                return findRegion(nums,target,middle,right);
            }else{
                // middle在右侧有序区间，且target在middle左侧
                return findRegion(nums,target,left,middle);
            }
        }else{
            return -1;
        }
        
    }
    
    
    // 在完全有序区间内进行查找（二分）
    int findElementInSortedRegion(int[] nums,int target,int left,int right){
        if(left > right){
            return -1;
        }
        int middle = (right+left)/2;
        if(target>nums[middle]){
            return findElementInSortedRegion(nums,target,middle+1,right);
        }else if(target<nums[middle]){
            return findElementInSortedRegion(nums,target,left,middle-1);
        }else{
            return middle;
        }
    }
}
