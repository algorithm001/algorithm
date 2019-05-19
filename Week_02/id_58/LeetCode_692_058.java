package algorithm.Week_02.id_58;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 692. Top K Frequent Words
 *
 * Given a non-empty list of words, return the k most frequent elements.
 *
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 *     Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *     with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 *
 * 分析 ： 这里是取最大的值，可以借助Java里的最大堆的数据结构  PriorityQueue
 * @auther: guangjun.ma
 * @date: 2019/4/27 17:07
 * @version: 1.0
 */
public class LeetCode_692_058 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap();

        //把元素都放入到map中
        for(String s : words){
            map.put(s,map.getOrDefault(s,0) + 1);
        }

        //优先队列  最大堆
        PriorityQueue<Map.Entry<String,Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<String,Integer>>(){
            @Override
            public int compare(Map.Entry<String,Integer> o1,Map.Entry<String,Integer> o2){
                if(o1.getValue() .equals(o2.getValue()) ){
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });

        //将map中的元素加入到队列中
        queue.addAll(map.entrySet());

        //依次取出k个值
        List<String> res = new ArrayList<>(k);
        for(int i = 0; i <k ; i++){
            res.add(queue.poll().getKey());
        }
        return res;

    }
}
