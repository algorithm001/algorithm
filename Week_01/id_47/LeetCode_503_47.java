/**
 * 由于题目是归属到stack目录下，因此思路会顺着stack进行。否则不一定能解答出来
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> pos = new Stack<>();
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; ++i) {
            res[i] = -1;
        }
        for(int t=0; t<2; ++t) {
            for (int i = 0; i < nums.length; ++i) {

                int num = nums[i];
                while (!pos.isEmpty() && num > nums[pos.peek()]) {
                    int p = pos.pop();
                    res[p] = num;
                }

                if (!pos.isEmpty() && pos.peek() == i) {
                    res[i] = -1;
                    break;
                }

                pos.push(i);

            }
        }

        return res;
    }
}