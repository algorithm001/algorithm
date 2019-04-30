package id_123

func arrangeCoins(n int) int {
	if n == 0 {
		return 0
	}
	var low = 1
	var high = n/2 + 1
	for low <= high {
		var mid = low + (high-low)>>1
		var sum = (mid + 1) * mid / 2
		if sum > n {
			high = mid - 1
		} else if sum < n {
			low = mid + 1
		} else if sum == n {
			return mid
		}
	}
	return low - 1
}
