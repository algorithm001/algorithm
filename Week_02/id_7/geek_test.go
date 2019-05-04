package geekcode

import (
	"testing"
)

func TestSecondMinimu(t *testing.T) {
	tree := Node(32)
	l, r := tree.addBoth(64, 5)
	l.addBoth(12, 11)
	r.addBoth(33, 87)
	t.Log(findSecondMinimumValue(tree)) // 11
}

func TestNil(t *testing.T) {
	var a interface{}
	var b *int
	b = nil
	a = b
	if a == nil {
		t.Log("Never Print")
	}
}

func TestAnagram(t *testing.T) {
	a := "hello"
	b := "lloeh"

	t.Log(isAnagram(a, b))
}
