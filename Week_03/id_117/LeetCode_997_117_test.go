package solution

import (
	"testing"
)

func Test_findJudge(t *testing.T) {
	testData := []map[string]interface{}{
		map[string]interface{}{
			"name": "test1",
			"num":  2,
			"ins":  [][]int{{1, 2}},
			"outs": 2,
		},
		map[string]interface{}{
			"name": "test2",
			"num":  2,
			"ins":  [][]int{{1, 3}, {1, 3}},
			"outs": 3,
		},
		map[string]interface{}{
			"name": "test3",
			"num":  3,
			"ins":  [][]int{{1, 3}, {2, 3}, {3, 1}},
			"outs": -1,
		},
		map[string]interface{}{
			"name": "test4",
			"num":  3,
			"ins":  [][]int{{1, 2}, {2, 3}},
			"outs": 3,
		},
		map[string]interface{}{
			"name": "test5",
			"num":  4,
			"ins":  [][]int{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}},
			"outs": 3,
		},
	}
	for _, tt := range testData {
		name := tt["name"].(string)
		num := tt["num"].(int)
		ins := tt["ins"].([][]int)
		outs := tt["outs"].(int)
		t.Run(name, func(t *testing.T) {
			if got := findJudge(num, ins); got != outs {
				t.Errorf("minDiffInBST() = %v, want %v", got, outs)
			}
		})
	}
}
