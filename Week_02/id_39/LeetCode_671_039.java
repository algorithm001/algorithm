
 /**
  * 
  * @author Paula
  *
  * 执行结果:
  * 执行用时 : 1 ms, 在Second Minimum Node In a Binary Tree的Java提交中击败了86.02% 的用户
  * 内存消耗 : 34 MB, 在Second Minimum Node In a Binary Tree的Java提交中击败了77.61% 的用户
  * 
  * test case:
  * [2,2,5,null,null,5,7]
  * [1,1,3,1,1,3,4,3,1]
  * [5,8,5]
  */
 
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
    	if(root == null) return -1;
    	//第二小节点值
    	int secondMin = -1;
    	
    	TreeNode p = root; //第二小的节点
    	
    	//检查左节点
    	if (p.left != null) {
    		//如果左子节点值不等于当前节点值, 则左子节点值必然大于当前节点的值
    		if(p.left.val != p.val) secondMin = p.left.val;
    		//如果左子节点值不等于当前节点值, 继续遍历左子节点下的分支
        	else secondMin = findSecondMinimumValue(p.left);
    	}
    	
    	//检查右节点
    	if (p.right != null) {
    		//如果右子节点值不等于当前节点值, 则右子节点值必然大于当前节点的值
    		if(p.right.val != p.val) {
    			//对比从左子树得到的secondMin和右子节点的值
        		if(secondMin == -1 || (secondMin != -1 && p.right.val < secondMin) )
        			secondMin = p.right.val;
        		
            //如果右子节点值不等于当前节点值, 继续遍历右子节点下的分支
    		} else {
    			int tmp = findSecondMinimumValue(p.right);
    			if (tmp !=-1 && secondMin !=-1 && tmp < secondMin) 
    				secondMin = tmp;
    		}
    		
    	}
    	   
    	return secondMin;
    }
}
