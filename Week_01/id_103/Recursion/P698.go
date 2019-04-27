package Recursion

import "sort"

func canPartitionKSubsets(nums []int, k int) bool {
	if k> len(nums){
		return false
	}
	total:= 0
	for _, v := range nums {
		total+=v
	}
	if total % k != 0{
		return false
	}
	sort.Ints(nums)
	subTotal := total / k
	if nums[len(nums)-1] > subTotal{
		return false
	}



}

func help(nums []int,total int, used []int) []int{

}