func sortArrayByParity(A []int) []int {
	i := 0
	for j:=0;j<len(A) ;j++  {
		if A[j]	% 2 ==0{
			A[i],A[j] = A[j],A[i]
			i ++
		}
	}
	return A
}