package geekcode

import (
	"testing"
)

func TestLRU(t *testing.T) {
	cache := Constructor(2)
	cache.Put(1, 1)
	cache.Put(2, 2)
	t.Log(cache.Get(1), " should be 1 ")
	cache.Put(3, 3)
	t.Log(cache.Get(2), " should be -1 ")
	cache.Put(4, 4)
	t.Log(cache.Get(1), " should be -1 ")
	t.Log(cache.Get(3), " should be 3")
	t.Log(cache.Get(4), " should be 4")
}
