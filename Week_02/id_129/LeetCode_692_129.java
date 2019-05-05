import java.util.*;

public class LeetCode_692_129 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k)
                pq.poll();
        }
        while (!pq.isEmpty())
            result.add(0, pq.poll().getKey());

        return result;
    }

    public List<String> topKFrequent2(String[] words, int k) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        Set<Map.Entry<String, Integer>> set = new TreeSet<>(
                (a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()
        );
        for (Map.Entry<String, Integer> entry : map.entrySet()) set.add(entry);
        Iterator<Map.Entry<String, Integer>> iter = set.iterator();
        while (k-- > 0) list.add(iter.next().getKey());

        return list;
    }
}
