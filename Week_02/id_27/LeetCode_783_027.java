/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {



    //二叉搜索树中序遍历得到递增序列，然后求差值最小



	public int minDiffInBST(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		inorder(root,res);
		int min = Integer.MAX_VALUE;
		for(int i=1;i<res.size();i++) {
			min= Math.min(min, res.get(i)-res.get(i-1));
		}
		return min;
	}

	private void inorder(TreeNode root,List<Integer> res) {
		if(null == root) return;

		inorder(root.left,res);
		res.add(root.val);
		inorder(root.right,res);
	}

	public static void main(String[] args) {
		//[27,null,34,null,58,50,null,44,null,null,null]
		TreeNode root = new TreeNode(44);
		TreeNode t1 = new TreeNode(34);
		TreeNode t2 = new TreeNode(58);
		TreeNode t3 = new TreeNode(27);
		TreeNode t4 = new TreeNode(36);

		root.left = t1;
		root.right=t2;
		t1.left=t3;
		t1.right=t4;

		System.out.println(new Solution().minDiffInBST(root));

	}






}
