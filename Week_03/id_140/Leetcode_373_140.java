import java.util.*;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 *
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 *
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 *
 * Example 1:
 *
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence:
 *              [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 *
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [1,1],[1,1]
 * Explanation: The first 2 pairs are returned from the sequence:
 *              [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 *
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [1,3],[2,3]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 */
public class Leetcode_373_140 {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int []> maxHeap = new PriorityQueue<>(k, (a, b) -> (b[0] + b[1] - a[0] - a[1]));

        for(int num1 : nums1) {
            for(int num2 : nums2) {
                int [] a = new int[] {num1, num2};

                int sum = num1 + num2;

                if(maxHeap.size() >= k) {
                    int [] max = maxHeap.peek();
                    if(sum < max[0] + max[1]) {
                        maxHeap.poll();
                        maxHeap.offer(a);
                    }
                } else {
                    maxHeap.offer(a);
                }

            }
        }

        List<int []> ans = new LinkedList<>();
        while(!maxHeap.isEmpty()) {
            ans.add(maxHeap.poll());
        }

        Collections.reverse(ans);

        return ans;
    }
}
