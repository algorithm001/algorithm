package main

import (
	"fmt"
	"sort"
)

func wiggleSort(nums []int) []int {
	if len(nums) < 2 {
		return nums
	}
	ret := []int{}
	sort.Ints(nums)
	mid := len(nums)/2
	right := len(nums)-1
	left := mid-1
	for len(ret) < len(nums) {
		if len(ret) < len(nums) {
			ret = append(ret, nums[right])
			right--
		}

		if len(ret) < len(nums) {
			ret = append(ret, nums[left])
			left--
		}
	}
	nums = ret
	return nums

}

func main() {
	nums := []int{1, 5, 1, 1, 6, 4}
	fmt.Println(wiggleSort(nums))
}
