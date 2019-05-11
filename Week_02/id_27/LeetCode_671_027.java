/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {


  /*
	   * 思路：设置两个变量传递最小值（first）和第二小值（second），并且赋予初始值65535。
	   * 接下来进行先序遍历，每到一个结点，将此结点的值与first和second比较，
	   * 如果比first小，则把first的值赋给second和当前结点的值赋给first（顺序不能反）。
	   * 如果比first大且比second小，则把当前结点的值赋给second。
	   * 依次遍历完所有结点。
	   * 最后判断second的值是否改变（是否依然为65535），不变说明没有第二小值返回-1，否则返回second。
	   *
	   */


	class CustomLong{
		public CustomLong(Long value) {
			super();
			this.value = value;
		}

		Long value;

		@Override
		public String toString() {
			return "CustomLong [value=" + value + "]";
		}

	}

	public int findSecondMinimumValue(TreeNode root) {

		CustomLong first = new CustomLong(Long.MAX_VALUE),second = new CustomLong(Long.MAX_VALUE);
		twoMinimum(root,first,second);
		if(second.value != Long.MAX_VALUE) return second.value.intValue();
		else return -1;
	}

	private void twoMinimum(TreeNode root,CustomLong first,CustomLong second) {

		if (root == null) return;

		if(root.val < first.value) {
			second.value = first.value;
			first.value = (long)root.val;
		}
		else if(root.val > first.value && root.val < second.value){
			second.value = (long)root.val;
		}

		twoMinimum(root.left,first,second);
		twoMinimum(root.right,first,second);

	}

	public void test(CustomLong in) {
		in.value =  10L;
	}

	public static void main(String[] args) {
		/*CustomInt in = new Solution().new CustomInt(2);
		new Solution().test(in);
		System.out.println(in);*/

		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(2147483647);
		n1.left = n2;
		n1.right = n3;
		System.out.println(new Solution().findSecondMinimumValue(n1));

	}





}
