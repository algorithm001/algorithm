class LeetCode_692_95 {
      public List<String> topKFrequent(String[] words, int k) {
             Map<String,Integer> countMap = new HashMap<>();
        for(String word:words)
            countMap.put(word,countMap.getOrDefault(word,0)+1);
 
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(k, new Comparator<String>() {
           
            public int compare(String o1, String o2) {
                return countMap.get(o1).equals(countMap.get(o2))?       o2.compareTo(o1):countMap.get(o1)-countMap.get(o2);
            }
        });
        for (String word : countMap.keySet()) {
            priorityQueue.offer(word);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        List<String> ans = new ArrayList<>();
        while (!priorityQueue.isEmpty()) ans.add(priorityQueue.poll());
        Collections.reverse(ans);
        return ans;
    }
}