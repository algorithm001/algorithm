# coding=UTF8
# 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

# 你可以假设数组是非空的，并且给定的数组总是存在众数。

# 示例 1:

# 输入: [3,2,3]
# 输出: 3
# 示例 2:

# 输入: [2,2,1,1,1,2,2]
# 输出: 2


from collections import Counter


class Solution:
    def majorityElement(self, nums):
        majority = int(len(nums)/2)
        print(majority)
        count_dict = {}
        theBiggest = ''
        for num in nums:
            if num in count_dict.keys():
                a = count_dict[num]
                count_dict[num] = a + 1
            else:
                count_dict[num] = 1
        print(count_dict)
        for key, value in count_dict.items():
            if value > majority:
                theBiggest = key
        return theBiggest

# 学一波counter的用法...
    def majorityElement2(self, nums):
        c = Counter(nums)
        res = c.most_common(1)[0][0]
        return res

words = [1, 2, 2, 2, 1, 1, 1, 2, 2]
demo = Solution()
print("result: %s" % demo.majorityElement3(words))
