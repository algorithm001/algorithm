package solution

import (
	"testing"
)

func Test_numIslands(t *testing.T) {
	fn := "numIslands"
	testData := []map[string]interface{}{
		map[string]interface{}{
			"name": "test1",
			"ins": [][]byte{
				{'1', '1', '1', '1', '0'},
				{'1', '1', '0', '1', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '0', '0', '0'},
			},
			"outs": 1,
		},
		map[string]interface{}{
			"name": "test2",
			"ins": [][]byte{
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'},
			},
			"outs": 3,
		},
	}
	for _, tt := range testData {
		name := tt["name"].(string)
		ins := tt["ins"].([][]byte)
		outs := tt["outs"].(int)
		t.Run(name, func(t *testing.T) {
			got := numIslands2(ins)
			isEq := got == outs
			t.Log("got: ", got)
			if !isEq {
				t.Errorf("%s = %v, want %v", fn, got, outs)
			}
		})
	}
}
