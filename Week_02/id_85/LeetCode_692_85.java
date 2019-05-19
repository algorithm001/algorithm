import java.util.*;

public class LeetCode_692_85 {
}

/**
 * @Package:
 * @ClassName: TopKFrequentWords
 * @Description: 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * **************返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * @Author: wangzhao
 * @Date: 2019-04-23 18:29:11
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0) {
            return null;
        }
        if (k == 0) {
            return null;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            Integer num = map.get(word);
            if (num == null) {
                map.put(word, 1);
            } else {
                map.put(word, ++num);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (o1, o2) -> {
            if (o1.getValue().intValue() == o2.getValue().intValue()) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        });

        List<String> result = new ArrayList<>();
        for (int i = 0; i < (list.size() > k ? k : list.size()); i++) {
            result.add(list.get(i).getKey());
        }
        return result;
    }

    public static void main(String[] args) {

//        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};

        int k = 4;
        List<String> list = new TopKFrequentWords().topKFrequent(words, k);

        list.stream().forEach(System.out::println);

    }

}