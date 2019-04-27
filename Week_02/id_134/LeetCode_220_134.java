//https://leetcode.com/problems/contains-duplicate-iii/
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        if(k < 1 || t < 0) return false;
        
        TreeSet<Integer> set = new TreeSet<Integer>();
        
        for(int i=0; i<nums.length; i++) {
            int cur = nums[i];
            Integer floor = set.floor(cur);
            Integer ceil = set.ceiling(cur);
            
            if(floor != null && cur <= t + floor
                || ceil != null && ceil <= t + cur) {
                return true;
            }
            set.add(cur);
            if(i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}