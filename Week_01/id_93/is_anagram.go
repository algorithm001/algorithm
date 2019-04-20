package main

import "fmt"

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	sarr := make([]int ,26)
	tarr := make([]int, 26)

	for i:=0; i<len(s); i++ {
		sarr[s[i]-'a']++
	}

	for j:=0; j<len(t); j++ {
		tarr[t[j]-'a']++
	}

	for i:=0; i<26; i++ {
		if sarr[i] != tarr[i] {
			return false
		}
	}

	return true
}

func main() {
	s := "anagram"
	t := "nagaram"

	fmt.Println(isAnagram(s, t))
}
