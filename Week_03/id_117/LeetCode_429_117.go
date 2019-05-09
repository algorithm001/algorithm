package solution

/*
429. N-ary Tree Level Order Traversal

Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example, given a 3-ary tree:
We should return its level order traversal:
[
     [1],
     [3,2,4],
     [5,6]
]
Note:

The depth of the tree is at most 1000.
The total number of nodes is at most 5000.
*/

func levelOrder(root *TreeNodeMul) [][]int {
	ans := make([][]int, 0)
	if len(root.Children) <= 0 {
		return ans
	}
	ansQ := make([]*TreeNodeMul, 0)
	ansQ = append(ansQ, root)
	// 增加第一个元素
	for {
		count := len(ansQ)
		if count == 0 {
			break
		}
		temps := make([]*TreeNodeMul, 0)
		layers := make([]int, 0)
		for i := 0; i < count; i++ {
			q0 := ansQ[0:1][0]
			ansQ = ansQ[1:]
			layers = append(layers, q0.Val)
			if len(q0.Children) > 0 {
				temps = append(temps, q0.Children...)
			}
		}
		ans = append(ans, layers)
		ansQ = append(ansQ, temps...)
	}
	return ans
}
