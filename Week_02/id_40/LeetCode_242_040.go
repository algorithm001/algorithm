package main

import "fmt"

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	s_m1 := make(map[byte]int)
	t_m2 := make(map[byte]int)
	for i := 0; i < len(s); i++ {
		s_m1[s[i]] += 1
		t_m2[t[i]] += 1
	}
	for k, _ := range s_m1 {
		if s_m1[k] != t_m2[k] {
			return false
		}
	}
	return true
}
func main() {
	s := "anagram"
	t := "nagaram"
	fmt.Println(isAnagram(s, t))
	s = "hat"
	t = "tac"
	fmt.Println(isAnagram(s, t))
}
