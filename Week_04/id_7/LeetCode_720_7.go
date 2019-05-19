package geekcode

// 存储节点数据
// 省去一个isend , 用word == "" 来代替
// 添加parent 指针，用来做返回判断
type tries_node struct {
	children map[byte]*tries_node
	word     string      // 标记当前节点表示单词
	parent   *tries_node // 标记父节点，省去遍历的麻烦
}

//往tries 树中添加一个单词
func (self *tries_node) addString(word string) *tries_node {
	last := self
	for _, b := range word {
		_b := byte(b)
		if last.children == nil {
			last.children = make(map[byte]*tries_node)
		}

		var n *tries_node
		var ok bool

		if n, ok = last.children[_b]; ok == false {
			n = &tries_node{children: nil, word: "", parent: last}
			last.children[_b] = n
		}
		last = n
	}
	last.word = word
	return last
}

// 当前的单词，是否可以由其他的单词添加字符组成，
// 从跟节点到当前节点走过的所有节点，必须world 不为空
func (self *tries_node) isPathAllWord() (bool, int) {
	len := 0
	p := self
	for p.parent != nil {
		if p.word == "" {
			return false, 0
		}
		len += 1
		p = p.parent
	}
	return true, len
}

// 判断 a,b 的字典顺序，是否是 a > b
// 前提 a,b 的长度相等
func isab(a, b string) bool {
	l := len(a)
	for i := 0; i < l; i++ {
		if byte(a[i]) > byte(b[i]) {
			return true
		}
		if byte(a[i]) < byte(b[i]) {
			return false
		}
	}
	return false
}

//使用字典创建tries 树，获取深度最长的叶子节点
func longestWord(words []string) string {
	var word_nodes = make([]*tries_node, 0)
	root_tree := new(tries_node)
	root_tree.word = "-"
	// 每个单词添加到tries 树中
	for _, v := range words {
		l := root_tree.addString(v)
		word_nodes = append(word_nodes, l)
	}

	maxl := 0
	var maxnode *tries_node
	for _, w := range word_nodes {
		//fmt.Println(w.word)
		ok, l := w.isPathAllWord()
		if ok {
			if maxl < l {
				maxl = l
				maxnode = w
				continue
			}
			if maxl == l {
				//fmt.Println(maxnode.word, w.word)
				if isab(maxnode.word, w.word) == true {
					maxnode = w
				}
			}
		}
	}

	return maxnode.word
}
