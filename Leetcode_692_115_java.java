package data.leetcode.hash;

import java.util.*;

public class Leetcode692 {
    /**
     * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
     * <p>
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
     * <p>
     * 示例 1：
     * <p>
     * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     * 输出: ["i", "love"]
     * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
     * 注意，按字母顺序 "i" 在 "love" 之前。
     */

    /**
     * 执行用时 : 17 ms, 在Top K Frequent Words的Java提交中击败了83.42% 的用户
     * 内存消耗 : 41.2 MB, 在Top K Frequent Words的Java提交中击败了74.16% 的用户
     * @param words
     * @param k
     * @return
     */

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            Integer node = wordMap.get(words[i]);
            if (node == null) node = 0;
            node += 1;
            wordMap.put(words[i], node);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(wordMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int code = o1.getValue() - o2.getValue();
                if (code != 0) {
                    return -code;
                } else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });
        List<Map.Entry<String, Integer>> entries = list.subList(0, k);
        for (Map.Entry<String, Integer> entry : entries) {
            wordList.add(entry.getKey());
        }
        return wordList;
    }


    public static void main(String[] args) {

        String words[] = {"i", "love", "leetcode", "i", "love", "coding"};
        topKFrequent(words, 3);
    }

}
