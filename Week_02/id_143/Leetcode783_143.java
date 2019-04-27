public class Leetcode783_143 {

    public int minDiffInBST(TreeNode root) {
        if(root == null) return Integer.MAX_VALUE;
        int ans1 = Integer.MAX_VALUE, ans2 = Integer.MAX_VALUE;
        if(root.left != null){
            TreeNode node = root.left;
            while(node.right != null){
                node = node.right;
            }
            ans1 = Math.min(Math.abs(root.val - node.val), minDiffInBST(root.left));
        }
        if(root.right != null){
            TreeNode node = root.right;
            while(node.left != null){
                node = node.left;
            }
            ans2 = Math.min(Math.abs(root.val - node.val), minDiffInBST(root.right));
        }
        return Math.min(ans1, ans2);
    }
}
