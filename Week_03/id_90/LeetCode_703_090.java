import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 *
 */
class KthLargest {
    int size;
    PriorityQueue < Integer > minheap;
    public KthLargest(int k, int[] nums) {
        minheap = new PriorityQueue < > (k + 1);
        size = k;
        for (int num: nums) {
            minheap.offer(num);
            if (minheap.size() > k) minheap.poll();
        }
    }

    public int add(int val) {
        if (minheap.isEmpty() || minheap.size() < size) minheap.offer(val);
        else if (val >= minheap.peek()) {
            minheap.offer(val);
        }
        if (minheap.size() > size) minheap.poll();
        return minheap.peek();
    }
}

public class TestHeap {
    public static void main(String[] args) {
        int[] arr = {
            4,
            5,
            8,
            2
        };
        KthLargest kthLargest = new KthLargest(3, arr);
        int add1 = kthLargest.add(3);
        int add2 = kthLargest.add(5);
        System.out.println(add1);
        System.out.println(add2);
    }
}