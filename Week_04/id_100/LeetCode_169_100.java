/**
* 解法一：
*
*/
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }
    
    public int majorityElement2(int[] nums){
       int flag = nums[0];
        int count = 1;
        for(int i = 1;i < nums.length ;i++){
            if(count == 0){
                count++;
                flag = nums[i];
            }
            if(flag == nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return flag;
    }
}
