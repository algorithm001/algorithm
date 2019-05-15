package solution

import (
	"testing"
)

func TestLeetCode_609_117(t *testing.T) {
	inputs := []string{
		"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)",
		"root/c/d 4.txt(efgh)", "root 4.txt(efgh)",
	}
	outputs := [][]string{
		{"root/a/2.txt", "root/c/d/4.txt", "root/4.txt"},
		{"root/a/1.txt", "root/c/3.txt"},
	}
	results := findDuplicate(inputs)
	t.Log("results: ", results)
	t.Log("outputs: ", outputs)
}
