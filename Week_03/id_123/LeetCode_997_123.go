package id_123

func findJudge(N int, trust [][]int) int {
	inMap := make(map[int]int)
	outMap := make(map[int]int)

	for _, v := range trust {
		inMap[v[1]]++
		outMap[v[0]]++
	}

	for i := 1; i <= N; i++ {
		if inMap[i] == N-1 && outMap[i] == 0 {
			return i
		}
	}

	return -1
}
