package solution

import (
	"testing"
)

func Test_maxProfit(t *testing.T) {
	testData := []map[string]interface{}{
		map[string]interface{}{
			"name": "test1",
			"ins":  []int{1, 2, 3, 0, 2},
			"outs": 3,
		},
		map[string]interface{}{
			"name": "test2",
			"ins":  []int{100, 99, 88, 77, 66, 55, 44},
			"outs": 0,
		},
	}
	for _, tt := range testData {
		name := tt["name"].(string)
		ins := tt["ins"].([]int)
		outs := tt["outs"].(int)
		t.Run(name, func(t *testing.T) {
			got := maxProfit(ins)
			eq := (got == outs)
			if !eq {
				t.Errorf("maxProfit() = %v, want %v", got, outs)
			}
		})
	}
}
