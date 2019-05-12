class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        int len = words.length;
        for (int i = 0; i < len; i ++) {
            String word = words[i];
            int value = map.getOrDefault(word, 0) + 1;
            map.put(word, value);
        }

        List<Map.Entry<String, Integer>> entrys = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(entrys, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()){
                    return -1;
                }else if (o1.getValue() < o2.getValue()) {
                    return 1;
                }else {
                    return  o1.getKey().compareTo(o2.getKey());
                }
            }
        });

        List<String> result = new ArrayList<>();
        for (int i=0; i < k; i ++) {
            result.add(entrys.get(i).getKey());
        }

        return result;
    }
}