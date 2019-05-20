package solution

import (
	"reflect"
	"testing"
)

/*
Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
*/
func Test_letterCasePermutation(t *testing.T) {
	testData := []map[string]interface{}{
		map[string]interface{}{
			"name": "test1",
			"ins":  []int{10, 15, 20},
			"outs": 15,
		},
		map[string]interface{}{
			"name": "test2",
			"ins":  []int{1, 100, 1, 1, 1, 100, 1, 1, 100, 1},
			"outs": 6,
		},
	}
	for _, tt := range testData {
		name := tt["name"].(string)
		ins := tt["ins"].([]int)
		outs := tt["outs"].(int)
		t.Run(name, func(t *testing.T) {
			got := minCostClimbingStairs(ins)
			eq := reflect.DeepEqual(got, outs)
			if !eq {
				t.Errorf("minCostClimbingStairs() = %v, want %v", got, outs)
			}
		})
	}
}
