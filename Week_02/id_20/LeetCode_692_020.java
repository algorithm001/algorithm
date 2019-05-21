class Solution {
    public List<String> topKFrequent(String[] words, int k) {
      
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if (o1.getValue().equals(o2.getValue())) {
                            return o1.getKey().compareTo(o2.getKey());
                        }
                        return o2.getValue() - o1.getValue();
                    }
                });

        priorityQueue.addAll(map.entrySet());
        List<String> ret = new ArrayList<>(k);
        for(int i=0; i<k; i++) {
            ret.add(priorityQueue.poll().getKey());
        }
        return ret;
    }
}
