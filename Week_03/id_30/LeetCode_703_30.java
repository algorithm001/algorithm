package com.shufeng.algorithm.d0_;

/**
 * @author gsf
 */
public class LeetCode_703_30 {

    public static void main(String[] args) {

        int k = 3;
        int[] arr = {4, 5, 8, 2};
        D703 kthLargest = new D703(k, arr);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8

    }

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int num = 0;

    public D703(int k, int[] nums) {
        num = k;
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() == k) {
                Integer peek = queue.peek();
                if (peek < nums[i]) {
                    queue.poll();
                    queue.add(nums[i]);
                }
            } else {
                queue.add(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (queue.size() == num) {
            Integer peek = queue.peek();
            if (peek < val) {
                queue.poll();
                queue.add(val);
                return queue.peek();
            }
        } else {
            queue.add(val);
        }
        return queue.peek();
    }
}

