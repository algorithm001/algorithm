package id_123

func sortArrayByParityII(A []int) []int {
	newArr := make([]int, 0, 20000)

	evenArr := make([]int, 0)
	oddArr := make([]int, 0)
	for _, v := range A {
		if v%2 == 0 {
			evenArr = append(evenArr, v)
		} else {
			oddArr = append(oddArr, v)
		}
	}

	for i := 0; i < len(evenArr); i++ {
		newArr = append(newArr, evenArr[i])
		newArr = append(newArr, oddArr[i])
	}

	return newArr
}
