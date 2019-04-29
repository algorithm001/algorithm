package geekcode

func isAnagram(s string, t string) bool {

	charcount := map[byte]int{}

	if len(s) != len(t) {
		return false
	}

	for _, c := range s {
		b := byte(c)
		if _, ok := charcount[b]; ok {
			charcount[b] += 1
		} else {
			charcount[b] = 1
		}
	}

	for _, c := range t {
		b := byte(c)
		// 包含元素，且为正 ， 表示 t 中出现了比s 中比较多的字符 , 则返回false
		//不能为0
		if v, ok := charcount[b]; ok && v > 0 {
			charcount[b] -= 1
		} else {
			return false
		}
	}

	return true
}
