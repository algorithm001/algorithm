package solution

/*
863. All Nodes Distance K in Binary Tree

We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.



Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation:
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.



Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.


Note:

The given tree is non-empty.
Each node in the tree has unique values 0 <= node.val <= 500.
The target node is a node in the tree.
0 <= K <= 1000.

*/

// 寻找根结点到目标节点路径上的节点
func distance(root *TreeNode, target int, path *[]*TreeNode) bool {
	if root == nil {
		return false
	}
	*path = append(*path, root)
	if root.Val == target {
		return true
	}
	if root.Left != nil {
		left := distance(root.Left, target, path)
		if left {
			return true
		}
	}
	if root.Right != nil {
		right := distance(root.Right, target, path)
		if right {
			return true
		}
	}
	*path = (*path)[:len(*path)-1]
	return false
}

// 如何寻找到目标节点距离为K的节点
func getAllDistance(root *TreeNode, mps map[*TreeNode]int, K int, backs *[]int) {
	if root == nil {
		return
	}
	if mps[root] == K {
		*backs = append(*backs, root.Val)
	}
	if root.Left != nil {
		if _, ok := mps[root.Left]; !ok {
			mps[root.Left] = mps[root] + 1
		}
		getAllDistance(root.Left, mps, K, backs)
	}
	if root.Right != nil {
		if _, ok := mps[root.Right]; !ok {
			mps[root.Right] = mps[root] + 1
		}
		getAllDistance(root.Right, mps, K, backs)
	}
	return
}

func distanceK(root *TreeNode, target *TreeNode, K int) []int {
	backs := []int{}
	// 存放路径的path
	path := make([]*TreeNode, 0)
	// 存放到指定节点距离的map
	mps := make(map[*TreeNode]int)
	distance(root, target.Val, &path)
	// 计a算根结点到目标节点的map
	for idx := len(path) - 1; idx >= 0; idx-- {
		mps[path[idx]] = len(path) - idx - 1
	}
	getAllDistance(root, mps, K, &backs)
	return backs
}

// ====下面是方法02开始================================================

// 方法二，当前能够解决寻找子节点距离问题，但是没法解决到父节点距离的问题
func distanceK02(root *TreeNode, target *TreeNode, K int) []int {
	emptySlice := []int{}
	if root == nil {
		return emptySlice
	}
	if target.Val == root.Val {
		backs := &[]int{}
		subDistanceK02(root.Right, K, backs)
		subDistanceK02(root.Left, K, backs)
		return *backs
	}
	kls := distanceK02(root.Left, target, K)
	krs := distanceK02(root.Right, target, K)
	if len(kls) > 0 {
		return kls
	}
	return krs
}

// 寻找距离为K长度的子节点
func subDistanceK02(root *TreeNode, K int, backs *[]int) {
	if root == nil {
		return
	}
	K--
	if K == 0 {
		*backs = append(*backs, root.Val)
		return
	}
	subDistanceK02(root.Left, K, backs)
	subDistanceK02(root.Right, K, backs)
}

// ====下面是方法02结束================================================
