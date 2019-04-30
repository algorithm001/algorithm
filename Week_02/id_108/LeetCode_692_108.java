import java.util.*;

/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/04/28
 */
public class LeetCode_692_108 {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            if(words == null || words.length == 0 ){
                return new ArrayList<>();
            }
            HashMap<String,Integer> map = new HashMap<String,Integer>();
            Integer count = null;
            for(int i=0; i<words.length; i++){
                count = map.get(words[i]);
                if(map.containsKey(words[i])){
                    map.put(words[i],count + 1);
                }else{
                    map.put(words[i],1);
                }
            }
            PriorityQueue<String> priorityQueue = new PriorityQueue(k,
                    (Comparator<String>) (o1, o2) -> map.get(o1) == map.get(o2) ? o1.compareTo(o2) : - map.get(o1).compareTo(map.get(o2)));

            map.keySet().forEach(priorityQueue::offer);

            List<String> result = new LinkedList<>();

            while ((k--)!=0){
                String peek = priorityQueue.poll();
                result.add(peek);
            }
            return result;
        }


    }
}
