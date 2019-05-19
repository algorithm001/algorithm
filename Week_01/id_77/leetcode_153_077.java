class Solution {
    public int findMin(int[] nums) {
          int left = 0,right = nums.length-1,end = nums.length-1,mid;
        if(end < 0){
            return -1;
        }else if(end == 0){
            return nums[0];
        }    

        if(nums[0]<nums[end]){
            return nums[0];
        }
   
        int maxIndex = -1;
        
        while(left <= right){  
            mid = left + ((right - left) >> 1);
            if(nums[mid] > nums[mid+1]){
                maxIndex = mid;
                break;
            }else if(nums[mid] < nums[0]){
                 right = mid -1;
             }else{
                 left = mid +1;
             }
        }
        return nums[maxIndex + 1];
    }
}