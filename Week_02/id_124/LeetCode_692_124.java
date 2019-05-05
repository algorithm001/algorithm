import java.util.*;

/***
 *  使用优先级队列实现topk问题
 *
 *
 *
 */
public class TopKFrequent {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> strCnt = new HashMap<>();
        for (String word : words) {
            int cnt = strCnt.getOrDefault(word, 0);
            cnt = cnt + 1;
            strCnt.put(word, cnt);
        }
        Map<Integer, List<String>> cntMap = new HashMap<>();
        for (String key : strCnt.keySet()) {
            List temp = cntMap.getOrDefault(strCnt.get(key), new ArrayList<>());
            temp.add(key);
            cntMap.put(strCnt.get(key), temp);
        }

        Object[] cntList = cntMap.keySet().toArray();
        Arrays.sort(cntList, Collections.reverseOrder());
        for (int i = 0, j = 0; i < k; j++) {
            List<String> temp = cntMap.get(cntList[j]);
            Collections.sort(temp);
            for (int a = 0; i < k && a < temp.size(); i++, a++) {
                result.add(temp.get(a));
            }
        }
        return result;
    }

    public List<String> topKFrequentBypq(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> strCnt = new HashMap<>();
        for (String word : words) {
            int cnt = strCnt.getOrDefault(word, 0);
            cnt = cnt + 1;
            strCnt.put(word, cnt);
        }
        Queue<String> queue = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return strCnt.get(o1).equals(strCnt.get(o2)) ? o2.compareTo(o1) : strCnt.get(o1) - strCnt.get(o2);
            }
        });
        for (String word : strCnt.keySet()) {
            queue.offer(word);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        Collections.reverse(result);
        return result;
    }


    public static void main(String[] args) {
        String[] s = {"i", "love", "leetcode", "i", "love", "coding"};
        new TopKFrequent().topKFrequent(s, 3);
    }

}
