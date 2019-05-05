//https://leetcode.com/problems/top-k-frequent-words/
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length <= 0)
            return new ArrayList();
        Map<String, Integer> cntMap = new HashMap<>();
        for (String word : words) {
            cntMap.put(word, cntMap.containsKey(word) ? cntMap.get(word) + 1 : 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue(k, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                int sub = e1.getValue() - e2.getValue();
                if (sub > 0)
                    return 1;
                else if (sub < 0)
                    return -1;
                else {
                    return e2.getKey().compareTo(e1.getKey());
                }
            }
        });
        for (Map.Entry<String, Integer> entry : cntMap.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry);
            } else if (queue.peek().getValue() < entry.getValue() || (queue.peek().getValue() == entry.getValue()) && queue.peek().getKey().compareTo(entry.getKey()) > 0) {
                queue.poll();
                queue.offer(entry);
            }
        }
        LinkedList<String> ret = new LinkedList<>();
        while (!queue.isEmpty()) {
            ret.addFirst(queue.poll().getKey());
        }
        return ret;
    }
}