package wee1

//242. 有效的字母异位词
//valid-anagram/description
func isAnagram(s string, t string) bool {
	m1, m2 := make(map[string]int, 0), make(map[string]int, 0)
	for _, v := range s {
		m1[string(v)]++
	}
	for _, v := range t {
		m2[string(v)]++
	}
	for _, v := range s {
		if m1[string(v)] != m2[string(v)] {
			return false
		}

	}
	for _, v := range t {
		if m1[string(v)] != m2[string(v)] {
			return false
		}
	}
	return true

}
