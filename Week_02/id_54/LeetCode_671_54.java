class Solution {
    public int findSecondMinimumValue(TreeNode root) {
     return traversal(root,root.val);
    }
    
    private int traversal(TreeNode root,int value){
        if(root == null){
            return -1;
        }
        if(root.val > value){
            return root.val;
        }

        int l = traversal(root.left,value);
        int r = traversal(root.right,value);


        if(l>=0 && r>=0){
            return Math.min(l,r);
        }
        
        return Math.max(l,r);
    }
  
}
