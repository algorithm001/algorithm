"https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/"
"Author : Shaodong Song" 
"Date : 2019-05-17"

"""
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

"""

import heapq
class KthLargest(object):

    def __init__(self, k, nums):
        """
        :type k: int
        :type nums: List[int]
        """
        self.queues = nums
        self.k = k
        heapq.heapify(self.queues)
        
        while len(self.queues) > k:
            heapq.heappop(self.queues)

    def add(self, val):
        """
        :type val: int
        :rtype: int
        """
        if len(self.queues) < self.k:
            heapq.heappush(self.queues, val)
        elif val > self.queues[0]:
            "self.queues[0] is mininum val"
            heapq.heapreplace(self.queues, val)
            
        return self.queues[0]


k = 3;
arr = [4,5,8,2]
kthLargest = KthLargest(3, arr)

print "add element 3, the 3th largest element = %d" % kthLargest.add(3)
print "add element 5, the 3th largest element = %d" % kthLargest.add(5)
print "add element 10, the 3th largest element = %d" % kthLargest.add(10)



