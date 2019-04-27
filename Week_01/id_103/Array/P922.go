package Array


func SortArrayByParityII(A []int) []int {
	lenth := len(A) - 1
	left ,right := 1,lenth/2*2
	A = SortArrayByParity(A)
	for left < right{
		A[left] , A[right] = A[right],A[left]
		left +=2
		right -=2
	}
	return A
}