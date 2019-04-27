package Array

func search(nums []int, target int) bool {
	if len(nums) == 0{
		return false
	}
	if nums[0] == target{
		return true
	}

	isLeftSearch := nums[0] < target

	for i := 1; i< len(nums);i++  {
		if nums[i] == target{
			return true
		}
		if nums[i-1] > nums[i]{
			if isLeftSearch{
				return false
			}else{
				continue
			}
		}
	}
	return false
}