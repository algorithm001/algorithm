package main

import "fmt"

type NodeVal struct {
	Val int
	Children []*NodeVal
}

func LevelOrder(root *NodeVal) [][]int {
	res := make([][]int,0)
	if root == nil {
		return res
	}
	Add(root,0, &res)
	return res
}

func Add(node *NodeVal, index int, res *[][]int)  {
	if len(*res) <= index{
		*res = append(*res, []int{})
	}
	childrens := *res
	childrens[index] = append(childrens[index], node.Val)
	if node.Children != nil{
		for i, _ := range node.Children {
			Add(node.Children[i],index+1,res)
		}
	}
}

func main() {
	node1 := NodeVal{1,make([]*NodeVal,0)}
	node2 := NodeVal{2,make([]*NodeVal,0)}
	node3 := NodeVal{3,make([]*NodeVal,0)}
	node4 := NodeVal{4,make([]*NodeVal,0)}
	node5 := NodeVal{5,make([]*NodeVal,0)}
	node6 := NodeVal{6,make([]*NodeVal,0)}
	node1.Children = append(append(append(node1.Children, &node3), &node2), &node4)
	node3.Children = append(append(node3.Children, &node5), &node6)
	fmt.Println(LevelOrder(&node1))
}