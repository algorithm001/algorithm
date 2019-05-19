package geekcode

// 784. 字母大小写全排列
func letterCasePermutation(S string) []string {
	l := len(S)
	prefix := []string{""}
	for i := 0; i < l; i++ {
		n := make([]string, 0)
		c := S[i]
		for _, s := range prefix {
			n = append(n, s+string(c))
			// A ~ Z
			if byte(c) >= 65 && byte(c) <= 90 {
				n = append(n, s+string(c+32))
			}
			// a ~ z
			if byte(c) >= 97 && byte(c) <= 122 {
				n = append(n, s+string(c-32))
			}
		}

		prefix = n
	}
	return prefix
}
