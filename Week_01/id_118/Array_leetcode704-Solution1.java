/**
  * https://leetcode-cn.com/problems/binary-search/submissions/
  */ 
class Solution {
    public int search(int[] nums, int target) {
        // 非递归解法
        
        // 1. 边界处理：空数组
        if(nums.length<1){
            return -1;
        }
        
        // 2. 定义左右指针
        int left = 0;
        int right = nums.length-1;
        
        // 3. 搜索。
        while(left<=right){  
            int middle = (right+left)/2;
            if(target > nums[middle]){
                left = middle+1;
            }else if(target < nums[middle]){
                right = middle-1;
            }else{
                return middle;
            }
        }
        return -1;
    }
}
