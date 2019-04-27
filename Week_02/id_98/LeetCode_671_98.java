/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

	public int findSecondMinimumValue(TreeNode root) {
		if(root ==null ){
			return -1;
		}else{
			long first = root.val;
			long second = Long.MAX_VALUE;
			
			second = startFind(root, first, second);
			return (second == first ) ? -1 :(int)second;
		}

        
    }
	
	public long startFind(TreeNode node,long first,long second){
		if(node == null){
			return second; 
		}
		second = startFind(node.left, first, second);
		second = startFind(node.right, first, second);
		if(node.val != first && node.val < second){
			second = node.val;
		}
		return second;
	}
};