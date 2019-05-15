package leetCode.week4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现一个Trie树（前缀树） Implement Trie (Prefix Tree) source:
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * 请看文件Trie.java
 *
 * @author JP.Jiang
 * @version Java
 * @see Trie
 */

class LeetCode_169_13 {

    // 分治算法
    public int majorityElement(int[] nums) {
        return majorityDivice(nums,0, nums.length - 1);
    }

    // 把大问题分解成各个小问题
    private int majorityDivice(int[] nums, int l, int r) {

        if (l == r) return nums[l];

        int mid = (l + (r - l)) >> 1;
        int elementLeft = majorityDivice(nums, l, mid);
        int elementRight = majorityDivice(nums, mid+1, r);

        if (isMajority(nums, elementLeft)) return elementLeft;
        if (isMajority(nums, elementRight)) return elementRight;

        return -1;
    }

    // 判断是否是众数的方法
    private boolean isMajority(int[] nums, int num) {
        int count = 0;
        for (int i : nums) {
            if (i == num) count++;
        }

        return count > (nums.length >> 1);
    }

    // 使用排序
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    // 使用Map记录
    public int majorityElement1(int[] nums) {

        int middle = nums.length >> 1;

        if (middle == 0) return nums[0];

        // 建立Map[数字 : count]
        Map<Integer, Integer> map = new HashMap<>();

        // 循环插入Map，如果有相同的数字则进行叠加
        for (int num : nums) {
            if (map.containsKey(num)) {
                int newKey = map.get(num) + 1;
                if (newKey > middle) return num;
                map.put(num, newKey);
            } else {
                map.put(num, 1);
            }
        }
        return -1;
    }
}