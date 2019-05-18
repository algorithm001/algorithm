"https://leetcode-cn.com/problems/majority-element/"
"Author : Shaodong Song" 
"Date : 2019-05-18"

"""
Given an array of size n, find the majority element. The majority element is the element that appears more than [ n/2 ] times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:
Input: [3,2,3]
Output: 3

Example 2:
Input: [2,2,1,1,1,2,2]
Output: 2

"""
class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        cnt = 1
        majority = nums[0]
        k = len(nums) // 2
        
        for i in range(1, len(nums)):
            if cnt == 0:
                majority = nums[i]
                cnt += 1
            else:
                if majority == nums[i]:
                    cnt += 1
                    if cnt > k:
                        return majority
                else:
                    cnt -= 1
                
        return majority

so = Solution()

numbers1 = [3,2,3]
numbers2 = [2,2,1,1,1,2,2]

print "The majority element is = %d " % so.majorityElement(numbers1)
print "The majority element is = %d " % so.majorityElement(numbers2)




