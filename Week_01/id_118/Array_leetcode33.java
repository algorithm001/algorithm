/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
class Solution {
    public int search(int[] nums, int target) {
        // 考虑几种情况。
        // 1. 已有序
        //    - tartget 在 nums[left] 和 nums[right] 之间，则二分查找。
        //    - 否则，不存在，直接返回 -1
        // 2. 有序旋转
        //    - 不存在，返回-1。
        //    - nums[left]
        if(nums.length<1){
            return -1;
        }
        if(nums.length == 1){
            return target == nums[0]?0:-1;
        }
        
        int left =0;
        int right = nums.length-1;
        return findRegion(nums,target,left,right);        
    }
    
    
    // 查找有序区间，找到后二分。
    int findRegion(int[] nums,int target,int left,int right){
        
        // 已有序，则二分查找
        if(nums[left] < nums[right]){
            System.out.println("已经有序，left="+left+" right="+right);
            return findElementInSortedRegion(nums,target,left,right);
        }
        
        // 旋转有序，夹在高区最小值，和低区最大值之间，则数组中一定不存在该元素
        if(target>nums[right] && target<nums[left]){
            // System.out.println("夹在中间，left="+left+" right="+right);
            return -1;
        }
        
        // 旋转有序，分情况判断
        int middle = left + (right-left)/2;
        // System.out.println("旋转有序，left="+left+" right="+right+" middle="+middle);

        if(nums[middle] > nums[left] && nums[middle] > nums[right]){
            // middle在高区
            // System.out.println("旋转有序，middle在高区，left="+left+" right="+right+" middle="+middle);
            if(target<=nums[middle] && target>=nums[left]){
                // System.out.println("旋转有序，middle在高区，target落在左区间");
                return findElementInSortedRegion(nums,target,left,middle);
            }else{
                // System.out.println("旋转有序，middle在高区，target落在右区间");
                return findRegion(nums,target,middle,right);
            }
        }else{
            // System.out.println("旋转有序，middle在低区，left="+left+" right="+right+" middle="+middle);
            // middle在低区
            if(target>=nums[middle] && target<=nums[right]){
                // System.out.println("旋转有序，middle在低区，target落在右区间");
                return findElementInSortedRegion(nums,target,middle,right);
            }else{
                // System.out.println("旋转有序，middle在低区，target落在左区间");
                return findRegion(nums,target,left,middle);
            }
        }
    }
    
    
    // 在完全有序区间内进行查找（二分）
    int findElementInSortedRegion(int[] nums,int target,int left,int right){
       int mid = 0;
        while (min <= max) {
           mid = (min+max)/2;
        //没找了， 更新范围，继续比较
        //更新范围
        if (arr[mid] > number) {
            //在左边
            max = mid-1;
        } else if(arr[i] < number){
            //在右边
            min = mid+1;
        }
        else{
              return mid ;
          }
     
    return -1;
    }
}
