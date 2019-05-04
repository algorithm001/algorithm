package id_123

import (
	"log"
	"testing"
)

func Test_sortArrayByParityII(t *testing.T) {
	A := []int{4, 2, 5, 7}
	log.Printf("sort before: %v", A)
	B := sortArrayByParityII(A)
	log.Printf("sort after: %v", B)
}
