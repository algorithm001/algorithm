package solution

import (
	"reflect"
	"sort"
	"testing"
)

func Test_diffWaysToCompute(t *testing.T) {
	testData := []map[string]interface{}{
		map[string]interface{}{
			"name": "test1",
			"ins":  "2-1-1",
			"outs": []int{0, 2},
		},
		map[string]interface{}{
			"name": "test1",
			"ins":  "2*3-4*5",
			"outs": []int{-34, -14, -10, -10, 10},
		},
		map[string]interface{}{
			"name": "test1",
			"ins":  "2-1",
			"outs": []int{1},
		},
	}
	for _, tt := range testData {
		name := tt["name"].(string)
		ins := tt["ins"].(string)
		outs := tt["outs"].([]int)
		t.Run(name, func(t *testing.T) {
			got := diffWaysToCompute(ins)
			sort.Ints(got)
			eq := reflect.DeepEqual(got, outs)
			if !eq {
				t.Errorf("eventualSafeNodes() = %v, want %v", got, outs)
			}
		})
	}
}
