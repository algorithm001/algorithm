func findJudge(N int, trust [][]int) int {
    if len(trust) == 0  && N == 1 {
        return N
    }
    m1 := make(map[int]int)
    m2 := make(map[int]bool)
    for i := 0; i < len(trust); i++ {
        m1[trust[i][1]]++
        m2[trust[i][0]] = true
    }
    ret := -1
    for k, v := range m1 {
        if v == N - 1 && !m2[k] {
            if ret == -1 {
                ret = k
            } else {
                return -1
            }
        }
    }
    return ret
}
