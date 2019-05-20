package solution

/*
211. Add and Search Word - Data structure design

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
*/

/**
 * 测试案例
 * Your WordDictionary object will be instantiated and called as such:
 * obj := Constructor();
 * obj.AddWord(word);
 * param_2 := obj.Search(word);
 */

// 方法一
type WordDictionary struct {
	Words map[int][]string
}

/** Initialize your data structure here. */
func Constructor() WordDictionary {
	return WordDictionary{Words: make(map[int][]string)}
}

/** Adds a word into the data structure. */
func (this *WordDictionary) AddWord(word string) {
	m := len(word)
	if len(this.Words[m]) > 0 {
		this.Words[m] = append(this.Words[m], word)
	} else {
		this.Words[m] = []string{word}
	}
}

/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
func (this *WordDictionary) Search(word string) bool {
	m := len(word)
	if this.Words[m] == nil {
		return false
	}
	// 当前列表中元素
	w := len(this.Words[m])
	for i := 0; i < w; i++ {
		tmp := true
		for j := 0; j < m; j++ {
			if word[j] != '.' && word[j] != this.Words[m][i][j] {
				tmp = false
				continue
			}
		}
		if tmp {
			return true
		}
	}

	return false
}

// 方法二
type WordDictionary2 struct {
	children map[rune]*WordDictionary2
	isWord   bool
}

/** Initialize your data structure here. */
func Constructor2() WordDictionary2 {
	return WordDictionary2{children: make(map[rune]*WordDictionary2)}
}

/** Adds a word into the data structure. */
func (this *WordDictionary2) AddWord2(word string) {
	parent := this
	for _, v := range word {
		// 判断是否已存储在树中
		if child, ok := parent.children[v]; !ok {
			newDic := &WordDictionary2{
				children: make(map[rune]*WordDictionary2),
				isWord:   false,
			}
			parent.children[v] = newDic
			parent = newDic
		} else {
			parent = child
		}
	}
	parent.isWord = true
}

/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
func (this *WordDictionary2) Search2(word string) bool {
	parent := this
	wLen := len(word)
	for i := 0; i < wLen; i++ {
		if word[i] == '.' {
			// 递归查找
			mapStatus := false
			for _, v := range parent.children {
				if v.Search2(word[i+1:]) {
					mapStatus = true
				}
			}
			return mapStatus
		} else {
			// 非.字符直接判读
			if _, ok := parent.children[rune(word[i])]; !ok {
				return false
			}
		}
		// 移动指针
		parent = parent.children[rune(word[i])]
	}
	return len(parent.children) == 0 || parent.isWord
}
