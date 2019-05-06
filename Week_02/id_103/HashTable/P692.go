package HashTable

import (
	"sort"
)
//测试没过，因为顺序问题
func TopKFrequent(words []string, k int) []string {
	collectionMap := map[string]int{}

	for _, v := range words {
		if intV,ok:=collectionMap[v];ok{
			collectionMap[v] = intV +1
		}else{
			collectionMap[v] = 1
		}
	}
	res := []string{}
	counts := make([]int,0)
	for _, v := range collectionMap {
		counts = append(counts, v)
	}
	sort.Ints(counts)
	searchResult := counts[len(counts)-k:]

	for k,v := range collectionMap {
		if help(searchResult,v){
			res = append(res, k)
		}
	}
	return res
}

func help (arr []int,compare int) bool{
	for e := range arr {
		if compare == arr[e]{
			return true
		}
	}
	return false;
}
