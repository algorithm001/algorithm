package solution

import (
	"reflect"
	"sort"
	"testing"
)

func Test_letterCasePermutation(t *testing.T) {
	testData := []map[string]interface{}{
		map[string]interface{}{
			"name": "test1",
			"ins":  "a1b2",
			"outs": []string{"a1b2", "a1B2", "A1b2", "A1B2"},
		},
		map[string]interface{}{
			"name": "test2",
			"ins":  "3z4",
			"outs": []string{"3z4", "3Z4"},
		},
		map[string]interface{}{
			"name": "test3",
			"ins":  "12345",
			"outs": []string{"12345"},
		},
		map[string]interface{}{
			"name": "test1",
			"ins":  "a1b2c",
			"outs": []string{"a1b2c", "a1B2c", "A1b2c", "a1b2C", "A1B2c", "a1B2C", "A1b2C", "A1B2C"},
		},
	}
	for _, tt := range testData {
		name := tt["name"].(string)
		ins := tt["ins"].(string)
		outs := tt["outs"].([]string)
		t.Run(name, func(t *testing.T) {
			got := letterCasePermutation(ins)
			sort.Strings(got)
			sort.Strings(outs)
			eq := reflect.DeepEqual(got, outs)
			if !eq {
				t.Errorf("eventualSafeNodes() = %v, want %v", got, outs)
			}
		})
	}
}
