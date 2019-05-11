package id_123

func sortArrayByParity(A []int) []int {
	evenArr := make([]int, 0)
	oddArr := make([]int, 0)
	for _, v := range A {
		if v%2 == 0 {
			evenArr = append(evenArr, v)
		} else {
			oddArr = append(oddArr, v)
		}
	}
	return append(evenArr, oddArr...)
}
