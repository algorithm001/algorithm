package solution

import (
	"testing"
)

func initializeTree3() *TreeNode {
	// root = [4,2,6,1,3,null,null]
	root := createNode(4)
	node1 := createNode(3)
	node2 := createNode(6)
	node3 := createNode(1)
	node4 := createNode(3)

	root.Left = node1
	root.Right = node2
	node1.Left = node3
	node1.Right = node4

	return root
}
func _783Test(t *testing.T, root *TreeNode) {
	min := minDiffInBST(root)
	t.Log("_783Test: min Value: ", min)
}
func TestLeetCode_783_117(t *testing.T) {
	root := initializeTree3()
	_783Test(t, root)
}

func Test_minDiffInBST(t *testing.T) {
	type args struct {
		root *TreeNode
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			name: "test1",
			args: args{
				root: &TreeNode{
					Val: 4,
					Left: &TreeNode{
						Val: 2,
						Left: &TreeNode{
							Val:   1,
							Left:  nil,
							Right: nil,
						},
						Right: &TreeNode{
							Val:   3,
							Left:  nil,
							Right: nil,
						},
					},
					Right: &TreeNode{
						Val:   6,
						Left:  nil,
						Right: nil,
					},
				},
			},
			want: 1,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := minDiffInBST(tt.args.root); got != tt.want {
				t.Errorf("minDiffInBST() = %v, want %v", got, tt.want)
			}
		})
	}
}
