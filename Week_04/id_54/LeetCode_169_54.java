class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i=0; i<len; i++ ){
            if(map.get(nums[i]) == null){
                map.put(nums[i], 0);
            }
            int n = map.get(nums[i]);
            map.put(nums[i], n+1);
        }
        
        for(int num: map.keySet()){
            if(map.get(num) > len/2) return num;
        }
        
        return -1;
    }
}
