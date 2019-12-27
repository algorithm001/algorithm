package com.haotone.week_01;

import java.util.HashMap;

/**
 * Definition for a binary tree node.
 *  */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
    public int minDiffInBST(TreeNode root) {
    	if(root == null) return Integer.MAX_VALUE;
    	if(root.left == null&&root.right == null) return Integer.MAX_VALUE;
    	if(root.left == null){
    		int ri = root.right.val-root.val;
    		int rimin = minDiffInBST(root.right);
    		int rile = Integer.MAX_VALUE;
    		if(root.right.left != null) {
        		rile = root.right.left.val-root.val;
        	}
    		return Math.min(Math.min(ri, rimin),rile);
    	}else if(root.right == null){
    		int le = root.val-root.left.val;
    		int lemin = minDiffInBST(root.left);
    		int leri = Integer.MAX_VALUE;
    		if(root.left.right != null) {
        		leri = root.val-root.left.right.val;
        	}
    		return Math.min(Math.min(le, lemin),leri);
    	} 
    	int le = root.val-root.left.val;
    	int ri = root.right.val-root.val;
    	int cur = Math.min(le, ri);
    	int rimin = minDiffInBST(root.right);
    	int lemin = minDiffInBST(root.left);
    	int chimin = Math.min(rimin, lemin);
    	int leri = Integer.MAX_VALUE;
    	int rile = Integer.MAX_VALUE;
    	if(root.left.right != null) {
    		leri = root.val-root.left.right.val;
    	}
    	if(root.right.left != null) {
    		rile = root.right.left.val-root.val;
    	}
    	int aromin = Math.min(rile, leri);
    	return Math.min(Math.min(chimin,aromin),cur);
        
    }
}