import java.util.*;

class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((n1,n2) -> n1[0] + n1[1] - n2[0] - n2[1]);
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                heap.add(new int[]{num1, num2});
            }
        }
        
        int size = k > heap.size() ? heap.size() : k;
        for (int i = 0; i < size; i++) {
            result.add(heap.poll());
        }
        
        return result;
    }
}