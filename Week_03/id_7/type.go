package geekcode

/*
二叉树基本类型定义，及常用方法添加，
左边加入节点，
右边加入节点，
左右两边同时加入数据
同时返回加入后新生成的节点
*/
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func Node(val int) *TreeNode {
	return &TreeNode{val, nil, nil}
}

func (self *TreeNode) addLeft(l int) *TreeNode {
	self.Left = Node(l)
	return self.Left
}

func (self *TreeNode) addRight(r int) *TreeNode {
	self.Right = Node(r)
	return self.Right
}

func (self *TreeNode) addBoth(l, r int) (*TreeNode, *TreeNode) {
	self.Left = Node(l)
	self.Right = Node(r)
	return self.Left, self.Right
}
