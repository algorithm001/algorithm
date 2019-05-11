import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 169. 求众数
 *
 * @author hewei
 * @date 2019/5/11 22:03
 */
public class LeetCode_169_053 {
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:nums) {
            if (map.containsKey(num)) {
                map.put(num,map.get(num)+1);
            } else {
                map.put(num,1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > nums.length/2) {
                return key;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}
