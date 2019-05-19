package geekcode

import (
	"testing"
)

func TestLongestWord(t *testing.T) {

	words := []string{"t", "ti", "tig", "tige", "tiger", "e", "en", "eng", "engl", "engli", "englis", "english", "h", "hi", "his", "hist", "histo", "histor", "history"}
	t.Log(longestWord(words))
}
