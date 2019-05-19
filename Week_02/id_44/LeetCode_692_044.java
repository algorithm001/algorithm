import java.util.*;

public class LeetCode_692_044 {
    public List<String> solution(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> d = new HashMap<>();
        for (String s : words) {
            if (d.get(s) == null) {
                d.put(s, 1);
            } else {
                d.put(s, d.get(s) + 1);
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> pp = new PriorityQueue<>((x, y) -> {
            if (x.getValue() < y.getValue()) return 1;
            else if (x.getValue() > y.getValue()) return -1;
            else return x.getKey().compareTo(y.getKey());
        });
        for (Map.Entry<String, Integer> i : d.entrySet()) {
            pp.add(i);
        }
        for (int i = 0; i < k; ++i) {
            String temp = pp.peek().getKey();
            res.add(temp);
            pp.poll();
        }
        return res;
    }
}
