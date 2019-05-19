import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode_373_129 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] + b[1] - a[0] - a[1]);
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                int[] cur = new int[]{nums1[i], nums2[j]};
                if (queue.size() < k) {
                    queue.add(cur);
                } else if (queue.peek()[0] + queue.peek()[1] > cur[0] + cur[1]) {
                    queue.poll();
                    queue.add(cur);
                }
            }
        }

        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        return res;
    }
}
