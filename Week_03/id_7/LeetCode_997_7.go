package geekcode

func findJudge(N int, trust [][]int) int {

	if len(trust) == 0 && N == 1 {
		return 1
	}

	//初始化所有的key,value 均为0, bool 类型默认为false
	trust_a := map[int]int{}
	trust_b := map[int]bool{}

	mask := -1
	// 遍历一遍记录信任关系
	for _, v := range trust {
		trust_a[v[1]] += 1
		trust_b[v[0]] = true
		if trust_a[v[1]] == N-1 {
			mask = v[1]
		}
	}

	//fmt.Println(trust_a,trust_b)

	if trust_b[mask] == false {
		return mask
	}

	return -1
}
