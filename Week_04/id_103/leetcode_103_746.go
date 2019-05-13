package id_103

func minCostClimbingStairs(cost []int) int {
	p1,p2 := 0,0
	for i := 2; i <= len(cost); i++ {
		p1 , p2 = p2, min(p2 + cost[i-1],p1+cost[i-2])
	}
	return p2
}

func min(a,b int) int  {
	if a > b{
		return b
	}else{
		return a
	}
}
