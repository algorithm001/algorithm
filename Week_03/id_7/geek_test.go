package geekcode

import (
	"log"
	"testing"
)

func TestMaxDepth(t *testing.T) {
	tree := Node(1)
	l := tree.addLeft(2)
	l2, r2 := l.addBoth(3, 4)
	r2.addLeft(15).addLeft(16).addLeft(34).addRight(50)
	l2.addRight(5).addBoth(3, 4)
	log.Println(maxDepth(tree))
}

func TestFindJudge(t *testing.T) {

	N := 3
	params := [][]int{
		{1, 3},
		{2, 3},
	}

	t.Log(findJudge(N, params))
}
