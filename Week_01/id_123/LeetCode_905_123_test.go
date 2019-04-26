package id_123

import (
	"fmt"
	"testing"
)

func Test_sortArrayByParity(t *testing.T) {
	A := []int{3, 1, 2, 4, 8, 5, 7, 10, 12}
	fmt.Printf("sort before: %v\n", A)
	B := sortArrayByParity(A)
	fmt.Printf("sort after: %v\n", B)
}
