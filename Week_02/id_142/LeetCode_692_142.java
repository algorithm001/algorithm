import static java.util.stream.Collectors.toList;
import static java.util.Collections.reverseOrder;

import java.util.Map;
import java.util.List;
import java.util.Comparator;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new TreeMap<>();
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }
        List<String> list = map.entrySet()
            .stream()
            .sorted(reverseOrder(Map.Entry.comparingByValue()))
            .map(Map.Entry<String, Integer>::getKey)
            .limit(k)
            .collect(toList());
        return list;
    }
}
