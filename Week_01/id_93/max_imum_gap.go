package main

import (
	"fmt"
	"sort"
)

func maximumGap(nums []int) int {
	if len(nums) < 2 {
		return 0
	}
	max := 0
	sort.Ints(nums)
	for i:=len(nums)-1; i>=1; i-- {
		if nums[i]-nums[i-1] > max {
			max = nums[i]-nums[i-1]
		}
	}


	return max
}

func main() {
	nums := []int{1,10000000}
	fmt.Println(maximumGap(nums))
}
