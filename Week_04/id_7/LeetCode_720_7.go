package geekcode

// 存储节点数据
type tries_node struct {
	c        byte
	children map[byte]*tries_node
	gocount  int // 经过的单词个数
}

// 存储结果数据
type find_result struct {
	path      string // 路径用来返回结果
	level     int    // 层级用来比较大小
	last_byte byte   // 最后一个字节长度，用来获取最大的字典序
}

//往tries 树中添加一个单词
func (self *tries_node) addString(c string) {
	last := self
	for _, b := range c {
		_b := byte(b)

		if last.children == nil {
			last.children = make(map[byte]*tries_node)
		}

		var n *tries_node
		var ok bool

		if n, ok = last.children[_b]; ok {
			last.children[_b].gocount += 1
		} else {
			n = &tries_node{c: byte(b), children: nil, gocount: 1}
			last.children[_b] = n
		}
		last = n
	}
}

//使用字典创建tries 树，获取深度最长的叶子节点
func longestWord(words []string) string {

	result := make([]find_result, 0)
	root_tree := new(tries_node)

	// 每个单词添加到tries 树中
	for _, v := range words {
		root_tree.addString(v)
	}

	// 用bfs 的方法寻找最大的结果

	// 处理运算结果
	if len(result) == 0 {
		return ""
	} else if len(result) == 1 {
		return result[0].path
	} else {
		var max_byte byte
		max_byte = 0
		result_string := ""
		for _, v := range result {
			if max_byte < v.last_byte {
				max_byte = v.last_byte
				result_string = v.path
			}
		}
		return result_string
	}
}
