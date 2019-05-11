class Solution:
    def majorityElement(self, nums):
        nums = sorted(nums)
        return nums[len(nums) // 2]


