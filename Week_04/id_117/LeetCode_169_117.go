package solution

/*
169. Majority Element

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
*/

// 方法一, 直接定义map[int]int来存放数据, 找出出现次数最多的数即可, map的长度为 n/2 + 1, 空间复杂度O(n), 时间复杂度O(n)
func majorityElement(nums []int) int {
	mps := make(map[int]int, 0)
	numsLen := len(nums)
	res := 0
	for _, item := range nums {
		mps[item]++
		if mps[item] > numsLen/2 {
			res = item
		}
	}
	return res
}

// 方法二, 分治法思想
// 摩尔投票法,先假设第一个数过半,并设置count=1,之后遍历剩余数据,如果相同则+1,如果不同则-1; 前提条件是存在元素的个数大于n/2
func majorityElement2(nums []int) int {
	numsLen := len(nums)
	if numsLen == 0 {
		return 0
	}
	majar := nums[0]
	count := 1
	for i := 1; i < numsLen; i++ {
		if count == 0 {
			majar = nums[i]
		}
		if majar == nums[i] {
			count++
		} else {
			count--
		}
	}
	return majar
}
