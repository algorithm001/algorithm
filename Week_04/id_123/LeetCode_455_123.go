package id_123

import (
	"sort"
)

func findContentChildren(g []int, s []int) int {
	count := 0

	sort.Ints(g)
	sort.Ints(s)

	for _, needSize := range g {
		for index, actualSize := range s {
			if needSize <= actualSize {
				count += 1
				s = s[index+1:]
				break
			}
		}
	}

	return count
}
