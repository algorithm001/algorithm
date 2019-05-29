package a938;

import java.util.ArrayList;
import java.util.List;

public class Solution {

		//题目的意思是求L=<X<=R的所有节点的和，所以先中序遍历得到有序集合，再求和即可。
    public int rangeSumBST(TreeNode root, int L, int R) {
    	int sum = 0;
    	List<Integer> res = new ArrayList<Integer>();
    	inorder(root,res);

    	for(int i=0;i<res.size();i++) {
    		Integer tmp = res.get(i);
			if(tmp>=L && tmp <= R) {
    			sum+=tmp;
    			continue;
    		}
			if(tmp>R) break;
    	}

        return sum;
    }

    private void inorder(TreeNode root,List<Integer> res) {
		if(null == root) return;

		inorder(root.left,res);
		res.add(root.val);
		inorder(root.right,res);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(15);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(7);
		TreeNode t5 = new TreeNode(18);

		root.left = t1;
		root.right=t2;
		t1.left=t3;
		t1.right=t4;

		t2.right=t5;

		System.out.println(new Solution().rangeSumBST(root,7,15));

	}

}
