public class LeetCode_169_085 {
}

/**
 * @Package:
 * @ClassName: MajorityElement
 * @Description: 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * *************你可以假设数组是非空的，并且给定的数组总是存在众数。
 * @leetcode_url:https://leetcode-cn.com/problems/majority-element/
 * @Author: wangzhao
 * @Date: 2019-05-12 09:49:03
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class MajorityElement {


    public int majorityElement(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int count = 0;
        int majority = -1;

        for (int num : nums) {
            if (count == 0) {
                majority = num;
                count++;
            } else {
                if (majority == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        if (count <= 0) {
            return -1;
        }
        int counter = 0;
        for (int num : nums) {
            if (num == majority) {
                counter++;
            }
        }
        if (counter > nums.length / 2) {
            return majority;
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        int num = new MajorityElement().majorityElement(nums);
        System.out.println(num);
    }
}
