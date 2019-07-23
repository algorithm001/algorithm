public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("val:").append(val)
            .append(" -left:").append(left == null ? -1 : left.val)
            .append(" -right:").append(right == null ? -1 : right.val);
        return stringBuilder.toString();
    }
}

