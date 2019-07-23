import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/submissions/
 *
 * <p> 数组
 * <p> 简单
 *
 * @author Yunjian Liu
 * @date 2019/04/17 5:40 AM
 */
public class LeetCode_922_14 {
	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] a = {1, 23, 45, 66, 53, 78, 62, 8};
		System.out.println(Arrays.toString(a));
		int[] b = solution.sortArrayByParityII(a);
		System.out.println(Arrays.toString(b));
	}
}

class Solution {
	/**
	 * 和905 类似的思路。 使用双指针
	 * <Pre>
	 * 1. 偶数下标，一直检测是否是偶数，是就一直往前走，直到遇到奇数
	 * <p>
	 * 2. 奇数下标，一直检测是否是奇数，是就一直往前走，直到遇到偶数
	 * <p>
	 * 3. 交换数据
	 * </Pre>
	 * <pre>
	 *     even   odd
	 *       |     |
	 *       |     |
	 *     +----+----+----+----+----+----+----+----+
	 *     | 1  | 23 | 45 | 66 | 78 | 53 | 62 | 8  |
	 *     +----+----+----+----+----+----+----+----+
	 *     0    1    2    3    4    5    6    7
	 *     even            odd
	 *       |              |
	 *       |              |
	 *     +----+----+----+----+----+----+----+----+
	 *     | 1  | 23 | 45 | 66 | 78 | 53 | 62 | 8  |
	 *     +----+----+----+----+----+----+----+----+
	 *     0    1    2    3    4    5    6    7
	 *     even            odd
	 *       |              |
	 *       |              |
	 *     +----+----+----+----+----+----+----+----+
	 *     | 66 | 23 | 45 |  1 | 78 | 53 | 62 | 8  |
	 *     +----+----+----+----+----+----+----+----+
	 *     0    1    2    3    4    5    6    7
	 *               even            odd
	 *                 |              |
	 *                 |              |
	 *     +----+----+----+----+----+----+----+----+
	 *     | 66 | 23 | 45 |  1 | 78 | 53 | 62 | 8  |
	 *     +----+----+----+----+----+----+----+----+
	 *     0    1    2    3    4    5    6    7
	 *               even                      odd
	 *                 |                        |
	 *                 |                        |
	 *     +----+----+----+----+----+----+----+----+
	 *     | 66 | 23 | 45 |  1 | 78 | 53 | 62 | 8  |
	 *     +----+----+----+----+----+----+----+----+
	 *     0    1    2    3    4    5    6    7
	 *               even                      odd
	 *                 |                        |
	 *                 |                        |
	 *     +----+----+----+----+----+----+----+----+
	 *     | 66 | 23 |  8 |  1 | 78 | 53 | 62 | 45  |
	 *     +----+----+----+----+----+----+----+----+
	 *     0    1    2    3    4    5    6    7
	 *                         even                       odd
	 *                           |                         |
	 *                           |                         |
	 *     +----+----+----+----+----+----+----+----+
	 *     | 66 | 23 |  8 |  1 | 78 | 53 | 62 | 45 |
	 *     +----+----+----+----+----+----+----+----+
	 *     0    1    2    3    4    5    6    7
	 * </pre>
	 * <p>
	 * 和905类似的思路
	 *
	 * @param a
	 * @return
	 **/
	public int[] sortArrayByParityII(int[] a) {
		int even = 0;
		int odd = 1;
		int len = a.length;
		while (even < len - 1 && odd < len) {
			while ((a[even] & 1) == 0) {
				if (even == len - 2) {
					return a;
				}
				even = even + 2;
			}

			while ((a[odd] & 1) == 1) {
				if (odd == len - 1) {
					return a;
				}
				odd = odd + 2;
			}

			if (even < len - 1 && odd < len) {
				int tmp = a[even];
				a[even] = a[odd];
				a[odd] = tmp;
				even = even + 2;
				odd = odd + 2;
			}
		}

		return a;
	}
}
