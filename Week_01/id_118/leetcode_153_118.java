/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/submissions/
 */
class Solution {
    public int findMin(int[] nums) {
        // 从旋转节点分隔，左侧数据 > 右侧数据，所以找到这个旋转点就能找到最小值。
        
        // 用二分的方式，进行递归
        // - nums[left] > nums[right] 则最小值一定在左边
        // - nums[left] < nums[right] 则最小值一定在右边
        // 递归终止条件为：left==right 或 left+1==right，最小值为 nums[right]。
        
        // PS：有一个点要特别需要注意的是，如果本身已经有序了（第一个点<最后一个点），就不需要这么找了，第一个就是最小值。
        
        if(nums[0] < nums[nums.length-1]){
            return nums[0];
        }
        return findMin(nums,0,nums.length-1);
    }
    
    int findMin(int[] nums,int left,int right){
        // 找到反转位置
        if(left == right || left+1==right){
            return nums[right];
        }
        int middle = left+(right-left)/2;
        if(nums[left] > nums[middle]){
            return findMin(nums,left,middle);
        }else{
            return findMin(nums,middle,right);
        }
    }
}
