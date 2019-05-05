import java.util.*;

public class LeetCode_671_85 {
}

/**
 * @Package:
 * @ClassName: SecondMinNodeInBinaryTree
 * @Description: *************给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * *************如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。
 * *************给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * ************* 难度：简单
 * @leetcode url:https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 * @Author: wangzhao
 * @Date: 2019-04-24 17:31:28
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class SecondMinNodeInBinaryTree {

    public int findSecondMinimumValue(TreeNode root) {

        int[] r = dfs(root);
        if ((r[0] == -1 || r[1] == -1)) {
            return -1;
        }
        if (r[0] == r[1]) {
            return -1;
        }
        return r[1];
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{-1, -1};
        }
        if (root.left == null && root.right == null) {
            return new int[]{-1, root.val};
        }
        if (root.left == null && root.right != null) {
            return new int[]{root.val, root.right.val};
        }
        if (root.left != null && root.right == null) {
            return new int[]{root.val, root.left.val};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        SortedSet<Integer> set = new TreeSet<>();
        if (root.val != -1) {
            set.add(root.val);
        }
        for (int i : left) {
            if (i == -1) continue;
            set.add(i);
        }
        for (int i : right) {
            if (i == -1) continue;
            set.add(i);
        }
        int[] res = new int[]{-1, -1};
        Iterator<Integer> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            int n = it.next();
            if (n == -1) {
                continue;
            } else {
                if (i == 2) {
                    break;
                }
                res[i] = n;
                i++;
            }
        }

        return res;
    }


    public int findSecondMinimumValue2(TreeNode root) {

        if (root == null) {
            return -1;
        }
        if (root.left != null && root.right == null) {
            return root.val;
        }
        if (root.left == null && root.right != null) {
            return root.val;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int min = Integer.MAX_VALUE;

        while (!stack.empty()) {

            TreeNode node = stack.pop();
            if (node.val < min && node.val > root.val) {
                min = node.val;
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }

        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }


    public static void main(String[] args) {

//        Integer[] arr = {2, 2, 5, null, null, 5, 7};
        Integer[] arr = {1, 1, 3, 1, 1, 3, 4, 3, 1, 1, 1, 3, 8, 4, 8, 3, 3, 1, 6, 2, 1};

        TreeNode root = new TreeNode(arr[0]);
        root = setVal(root, arr, 0);
        int res = new SecondMinNodeInBinaryTree().findSecondMinimumValue(root);
        System.out.println(res);
        res = new SecondMinNodeInBinaryTree().findSecondMinimumValue2(root);
        System.out.println(res);
    }

    private static TreeNode setVal(TreeNode root, Integer[] arr, Integer h) {
        if (root == null) {
            return root;
        }
        if (h * 2 + 1 < arr.length) {
            Integer val = arr[h * 2 + 1];
            if (val != null) {
                root.left = new TreeNode(val);
            }

        }
        if (h * 2 + 2 < arr.length) {
            Integer val = arr[h * 2 + 2];
            if (val != null) {
                root.right = new TreeNode(val);
            }
        }
        if (h * 2 + 2 >= arr.length) {
            return root;
        }
        setVal(root.left, arr, 2 * h + 1);
        setVal(root.right, arr, 2 * h + 2);

        return root;
    }
}