class Solution {

  public int search(int[] nums, int target) {
   int left = 0,right = nums.length-1,end = nums.length-1,mid;
    if(end < 0){
        return -1;
    }else if(end == 0){
        return nums[0] == target ? 0 : -1;
    }    

    if(nums[0]<nums[end]){
        return binarySearch(nums,target,0 ,end);
    }

    int maxIndex = -1;
    //查找最大值索引
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
      
    //比较最大值 进行区间二分查找
    if(target < nums[0]){
        return binarySearch(nums,target,maxIndex+1 ,end) ;              
    }else{
      return binarySearch(nums,target,0 ,maxIndex) ;             
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