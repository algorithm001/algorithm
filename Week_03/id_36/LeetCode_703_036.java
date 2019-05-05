package com.potato.leetcode.sort;

import java.util.PriorityQueue;

public class LeetCode_703_036 {
    final PriorityQueue<Integer> q;
    final int k;

    public LeetCode_703_036(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for (int i : nums) {
            add(i);
        }
    }

    public int add(int n) {
        // 返回第K大的数字
        if (q.size() < k) {
            q.offer(n);
        } else if (q.peek() < n) {
            q.poll();
            q.offer(n);
        }
        return q.peek();
    }
}
