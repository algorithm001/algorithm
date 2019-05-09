import java.util.Stack;

/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/04/29
 */
public class LeetCode_503_108 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {

            Stack<Integer> stack = new Stack<>();
            int index[] = new int[nums.length];
            for (int i = 0; i < index.length; i++) {
                index[i] = -1;
            }
            if (nums.length == 1) {
                return index;
            }
            int count = 0;
            while (count < 2) {
                for (int i = 0; i < nums.length; i++) {
                    while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                        index[stack.pop()] = nums[i];
                    }
                    stack.push(i);
                }
                count++;
            }
            return index;
        }
    }
}
