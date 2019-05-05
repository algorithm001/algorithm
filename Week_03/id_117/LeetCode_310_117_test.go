package solution

import (
	"testing"
)

func Test_findMinHeightTrees(t *testing.T) {
	testData := []map[string]interface{}{
		map[string]interface{}{
			"name": "test1",
			"num":  4,
			"ins":  [][]int{{1, 0}, {1, 2}, {1, 3}},
			"outs": []int{1},
		},
		map[string]interface{}{
			"name": "test2",
			"num":  6,
			"ins":  [][]int{{4, 3}, {0, 3}, {1, 3}, {2, 3}, {5, 4}},
			"outs": []int{3, 4},
		},
	}
	for _, tt := range testData {
		name := tt["name"].(string)
		num := tt["num"].(int)
		ins := tt["ins"].([][]int)
		outs := tt["outs"].([]int)
		t.Run(name, func(t *testing.T) {
			got := findMinHeightTrees3(num, ins)
			eq := StringSliceReflectEqual(got, outs)
			if !eq {
				t.Errorf("eventualSafeNodes() = %v, want %v", got, outs)
			}
		})
	}
}
