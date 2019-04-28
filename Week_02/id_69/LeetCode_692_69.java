class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String, Integer> map = new HashMap<>();
        // 统计单词出现次数
        for (String word: words) {
            if(map.containsKey(word)){
                map.put(word, map.get(word) + 1);
            }else{
                map.put(word, 1);
            }
        }

        Queue<String> queue = new PriorityQueue<>( new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(map.get(s1) < map.get(s2)){
                    return -1;
                }else if(map.get(s1) > map.get(s2)) {
                    return 1;
                }else{
                    return s2.compareTo(s1);
                }
            }
        });

        for (int i = 0, length = words.length; i < length; i++) {

            if(queue.contains(words[i])) {
                continue;
            }

            if(queue.size() < k) {
                queue.offer(words[i]);
            }else{
                // 单词出现次数大于队列头
                if(map.get(words[i]) > map.get(queue.peek())){
                    queue.poll();
                    queue.offer(words[i]);
                // 单词出现次数与队列头相同，并且字母顺序小于队列头
                }else if(map.get(words[i]) == map.get(queue.peek()) && queue.peek().compareTo(words[i]) > 0){
                    queue.poll();
                    queue.offer(words[i]);
                }
            }
        }

        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()){
            list.add(queue.poll());
        }
        Collections.reverse(list);

        return list;
    }
}
