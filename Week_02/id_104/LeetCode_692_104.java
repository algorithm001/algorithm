class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //思路 
        //1.遍历单词 统计每个单词出现的数量
        Map<String,Integer> wordsMap=new HashMap<String,Integer>();
        int num=0;
        for(String word:words){
            wordsMap.put(word,wordsMap.getOrDefault(word,0)+1);
        }
        
        PriorityQueue<Map.Entry<String,Integer>> queue=new PriorityQueue<>(
           new Comparator<Map.Entry<String,Integer>>(){
               @Override
               public int compare(Map.Entry<String,Integer> o1,Map.Entry<String,Integer> o2){
                   if(o1.getValue()==o2.getValue()){
                       return o1.getKey().compareTo(o2.getKey());
                   }
                   return o2.getValue()-o1.getValue();                   
               }
           }
        );
        queue.addAll(wordsMap.entrySet());
        List<String> res=new ArrayList(k);
        for(int i=0;i<k;i++){
            res.add(queue.poll().getKey());
        }
        return res;
    }
}