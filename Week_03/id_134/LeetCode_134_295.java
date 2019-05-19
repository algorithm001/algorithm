//https://leetcode.com/problems/find-median-from-data-stream/
public class MedianFinder {
	
	private Queue<Integer> maxHeap;
	private Queue<Integer> minHeap;
	
	
	public MedianFinder() {
		maxHeap = new PriorityQueue<Integer>(11,Collections.reverseOrder());
		minHeap = new PriorityQueue<Integer>();
	}
	
	
	public void addNum(int num) {
		if(maxHeap.size()==0 || maxHeap.peek()>=num) {
			maxHeap.offer(num);
			if(maxHeap.size()-1 > minHeap.size()) {
				minHeap.offer(maxHeap.poll());
			}
		}
		else if(minHeap.size()==0 || minHeap.peek() < num) {
			minHeap.offer(num);
			if(minHeap.size() > maxHeap.size()) {
				maxHeap.offer(minHeap.poll());
			}
		}
		else {
			if(maxHeap.size() <= minHeap.size()) {
				maxHeap.offer(num);
			}
			else {
				minHeap.offer(num);
			}
		}
		
		
	}
	
	
	
	public double findMedian() {
		if(maxHeap.size() == minHeap.size()) {
			return (double)(maxHeap.peek() + minHeap.peek()) / 2.0;
		}
		else {
			return (double)maxHeap.peek();
		}
	}
	
	
	public static void main(String[] args) {
		MedianFinder m = new MedianFinder();
		m.addNum(1);
		System.out.println(m.findMedian());
	}

}

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
