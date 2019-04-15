package geekcode

func twoSum(nums []int, target int) []int {
	l := len(nums)
	hashNums := make(map[int]int)

	// 如果一个数字是解，那么最多出现两次
	for i := 0; i < l; i++ {
		hashNums[nums[i]] = i
	}

	for i := 0; i < l-1; i++ {

		if idx, ok := hashNums[target-nums[i]]; ok && idx != i {
			return []int{i, idx}
		}

	}
	return nil

}
