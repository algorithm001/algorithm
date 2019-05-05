package solution

import (
	"testing"
)

/*
[
     [1],
     [3,2,4],
     [5,6]
]
*/

func Test_eventualSafeNodes(t *testing.T) {
	testData := []map[string]interface{}{
		map[string]interface{}{
			"name": "test1",
			"ins": &TreeNodeMul{
				Val: 1,
				Children: []*TreeNodeMul{
					&TreeNodeMul{
						Val: 3,
						Children: []*TreeNodeMul{
							&TreeNodeMul{
								Val: 5,
							},
							&TreeNodeMul{
								Val: 6,
							},
						},
					},
					&TreeNodeMul{
						Val: 2,
					},
					&TreeNodeMul{
						Val: 4,
					},
				},
			},
			"outs": [][]int{
				{1},
				{3, 2, 4},
				{5, 6},
			},
		},
	}
	for _, tt := range testData {
		name := tt["name"].(string)
		ins := tt["ins"].(*TreeNodeMul)
		outs := tt["outs"].([][]int)
		t.Run(name, func(t *testing.T) {
			got := levelOrder(ins)
			t.Log("got =>", got)
			t.Log("outs =>", outs)
			// eq := StringSliceReflectEqual(got, outs)
			// if !eq {
			// 	t.Errorf("eventualSafeNodes() = %v, want %v", got, outs)
			// }
		})
	}
}
