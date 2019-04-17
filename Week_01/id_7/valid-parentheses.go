package geekcode

// 用单链表来实现一个简单的栈，
// push 操作为队尾添加元素
// pop 操作为从队尾获取元素，前边的元素的next 指向nil
// 判断是否为空 ， 判断 last 指向的元素是否为nil
// 考虑到单链表操作，如果从队尾删除数据 即 pop 操作，查找pre 元素，复杂度较高，所以，采用头插法实现链表插入操作
// 不要担心 last 指针为空，着急改变last 的指向，第一个节点的next 为nil 正好表示栈为空

//链表实现的一个栈
//默认最大元素个数为2048
type Node struct {
	val  rune
	next *Node
}

//栈类型
type Stack struct {
	head *Node
	size int
	max  int
}

//初始化栈,不使用大小参数
func NewStack() *Stack {
	s := new(Stack)
	s.size = 0
	s.max = 2048
	return s
}

// 大小控制，默认可以装2048个元素,可以传递大小参数
func NewStackWithSize(max int) *Stack {
	s := new(Stack)
	s.size = 0
	s.max = max
	return s
}

//push 操作注意，头指针的next 指针变动
//遍历结果，从head 指针往next 遍历即可完成操作
//超过最大的size ，则入栈失败
func (self *Stack) Push(c rune) bool {
	if self.size >= self.max {
		return false
	}
	self.size++
	self.head = &Node{val: c, next: self.head}
	return true
}

//出栈操作，直接获取头指针，然后改变头指针为头指针的下一个结点
func (self *Stack) Pop() rune {
	if self.head == nil {
		return 0
	}
	b := self.head.val
	self.head = self.head.next
	self.size--
	return b
}

//返回当前栈内的元素个数
func (self *Stack) Count() int {
	return self.size
}

//检查栈是否为空
func (self *Stack) IsEmpty() bool {
	return self.size == 0
}

//检查括号字符串匹配
func isValid(s string) bool {
	stack := NewStack()
	var last rune
	for _, v := range s {
		switch v {
		case '(', '[', '{':
			stack.Push(v)
		case ')':
			last = stack.Pop()
			if last != '(' {
				return false
			}
		case ']':
			last = stack.Pop()
			if last != '[' {
				return false
			}
		case '}':
			last = stack.Pop()
			if last != '{' {
				return false
			}
		}
	}
	return stack.IsEmpty()
}
