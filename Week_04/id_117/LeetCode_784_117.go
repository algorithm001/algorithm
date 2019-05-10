package solution

import (
	"strings"
)

/*
784. Letter Case Permutation

Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length between 1 and 12.
S will consist only of letters or digits.
*/

func letterCasePermutation(S string) []string {
	// 先转化为小写
	S = strings.ToLower(S)
	mps := make(map[string]string)
	permute(S, mps)
	ans := make([]string, 0)
	for _, v := range mps {
		ans = append(ans, v)
	}
	return ans
}

func permute(s string, m map[string]string) {
	if _, ok := m[s]; !ok {
		m[s] = s
		for i := 0; i < len(s); i++ {
			temp := s
			temp = string(temp[0:i]) + strings.ToUpper(string(temp[i])) + string(temp[i+1:])
			temp = strings.TrimSpace(temp)
			permute(temp, m)
		}
	}
}
