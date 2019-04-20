import java.util.Stack;

public class LeetCode_503_85 {
}

/**
 * @Package:
 * @ClassName: NextGreaterElementII
 * @Description: ***************************
 * **************给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），
 * **************输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，
 * **************这个数字之后的第一个比它更大的数，
 * **************这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。难度：中
 * @leetcode url:https://leetcode.com/problems/next-greater-element-ii/
 * @Author: wangzhao
 * @Date: 2019-04-18 14:51:45
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class NextGreaterElementII {


    public int[] nextGreaterElements(int[] nums) {

        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int bigger = -1;
            int prevIndex = -1;
            int afterIndex = i;
            while (true) {
                afterIndex++;
                if (afterIndex == nums.length) {
                    prevIndex++;
                    afterIndex--;
                    if (prevIndex == i) {
                        break;
                    }
                    if (nums[prevIndex] > nums[i]) {
                        bigger = nums[prevIndex];
                        break;
                    }
                }
                if (nums[afterIndex] > nums[i]) {
                    bigger = nums[afterIndex];
                    break;
                }
            }
            res[i] = bigger;
        }

        return res;
    }

    /**
     * 利用单调栈，存放数组下标
     */
    public int[] nextGreaterElements2(int[] nums) {

        if (nums == null || nums.length == 0) {
            return nums;
        }

        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        boolean isGoon = true;
        for (int i = 0; i < nums.length; i++) {

            while (true) {
                Integer n = null;
                try {
                    n = stack.peek();
                } catch (Exception e) {
                    break;
                }
                if (nums[n] < nums[i]) {
                    res[n] = nums[i];
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i);
            if (i == nums.length - 1 && isGoon) {
                isGoon = false;
                i = -1;
            } else if (i == nums.length - 1 && !isGoon) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr = {5, 4, 3, 2, 1};

        int[] res = new NextGreaterElementII().nextGreaterElements(arr);
        for (int r : res) {
            System.out.print(r + ",");
        }
        System.out.println("");
        System.out.println("----------------------------------------");
        res = new NextGreaterElementII().nextGreaterElements2(arr);
        for (int r : res) {
            System.out.print(r + ",");
        }
    }
}
