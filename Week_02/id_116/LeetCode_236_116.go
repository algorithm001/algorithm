package binary_tree

func lowestCommonAncestor(root, q, p *TreeNode) *TreeNode {

	/**
		2. 边界问题
			a. 当前节点等于p或q
			b. 当前节点为nil
	*/
	if root == nil {
		return nil
	}
	if p == root || q == root {
		return root
	}
	/**
		1. 子问题
	 */
	l := lowestCommonAncestor(root.Left, q, p)
	r := lowestCommonAncestor(root.Right, q, p)

	/**

		3. 分析结果
			1.左右节点都找了p、q，当前root就是
			2.左节点找了p或者q，而右节点底下没有找到p或者q，则p或q也在左节点底下
			3.右节点找到了p或者q，同理左节点
			4.左右节点都找不到的情况存在吗？（说明2否定了它）
	 */
	if l != nil && r != nil {
		return root
	}
	if l != nil {
		return l
	}
	return r
}
