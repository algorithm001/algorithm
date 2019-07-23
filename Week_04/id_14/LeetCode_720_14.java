import java.util.*;

/**
 * https://leetcode-cn.com/problems/longest-word-in-dictionary/
 *
 * <p>简单
 * <p>trie树
 *
 * @author aiter
 * @date 2019/05/08 7:12 AM
 */
public class LeetCode_720_14 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //solution.use = 1;

        System.out.println(String.format("期望值：world，实际值：%s",
            solution.longestWord(new String[] {"w", "wo", "wor", "worl", "world"})));
        System.out.println(String.format("期望值：apple，实际值：%s",
            solution.longestWord(new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"})));

        System.out.println(String.format("期望值：ap，实际值：%s",
            solution.longestWord(new String[] {"a", "banana", "appl", "ap", "apply", "apple"})));

        System.out.println(String.format("期望值：latte，实际值：%s",
            solution.longestWord(
                new String[] {"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca",
                    "cat"})));

        System.out.println(String.format("期望值：eyj，实际值：%s",
            solution.longestWord(
                new String[] {"ogz", "eyj", "e", "ey", "hmn", "v", "hm", "ogznkb", "ogzn", "hmnm", "eyjuo", "vuq",
                    "ogznk", "og", "eyjuoi", "d"})));

    }

    /**
     * 最长
     * <p>
     * 有时不愿意用递归
     */
    static class Solution {
        private TrieNode root;
        private String longest;
        //辅助变量，用于选择执行逻辑
        int use = 0;

        public String longestWord(String[] words) {
            if (words.length == 0) {
                return "";
            }
            //初始化trie树
            root = new TrieNode("");
            for (String word : words) {
                insert(word);
            }

            //查找
            if (use == 0) {
                longest = root.val;
                longestWordByRecursion(root, 0);
                return longest;
            } else {
                return longestWordByIteration();
            }
        }

        /**
         * 递归实现。每到一层，就和已有最长串比较。
         *
         * @param root
         * @param n
         */
        private void longestWordByRecursion(TrieNode root, int n) {
            if (!root.isEnd && n > 0) {
                return;
            }

            if (n > longest.length()) {
                longest = root.val;
            } else if (n == longest.length() && root.val.compareTo(longest) < 0) {
                longest = root.val;
            }

            Map<Character, TrieNode> sonMap = root.son;
            if (sonMap.size() > 0) {
                int m = n + 1;
                for (TrieNode son : sonMap.values()) {
                    longestWordByRecursion(son, m);
                }
            }
        }

        /**
         private void longestWordByRecursion2(TrieNode root, int n, String pVal) {
         if (!root.isEnd && n > 0) {
         if (n - 1 > longest.length()) {
         longest = pVal;
         } else if (n-1 == longest.length() && pVal.compareTo(longest) < 0) {
         longest = pVal;
         }
         return;
         }

         //减少比较
         if (root.son.size() == 0) {
         if (n > longest.length()) {
         longest = root.val;
         } else if (n == longest.length() && root.val.compareTo(longest) < 0) {
         longest = root.val;
         }
         } else {
         int m = n + 1;
         for (TrieNode son : root.son.values()) {
         longestWordByRecursion2(son, m, root.val);
         }
         }
         }
         */

        /**
         * 使用队列实现
         *
         * @return
         */
        private String longestWordByIteration() {
            List<String> list = new ArrayList<>();

            Queue<TrieNode> queue = new LinkedList<>();
            queue.add(root);

            while (queue.size() > 0) {

                TrieNode cur = queue.poll();
                if (cur.son.size() > 0) {
                    boolean added = false;
                    for (TrieNode son : cur.son.values()) {
                        if (son.isEnd) {
                            queue.add(son);
                            added = true;
                        }
                    }
                    //如果没有下一个字母是完整的单词
                    if (!added) {
                        list.add(cur.val);
                    }
                } else {
                    list.add(cur.val);
                }

                while (queue.size() > 0 && !queue.peek().isEnd) {
                    queue.poll();
                }
            }

            if (list.size() == 0) {
                return "";
            } else if (list.size() == 1) {
                return list.get(0);
            } else {
                Collections.sort(list, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        if (o1.length() > o2.length()) {
                            return -1;
                        } else if (o1.length() < o2.length()) {
                            return 1;
                        }
                        return o1.compareTo(o2);
                    }
                });
                return list.get(0);
            }
        }

        /**
         * 将一个字符串插入trie树。
         *
         * @param str
         */
        private void insert(String str) {
            if (str == null || str.length() == 0) {
                return;
            }
            TrieNode node = root;
            str = str.toLowerCase();
            char[] letters = str.toCharArray();
            for (int i = 0, len = str.length(); i < len; i++) {
                char c = letters[i];
                if (!node.son.containsKey(c)) {
                    TrieNode son = new TrieNode("");
                    node.son.put(c, son);
                }

                node = node.son.get(c);
            }
            node.isEnd = true;
            node.val = str;
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> son;
        boolean isEnd;// end of a string.
        String val;// value

        TrieNode(String val) {
            this.son = new HashMap<>();
            this.isEnd = false;
            this.val = val;
        }
    }
}
