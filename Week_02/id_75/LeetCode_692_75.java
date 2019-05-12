//692. top-k-frequent-words(哈希表-中等)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //建散列表统计词频
        Map<String,Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        //建字典序
        List<String>[] list = new List[words.length + 1];
        for(String key:map.keySet()){
            int freq = map.get(key);
            if(list[freq] == null){
                list[freq] = new LinkedList<>();
            }
            list[freq].add(key);
        }
        
        List<String> answer = new LinkedList<>();
        int c = 0;
        //取出前k个出现次数最多的单词
        for(int i = list.length - 1; i > 0; i--){
            if(list[i] != null){
                Collections.sort(list[i]);
                for(int j = 0; j < list[i].size();j++){
                    if(c == k) return answer;
                    answer.add(list[i].get(j));
                    c++;
                }
            }
        }
        return answer;
    }
}