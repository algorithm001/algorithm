class Solution {
    private List<Integer> res = new ArrayList<>();
    private int min = 0;
    public int minDiffInBST(TreeNode root) {

        if(root == null) return 0;
        getInorder(root);
        return min;
    }
    private void getInorder(TreeNode node){
        if(node == null) return;
        getInorder(node.left);
        res.add(node.val);
        int size = res.size();

        if(size == 2){
            min = res.get(1) - res.get(0);
        }else if(size > 2){
            min = Math.min((res.get(size-1)-res.get(size-2)),min);
        }
        getInorder(node.right);
    }

}
