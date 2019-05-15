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




	   public int maxDepth(TreeNode root) {

		   List<List<Integer>> rst = new ArrayList<>();
	       List<Integer> list = new ArrayList<>();
	       dfs(root,rst,list);

	       if(rst.size() == 0){
	    	   return 0;
	       }

	       int max=rst.get(0).size();
	       for(int i=1;i<rst.size();i++)
	       {
	    	   int curLen = rst.get(i).size();
	    	   if(max<curLen)
	    	   {
	    		   max = curLen;
	    	   }
	       }

		   return max;
	   }

	   public void dfs(TreeNode node, List<List<Integer>> rst, List<Integer> list) {
			if (node == null)
				return;
			if (node.left == null && node.right == null) {
				list.add(node.val);
				/*
				 * 这里将list存入rst中时，不能直接将list存入，而是通过新建一个list来实现，
				 * 因为如果直接用list的话，后面remove的时候也会将其最后一个存的节点删掉
				 */
				rst.add(new ArrayList<>(list));
				list.remove(list.size() - 1);
			}
			list.add(node.val);
			dfs(node.left, rst, list);
			dfs(node.right, rst, list);
			list.remove(list.size() - 1);
		}

	   public static void main(String[] args) {
		   TreeNode root = new TreeNode(3);
		   TreeNode t1 = new TreeNode(9);
		   TreeNode t2 = new TreeNode(20);
		   TreeNode t3 = new TreeNode(15);
		   TreeNode t4 = new TreeNode(7);
		   t2.left = t3;
		   t2.right = t4;
		   root.left = t1;
		   root.right = t2;

		   System.out.println(new Solution().maxDepth(root));
	}


}
