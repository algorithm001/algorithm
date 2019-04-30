package id_123

import "sort"

func sortString(s string) string {
	charSlice := []rune(s)
	sort.Slice(charSlice, func(i, j int) bool {
		return charSlice[i] < charSlice[j]
	})
	return string(charSlice)
}

func isAnagram(s string, t string) bool {
	return sortString(s) == sortString(t)
}
