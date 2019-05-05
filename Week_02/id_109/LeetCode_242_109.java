/**
 * @Auther: quanhc
 * @Date: 2019-04-20 21:17
 * @Description:
 */
public class LeetCode83 {

    int last = -1000000;
    int res = 1000000;
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minDiffInBST(root.left);
        res = Math.min(root.val - last, res);
        last = root.val;
        minDiffInBST(root.right);
        return res;
    }
}
