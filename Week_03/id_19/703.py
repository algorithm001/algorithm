class KthLargest(object):

    def __init__(self, k, nums):
        """
        :type k: int
        :type nums: List[int]
        """
        nums.sort(reverse=True)
        self.k = k
        self.top_knums = nums[:k]

    def add(self, val):
        """
        :type val: int
        :rtype: int
        """
        if self.k == len(self.top_knums) and val <= self.top_knums[-1]:
            return self.top_knums[-1]
        else:
            self.top_knums.append(val)
            self.top_knums.sort(reverse=True)
            self.top_knums = self.top_knums[:self.k]
            return self.top_knums[-1]
