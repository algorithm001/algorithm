package Array

func findMin(nums []int) int {
	if len(nums)==0{
		return -1
	}
	for i:=1;i<len(nums) ; i++ {
		if nums[i-1] > nums[i]{
			return nums[i]
		}
	}
	return nums[0]
}