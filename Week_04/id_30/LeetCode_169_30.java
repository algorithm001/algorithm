package com.shufeng.algorithm4.demo;

import java.util.Random;

/**
 * @author gsf
 * @date 2019-05-11 22:41
 */
public class LeetCode_169_30 {
    public static void main(String[] args) {
        int[] arr = {47,47,72,47,72,47,79,47,12,92,13,47,47,83,33,15,18,47,47,47,47,64,47,65,47,47,47,47,70,47,47,55,47,15,60,47,47,47,47,47,46,30,58,59,47,47,47,47,47,90,64,37,20,47,100,84,47,47,47,47,47,89,47,36,47,60,47,18,47,34,47,47,47,47,47,22,47,54,30,11,47,47,86,47,55,40,49,34,19,67,16,47,36,47,41,19,80,47,47,27};
        int i = majorityElement(arr);
        System.out.println(i);
    }

    public static int majorityElement(int[] nums) {
        quickSort1(nums, 0, nums.length-1);
        return nums[nums.length / 2];
    }

    /**
     * leetcode 执行和提交 结果不一致，提交代码不过。
     * 三路快排
     * 数组根据基数分成三份<、=、>
     */
    private static void quickSort1(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        // 随机数基数
        int s = new Random().nextInt(nums.length);
        swap1(nums, l, s);
        int v = nums[l];
        // 左分点，分割小于和等于，i左边小v，i~k 等于v
        int i = l;
        // 循环点
        int k = l + 1;
        // 右分点，右边大于v的数
        int j = r + 1;

        while (k < j) {
            if (nums[k] < v) {
                // 循环数和最左边等于V的数交换
                swap1(nums, k, i + 1);
                i++;
                k++;
            } else if (nums[k] > v) {
                swap1(nums, k, j - 1);
                j--;
            } else {
                k++;
            }
        }
        swap1(nums, l, i);
        quickSort1(nums, l, i - 1);
        quickSort1(nums, j, r);
    }

    private static void swap1(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }
}
