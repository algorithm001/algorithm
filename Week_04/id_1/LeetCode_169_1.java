import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
class Solution {
    
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int length = nums.length;
        for (int i = 0; i < length; i ++) {
            int times = map.getOrDefault(nums[i], 0) + 1;
            if (times > length/2) {
                return nums[i];
            }
            map.put(nums[i], times);
        }
        return 0;
    }
}