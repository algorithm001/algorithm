import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-words/submissions/
 *
 * <p> 哈希表 + 链表
 * <p> 中等
 * <p>
 * https://leetcode-cn.com/submissions/detail/17527494/
 *
 * @author aiter 
 * @date 2019/04/23 7:18 AM
 */
public class LeetCode_692_14 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("i".compareTo("love"));
        System.out.println("love".compareTo("lpve"));
        System.out.println("aa".compareTo("aaa"));
        System.out.println("aaa".compareTo("aa"));

        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        //String[] words = {"a", "aa", "aaa"};

        int k = 5;
        List<String> list = solution.topKFrequent(words, k);
        System.out.println(list);
    }

    static class Solution {
        public List<String> topKFrequent(String[] words, int k) {

            HashMap<String, DListNode> hashMap = new HashMap<>(words.length);

            DListNode head = new DListNode(-1, "");
            DListNode tail = new DListNode(-1, "");
            head.next = tail;
            tail.pre = head;

            for (String word : words) {
                /**
                 * 利用hash表，记录word对应的统计数据  O(1)
                 */
                DListNode node = hashMap.get(word);
                if (node == null) {
                    node = new DListNode(1, word);
                    hashMap.put(word, node);
                } else {
                    node.val = node.val + 1;
                }

                /**
                 * 操作双向链表
                 */
                //从链表中，删除。如果已经在双向链表中，先删除
                if (node.next != null) {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                    node.pre = null;
                    node.next = null;
                }

                DListNode cur = head.next;

                // 遍历比较，选择应该插入的位置
                while (cur != tail) {
                    //如果计数大于当前值，插入前面
                    if (node.val > cur.val) {
                        cur.pre.next = node;
                        node.pre = cur.pre;
                        node.next = cur;
                        cur.pre = node;
                        break;
                        //如果计数等于当前值，那么比较字母顺序
                    } else if (node.val == cur.val) {
                        int c = node.word.compareTo(cur.word);
                        //字母顺序更小，插入前面
                        if (c < 0) {
                            cur.pre.next = node;
                            node.pre = cur.pre;
                            node.next = cur;
                            cur.pre = node;
                            break;
                        } else {
                            //指针后移
                            cur = cur.next;
                        }

                    } else {
                        cur = cur.next;
                    }
                }
                // 如果到tail了，还未插入，就插入到tail前面。比如：第一个元素 and 和最后一个元素的val相等，但是字母顺序靠后的({"a", "aa", "aaa"};)。
                if (node.next == null) {
                    tail.pre.next = node;
                    node.next = tail;
                    node.pre = tail.pre;
                    tail.pre = node;
                }
            }

            List<String> list = new ArrayList<>(k);
            DListNode cur = head.next;
            for (int i = 0; i < k; i++) {
                if (cur != tail) {
                    list.add(cur.word);
                    cur = cur.next;
                }
            }

            return list;
        }
    }

    static class DListNode {
        int val;
        String word;
        DListNode pre;
        DListNode next;

        DListNode(int x, String w) {
            val = x;
            word = w;
        }
    }
}
