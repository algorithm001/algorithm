import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * leetCode 169
 * 
 * @author apple
 */
public class Solution {

    // 利用hashMap的遍历，没有用到分分治的思想
    // 也可以使用 快排，然后取中间的数
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (nums.length / 2))
                return entry.getKey();
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
    }
}

