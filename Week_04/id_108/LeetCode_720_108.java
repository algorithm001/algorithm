
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/05/12
 */
public class LeetCode_720_108 {


    class Solution1 {
        // 方法一：比较次数较多
        public String longestWord(String[] words) {
            Arrays.sort(words);
            Set<String> set = new HashSet<>();
            String longest = "";
            for (String word : words) {
                if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                    set.add(word);
                    if (word.length() > longest.length()) {
                        longest = word;
                    }
                }
            }
            return longest;
        }
    }

    class Solution2 {
        //方法二：trie树，比较耗内存
        private TreeNode root;
        private char startChar = 'a';
        private String longest = "";

        public String longestWord(String[] words) {
            for (String word : words) {
                insert(word);
            }
            findLongest(root, "");
            return longest;
        }

        private void insert(String word) {
            if (root == null) {
                root = new TreeNode();
            }
            TreeNode tmp = root;

            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - startChar;
                TreeNode child = tmp.getChildren()[index];
                if (child == null) {
                    TreeNode node = new TreeNode();
                    node.setTimes(1).setWord(i == word.length() - 1);
                    tmp.getChildren()[index] = node;
                } else {
                    boolean isWord = child.isWord;
                    child.setTimes(child.getTimes() + 1).setWord(isWord || i == word.length() - 1);
                }
                tmp = tmp.getChildren()[index];
            }
        }

        private void findLongest(TreeNode node, String word) {
            for (int index = 0; index < 26; index++) {
                if (node.getChildren()[index] != null && node.getChildren()[index].isWord) {
                    String newWord = word + (char) ('a' + index);
                    if (newWord.length() > longest.length()) {
                        longest = newWord;
                    }
                    findLongest(node.getChildren()[index], newWord);
                }
            }
        }

        private class TreeNode {
            private boolean isWord;
            private TreeNode[] children = new TreeNode[26];
            private int times;

            public boolean isWord() {
                return isWord;
            }

            public TreeNode setWord(boolean word) {
                isWord = word;
                return this;
            }

            public TreeNode[] getChildren() {
                return children;
            }

            public TreeNode setChildren(TreeNode[] children) {
                this.children = children;
                return this;
            }

            public int getTimes() {
                return times;
            }

            public TreeNode setTimes(int times) {
                this.times = times;
                return this;
            }
        }
    }

}
