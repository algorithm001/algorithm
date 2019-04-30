class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> topkList = new LinkedList<>();
        if (k == 0) {
            return topkList;
        }
        Map<String, Integer> countMap = new TreeMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        countMap.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .limit(k)
            .forEachOrdered(entry -> topkList.add(entry.getKey()));

        return topkList;
    }
}