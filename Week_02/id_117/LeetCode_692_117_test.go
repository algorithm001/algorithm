package solution

import (
	"reflect"
	"testing"
)

func compareSlice(s1, s2 []string) bool {
	return reflect.DeepEqual(s1, s2)
}

func TestLeetCode_692_117(t *testing.T) {
	rightList := []string{"good", "the", "is", "sunny"}
	strList := []string{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is", "good", "good", "good", "good", "good"}
	k := 4
	targets := topKFrequent(strList, k)
	t.Log("targets =>", targets, rightList)
	// slice的是否相同比较
	if compareSlice(targets, rightList) {
		t.Log("True")
	} else {
		t.Log("False")
	}
}
