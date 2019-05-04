/**
  * https://leetcode-cn.com/problems/top-k-frequent-words/
 */

public class TopKFrequent {

    /**
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>(k);
        Map<String, Integer> map = new TreeMap<>();
        for (String item : words) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }
        List<Map.Entry<String, Integer>> list = map.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())).collect(Collectors.toList());
        int index = 1;
        for (Entry<String, Integer> entry : list) {
            if (index > k)
                break;
            result.add(entry.getKey());
            index++;
        }
        return result;
    }

}


