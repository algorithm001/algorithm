class Solution(object):
    def canPartitionKSubsets(self, nums, k):
        if not nums or len(nums) == 0 or k <= 0 or k > len(nums):
            return False
        total = sum(nums)
        if total % k > 0:
            return False
        target = total / k
        nums = sorted(nums)
        row = len(nums) - 1
        while nums[row] == target:
            row -= 1
            k -= 1
        groups = [0] * k
        return self.search(groups, row, nums, target)

    def search(self, groups, row, nums, target):
        if row < 0:
            return True
        value = nums[row]
        row -= 1
        for i in range(0, len(groups)):
            if groups[i] + value <= target:
                groups[i] += value
                if self.search(groups, row, nums, target):
                    return True
                groups[i] -= value
            if groups[i] == 0:
                break
        return False


