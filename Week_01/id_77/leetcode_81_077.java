class Solution {
    public boolean search(int[] nums, int target) {
       int left = 0,right = nums.length-1,end = nums.length-1,mid;
        if(end < 0){
            return false;
        }else if(end == 0){
            return nums[0] == target;
        }    

        if(nums[0]<nums[end]){
            return binarySearch(nums,target,0 ,end) > -1;
        }else if(nums[0] == target){
               return true;
         }else{
            while(left < end && nums[left] == nums[left+1]){                 
                left++;               
               }
            while(right > 0 && nums[right] == nums[right-1]){                   
                right--;
            }
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
        if(target < nums[0]){
            return binarySearch(nums,target,maxIndex+1 ,end) > -1;              
        }else{
          return binarySearch(nums,target,0 ,maxIndex) > -1;             
        }    
        
    }
    
    public int binarySearch(int[] nums,int target,int left ,int right){
        if(left>right){
            return -1;
        }
        int mid = left + ((right - left) >> 1);
        if(nums[mid] > target){
            return binarySearch(nums,target,left,mid-1);
        }else if(nums[mid] < target){
            return binarySearch(nums,target,mid + 1,right);
        }else{
            return mid;
        }
    }
}