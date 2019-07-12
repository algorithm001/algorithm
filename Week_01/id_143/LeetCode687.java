public class LeetCode687 {

    private int maxP=0;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null){
            return 0;
        }

        getMaxDistance(root,root.val);

        return maxP;
    }

    private int getMaxDistance(TreeNode root,int val){

        if(root==null){
            return 0;
        }

        int leftDistance=getMaxDistance(root.left,root.val);
        int rightDistance=getMaxDistance(root.right,root.val);

        maxP=Math.max(maxP,leftDistance+rightDistance);

        if(root.val==val){
            return Math.max(leftDistance,rightDistance)+1;
        }

        return 0;
    }
}
