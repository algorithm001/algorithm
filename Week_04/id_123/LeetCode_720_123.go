package id_123

type TrieNode struct {
	data         byte
	children     [26]*TrieNode
	isEndingChar bool
}

// 往 Trie 树中插入一个字符串
func insert(root *TrieNode, text string) {
	p := root
	for i := 0; i < len(text); i++ {
		index := text[i] - 'a'
		if p.children[index] == nil {
			newNode := &TrieNode{data: text[i]}
			p.children[index] = newNode
		}
		p = p.children[index]
	}
	p.isEndingChar = true
}

func longestWord(words []string) string {
	root := &TrieNode{}
	for _, word := range words {
		insert(root, word)
	}

	finalResult := ""
	tempStr := ""
	findLongestWord(root, &tempStr, &finalResult)
	return finalResult
}

func findLongestWord(root *TrieNode, resWord *string, finalResult *string) {
	for i := 0; i < 26; i++ {
		if root.children[i] != nil && root.children[i].isEndingChar {
			newStr := *resWord + string(root.children[i].data)
			if len(newStr) > len(*finalResult) {
				*finalResult = newStr
			}

			findLongestWord(root.children[i], &newStr, finalResult)
		}
	}
}
