class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null){
            return new int[0];
        }
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int j=i;
            for(int k=0;k<nums.length;k++){
                if(j==nums.length){
                    j=0;
                }
                if(nums[j]>nums[i]){
                    result[i]=nums[j];
                    break;
                }
                if(k==nums.length-1){
                    result[i]=-1;
                    break;
                }
                j++;
            }
        }
        return result;
    }
}
