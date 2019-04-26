package solution

// 方法1,直接暴力破解
// 当前时间复杂度为O(n), n为字符串长度
func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	mps := make(map[string]int)
	for ix := 0; ix < len(s); ix++ {
		var current = string(s[ix])
		_, ok := mps[current]
		if ok {
			mps[current] = mps[current] + 1
		} else {
			mps[current] = 1
		}
	}
	for ix := 0; ix < len(s); ix++ {
		var current = string(t[ix])
		if _, ok := mps[current]; ok {
			mps[current] = mps[current] - 1
			if mps[current] == 0 {
				delete(mps, current)
			}
		}
	}
	return len(mps) == 0
}
