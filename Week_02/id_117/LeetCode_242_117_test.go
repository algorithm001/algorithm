package solution

import (
	"testing"
)

func TestLeetCode_242_117(t *testing.T) {
	params := [][]string{{"anagram", "nagaram"}, {"rat", "cat"}}
	for _, m := range params {
		flag := isAnagram(m[0], m[1])
		if flag {
			t.Logf("%s is an anagram of %s", m[0], m[1])
		} else {
			t.Errorf("%s is not a anagram of %s", m[0], m[1])
		}
	}
}
