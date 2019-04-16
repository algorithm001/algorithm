import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-array-by-parity/submissions/
 *
 * <p> 数组
 * <p> 简单
 *
 * @author Yunjian Liu
 * @date 2019/04/16
 */
public class LeetCode_905_14{
	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] a = {1, 23, 45, 66, 78, 53};
		System.out.println(Arrays.toString(a));
		int[] b = solution.sortArrayByParity(a);
		System.out.println(Arrays.toString(b));
	}
}

class Solution {
	/**
	 * 使用双指针
	 * <Pre>
	 * 1. 低位，一直检测是否是偶数，是就一直往前走，直到遇到奇数或高位指针
	 * <p>
	 * 2. 高位，一直检测是否是期数，是就一直往前走，直到遇到偶数或地位指针
	 * <p>
	 * 3. 交换数据
	 * </Pre>
	 *
	 * @param a
	 * @return
	 */
	public int[] sortArrayByParity(int[] a) {
		int low = 0;
		int high = a.length - 1;
		high = Math.min(high, 5000);

		while (low < high) {
			while ((a[low] & 1) == 0 && low < high) {
				low++;
			}
			while ((a[high] & 1) == 1 && low < high) {
				high--;
			}

			if (low < high) {
				int tmp = a[low];
				a[low] = a[high];
				a[high] = tmp;
				low++;
				high--;
			}
		}

		return a;
	}
}
/**
 * <pre>
 * 交换时，未使用 low++,high--
 * 执行用时 : 3 ms, 在Sort Array By Parity的Java提交中击败了99.80% 的用户
 * 内存消耗 : 42.8 MB, 在Sort Array By Parity的Java提交中击败了81.17% 的用户
 * </pre>
 * <pre>
 *     不使用，每次交换后，需要多进行2次比较
 * 交换时，使用 low++,high--
 * 执行用时 : 3 ms, 在Sort Array By Parity的Java提交中击败了99.80% 的用户
 * 内存消耗 : 39.5 MB, 在Sort Array By Parity的Java提交中击败了93.62% 的用户
 * </pre>
 */
