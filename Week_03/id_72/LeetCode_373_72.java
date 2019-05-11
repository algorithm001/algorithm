class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new LinkedList<>();
        if (nums1 == null || nums2 == null || k == 0) {
            return result;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] + o1[1] - o2[0] - o2[1];
            }
        });
        for (int i : nums1) {
            for (int j : nums2) {
                queue.add(new int[] {i, j});
            }
        }
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            result.add(queue.poll());
        }
        return result;
    }
}