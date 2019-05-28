class Solution {
    public int majorityElement(int[] nums) {
          Map<Integer,Integer> map = new HashMap<>();
            for(int num:nums){
                map.put(num,map.getOrDefault(num,0)+1);
            }
            Integer numsD = nums.length/2;
           // BigDecimal   nums2  = new BigDecimal(numsD);
            for(Integer key:map.keySet()){
                if(map.get(key) > numsD ){
                        return  key;
                }
            }
            return  0;
    }
}