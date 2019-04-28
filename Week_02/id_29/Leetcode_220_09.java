package leetcode.Algorithms._201_300._220_ContainsDuplicateIII;

import java.util.TreeSet;

/**
 * Created by jialei.zou on 2019/4/21 .
 ref: https://leetcode.com/problems/contains-duplicate-iii/
 Given an array of integers, find out whether there are two distinct indices i and j
 in the array such that the absolute difference between nums[i] and nums[j] is at most t
 and the absolute difference between i and j is at most k.

 Example 1:

 Input: nums = [1,2,3,1], k = 3, t = 0
 Output: true
 Example 2:

 Input: nums = [1,0,1,1], k = 1, t = 2
 Output: true
 Example 3:

 Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 Output: false
 */
public class ContainsDuplicateIII {

    /**
     *
     *
     1. 第一次提交的程序，在如下情况报错
     [-1,2147483647]
     1
     2147483647

     期望是false，返回时true

     问题的关键是在一大一小的时候的比较，之前用的是(Math.abs(nums[j+i]-nums[j])<=t)，但有超过int最大值的情况，
     后续补充了方法largerThanIntMax，又遇到第二个报错

     2. 时间超限，给了个好几屏长的数组，最后报错时间超限，所以算法复杂度是o(n2)是不能接受的，还要降低复杂度
     降低时间复杂度没想到如何实现，看下ref

     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums== null || nums.length <2){
            return false;
        }
        for (int i = 1; i<=k; i++){
            for (int j = 0; j+i< nums.length; j++){
                if(!largerThanIntMax(nums[j+i], nums[j]) && (Math.abs(nums[j+i]-nums[j])<=t)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean largerThanIntMax(int a, int b){
        if((a>=0 && b>=0)||(a<=0 && b<=0)){
            return false;
        }else {
            int delta = Integer.MAX_VALUE - Math.abs(a);
            return Math.abs(b)>delta? true: false;
        }
    }


    /**
     * 官网里面评分比较高的，时间复杂度为nlog(k)，解决了时间超限的问题
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicateRef1(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Integer> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            /**
             * 二叉树 floor 找出<=key的最大值  方法实现过程也是非常好的思路，自己之前也没想出来，> <的比较过程
             * 源码在：java.util.TreeMap#getFloorEntry(java.lang.Object)
             * 二叉树 >=key的最小值的实习过程ceiling
             */
            final Integer floor = values.floor(nums[ind] + t);
            final Integer ceil = values.ceiling(nums[ind] - t);
            /**
             * 加上上面两句，如下的条件判断相当于， nums[ind]<=floor<=(nums[ind] + t) 或者(nums[ind] - t)<=ceil<= nums[ind]
             */
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add(nums[ind]);
            if (ind >= k) {
                values.remove(nums[ind - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateIII duplicateIII = new ContainsDuplicateIII();
        System.out.println(duplicateIII.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
        System.out.println(duplicateIII.containsNearbyAlmostDuplicate(new int[]{1,0,1,1}, 1, 2));
        System.out.println(duplicateIII.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
        System.out.println(duplicateIII.containsNearbyAlmostDuplicate(new int[]{-1,2147483647}, 1, 2147483647));


    }
}
