import java.util.Arrays;
import java.util.Stack;

public class LeetCode_503_129 {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[length];
        Arrays.fill(result, -1);
        for (int i = 0; i < length * 2; i++) {
            int cur = nums[i % length];
            while (!stack.empty() && nums[stack.peek()] < cur) {
                result[stack.pop()] = cur;
            }
            if (i < length) {
                stack.push(i);
            }
        }
        return result;
    }
}
