package main

import (
	"fmt"
	"sort"
)

// 快速排序
func qsort(arr []int) []int {
	if len(arr) < 2 {
		return arr
	} else {
		pivot := arr[0]
		var less []int
		var greater []int
		for _, value := range arr[1:] {
			if value <= pivot {
				less = append(less, value)
			} else {
				greater = append(greater, value)
			}
		}
		var result []int
		result = append(result, qsort(less)...)
		result = append(result, pivot)
		result = append(result, qsort(greater)...)
		return result
	}
}

//给数组排个序，因为众数数目大于全部数字数目的一半，直接返回中位数就行
func majorityElement(nums []int) int {
	//quick_sort(nums, 0, len(nums)-1)
	//nums = qsort(nums)
	sort.Ints(nums)
	return nums[len(nums)/2]
}

func main() {
	test := []int{5, 3, 2, 4, 1, 6, 7}
	quick_sort(test, 0, len(test)-1)
	fmt.Println(majorityElement(test), "======")
	test = []int{3, 3, 2}
	quick_sort(test, 0, len(test)-1)
	fmt.Println(test[len(test)/2], "======")
	test = []int{2, 2, 1, 1, 1, 2, 2}
	quick_sort(test, 0, len(test)-1)
	fmt.Println(majorityElement(test), "======")
}
