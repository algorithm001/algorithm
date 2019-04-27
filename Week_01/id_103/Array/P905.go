package Array

//Finished
func SortArrayByParity(A []int) []int {
	left,right:=0,len(A)-1

	for left < right{
		if A[left] % 2 == 1{
			A[right] ,A[left] = A[left],A[right]
			right--
		}else {
			left++
		}
	}
	return A
}
