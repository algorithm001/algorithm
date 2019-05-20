package solution

import (
	"testing"
)

func Test_Search(t *testing.T) {
	testData := []map[string]interface{}{
		map[string]interface{}{
			"name":  "test1",
			"ins":   []string{"bad", "dad", "mad"},
			"finds": []string{"pad", "bad", ".ad", "b.."},
			"outs":  []bool{false, true, true, true},
		},
	}

	for _, tt := range testData {
		name := tt["name"].(string)
		finds := tt["finds"].([]string)
		ins := tt["ins"].([]string)
		outs := tt["outs"].([]bool)
		t.Run(name, func(t *testing.T) {
			obj := Constructor2()
			for _, word := range ins {
				obj.AddWord2(word)
			}
			for k, word := range finds {

				got := obj.Search2(word)
				if got != outs[k] {
					t.Errorf("Search got= %v, want %v, k=%d", got, outs[k], k)
				}
			}
		})
	}
}
