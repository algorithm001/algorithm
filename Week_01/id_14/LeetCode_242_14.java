import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * <p> 数组  两个字符串是否是异位词
 * <p> 简单
 */
public class LeetCode_242_14 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        String s = "anagram";
        String t = "nagaram";

        System.out.println(solution.isAnagram(s, t));
        System.out.println(solution2.isAnagram(s, t));
        System.out.println(solution.isAnagram("rat", "car"));
        System.out.println(solution.isAnagram("", ""));
        System.out.println(solution2.isAnagram("rat", "car"));
        System.out.println(solution2.isAnagram("", ""));
    }

    /**
     * 假设字符串只包含小写字母,字母异位词。
     * <pre>
     *     1. 异位就是所有的字母个数都是一样的，只是位置不同
     *     2. 只有小写字母。a-z (26)个字母。数组arr[26]
     *     3. 看每个字母是否相等
     * </pre>
     */
    static class Solution2 {

        public boolean isAnagram(String s, String t) {
            if (s == null || t == null) {
                return false;
            }

            if (s.length() != t.length()) {
                return false;
            }

            if (s.equals(t)) {
                return true;
            }

            int[] arr = new int[26];

            for (int i : s.toCharArray()) {
                arr[i - 'a']++;
            }
            for (int i : t.toCharArray()) {
                arr[i - 'a']--;
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    return false;
                }
            }

            return true;
        }
    }

    /**
     * 这种解法，先排序，再比较。效率低。其实是可以不排序的，日常开发、设计也需要注意
     * char数组排序直接用JDK实现的排序了。 <strong>这个可以尝试自己实现</strong>
     * <pre>
     *     1. 先对两个字符串内部char数组排序。O(n)。 O(2n)
     *     2. 再遍历对比每个char  O(n)
     *     3. 总体时间复杂度。O(2n)+O(n)=O(3n)=O(n)
     * </pre>
     */
    static class Solution {

        public boolean isAnagram(String s, String t) {
            if (s == null || t == null) {
                return false;
            }

            if (s.length() != t.length()) {
                return false;
            }

            if (s.equals(t)) {
                return true;
            }

            char[] ss = s.toCharArray();
            Arrays.sort(ss);
            char[] ts = t.toCharArray();
            Arrays.sort(ts);

            for (int i = 0; i < ss.length; i++) {
                if (ss[i] != ts[i]) {
                    return false;
                }
            }

            return true;
        }
    }
}
