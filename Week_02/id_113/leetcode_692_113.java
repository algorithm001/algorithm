
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null) return null;

        Comparator<Map.Entry> valueComparator = new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                return (Integer)o2.getValue() - (Integer)o1.getValue();
            }
        };

        Map<String, Integer> map = new TreeMap();
        for(String s : words) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        List<Map.Entry<String, Integer>> l = new ArrayList(map.entrySet());
        Collections.sort(l, valueComparator);

        int c = 0;
        List<String> list = new ArrayList();
        for (Map.Entry<String, Integer> entry : l) {
            list.add(entry.getKey());
            ++c;
            if (c >= k) break;
        }

        return list;
    }
}

