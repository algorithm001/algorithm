package solution

import (
	"testing"
)

func Test_eventualSafeNodes(t *testing.T) {
	testData := []map[string]interface{}{
		map[string]interface{}{
			"name": "test1",
			"ins":  []int{3, 2, 3},
			"outs": 3,
		},
		map[string]interface{}{
			"name": "test1",
			"ins":  []int{2, 2, 1, 1, 1, 2, 2},
			"outs": 2,
		},
	}
	for _, tt := range testData {
		name := tt["name"].(string)
		ins := tt["ins"].([]int)
		outs := tt["outs"].(int)
		t.Run(name, func(t *testing.T) {
			got := majorityElement2(ins)
			eq := got == outs
			if !eq {
				t.Errorf("eventualSafeNodes() = %v, want %v", got, outs)
			}
		})
	}
}
