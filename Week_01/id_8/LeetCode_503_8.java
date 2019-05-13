class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        for (int t = 0; t < 2; ++t) {
            for (int i = 0; i < nums.length; ++i) {
                while (!stack.empty() && nums[i] > nums[stack.peek()]) {
                    result[stack.peek()] = nums[i];
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return result;
    }
}