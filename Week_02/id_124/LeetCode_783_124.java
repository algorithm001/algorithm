import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinDiffInBST {

    public int minDiffInBST(TreeNode root) {
        List<Integer> nlist = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            while (node.left != null){
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()){
                TreeNode t = stack.pop();
                nlist.add(t.val);
                node = t.right;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i< nlist.size() ; i++){
            min = Math.min(min, nlist.get(i) - nlist.get(i-1));
        }
        return min;
    }

}
