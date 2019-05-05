package id_123

func isAnagram(s string, t string) bool {
	charMap := make(map[rune]int, 0)
	for _, c := range s {
		if _, ok := charMap[rune(c)]; !ok {
			charMap[c] = 1
		} else {
			charMap[c]++
		}
	}

	for _, c := range t {
		count, ok := charMap[c]
		if !ok {
			return false
		} else {
			if count == 1 {
				delete(charMap, c)
			} else {
				charMap[c]--
			}
		}
	}

	if len(charMap) == 0 {
		return true
	} else {
		return false
	}
}
