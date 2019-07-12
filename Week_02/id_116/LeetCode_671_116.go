package binary_tree

func findSecondMinimumValue(root *TreeNode) int {
	return traversal(root, root.Val)
}

func traversal(node *TreeNode, val int) int {
	/*
		2. 边界条件
            a. 节点为空 （已经遍历完了，但全是不大于父节点的，即等于都是等于父节点）
			b. 子节点大于父节点 （已经找到了可能为第二小的节点）
	*/
	if node == nil {
		return -1
	}

	if node.Val > val {
		return node.Val
	}
	/*
		1.子问题
	 */
	l := traversal(node.Left, node.Val)
	r := traversal(node.Right, node.Val)

	/*
		3.分析子问题的结果：
			a. 左右两节点都大于父节点，取出那个小的
			b. 左右两节点有一个等于父节点，取出那个大的
			c. 左右两节点都等于父节点，取出人任意一个
	*/
	//a
	if l != -1 && r != -1 {
		return min(l, r)
	}
	//b、c
	return max(l, r)
}

func min(i int, j int) int {
	if i > j {
		return j
	}
	return i
}

func max(i int, j int) int {
	if i > j {
		return i
	}
	return j
}
