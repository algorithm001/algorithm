/**
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 * 如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 --> 得出根节点的值是最小的值，也就是求左右子树的最小值
 * 
 * @author apple
 */
public class FindSecMinNode {

    long min = Long.MAX_VALUE; // 定义一个全局变量来保存最小值，最开始使用的 Integer.MAX_VALUE
                               // 是不行的。int 可以取到Integer.MAX_VALUE，这样返回条件就是不对的了。
    int rootVal = 0; // 定义全局变量来保存根节点的值

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null || root.right == null)
            return -1;
        rootVal = root.val;
        getSecMin(root.left);
        getSecMin(root.right);
        return min == Long.MAX_VALUE ? -1 : (int) min;
    }

    // 开始遍历左右子树
    public void getSecMin(TreeNode root) {
        if (root != null) {
            if (root.val < min && root.val > rootVal)
                min = (long) root.val;
            if (root.left != null)
                getSecMin(root.left);
            if (root.right != null)
                getSecMin(root.right);
        }
    }
}
