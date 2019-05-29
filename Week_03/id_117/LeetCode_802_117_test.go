package solution

import (
	"testing"
)

func Test_eventualSafeNodes(t *testing.T) {
	testData := []map[string]interface{}{
		map[string]interface{}{
			"name": "test1",
			"ins":  [][]int{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}},
			"outs": []int{2, 4, 5, 6},
		},
	}
	for _, tt := range testData {
		name := tt["name"].(string)
		ins := tt["ins"].([][]int)
		outs := tt["outs"].([]int)
		t.Run(name, func(t *testing.T) {
			got := eventualSafeNodes2(ins)
			eq := StringSliceReflectEqual(got, outs)
			if !eq {
				t.Errorf("eventualSafeNodes() = %v, want %v", got, outs)
			}
		})
	}
}
