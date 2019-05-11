package solution

import (
	"testing"
)

func Test_maxDepth(t *testing.T) {
	fn := "maxDepth"
	testData := []map[string]interface{}{
		map[string]interface{}{
			"name": "test1",
			"ins": &TreeNode{
				Val: 3,
				Left: &TreeNode{
					Val: 9,
				},
				Right: &TreeNode{
					Val: 20,
					Left: &TreeNode{
						Val: 15,
					},
					Right: &TreeNode{
						Val: 7,
					},
				},
			},
			"outs": 3,
		},
	}
	for _, tt := range testData {
		name := tt["name"].(string)
		ins := tt["ins"].(*TreeNode)
		outs := tt["outs"].(int)
		t.Run(name, func(t *testing.T) {
			got := maxDepth(ins)
			isEq := got == outs
			if !isEq {
				t.Errorf("%s = %v, want %v", fn, got, outs)
			}
		})
	}
}
