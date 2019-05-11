package solution

import (
	"testing"
)

func Test_findOrder(t *testing.T) {
	testData := []map[string]interface{}{
		map[string]interface{}{
			"name": "test1",
			"num":  2,
			"ins":  [][]int{{1, 0}},
			"outs": []int{0, 1},
		},
		map[string]interface{}{
			"name": "test2",
			"num":  4,
			"ins":  [][]int{{1, 0}, {2, 0}, {3, 1}, {2, 3}},
			"outs": []int{0, 1, 3, 2},
		},
	}
	for _, tt := range testData {
		name := tt["name"].(string)
		num := tt["num"].(int)
		ins := tt["ins"].([][]int)
		outs := tt["outs"].([]int)
		t.Run(name, func(t *testing.T) {
			got := findOrder(num, ins)
			isEq := StringSliceReflectEqual(outs, got)
			if !isEq {
				t.Errorf("findOrder = %v, want %v", got, outs)
			}
		})
	}
}
