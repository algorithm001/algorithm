class Solution {
    
    public int findSecondMinimumValue(TreeNode root) {
       if(root ==null || root.left==null ||root.right==null) {
            return -1;
        }
         long min = Long.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if((long)node.val<min && node.val>root.val) {
                min=(long)node.val;
            }
            if(node.right!=null) {
                stack.push(node.right);
            }
            if(node.left!=null) {
                stack.push(node.left);
            }
        }
        return min==Long.MAX_VALUE?-1:(int)min;
    }
    
}
