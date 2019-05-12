class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        for (String s :words)
        {
            map.put(s,map.getOrDefault(s,0)+1);
        }

        PriorityQueue<Map.Entry<String,Integer>> queue=new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().equals(o2.getValue()))
                {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue()-o1.getValue();
            }
        });
        queue.addAll(map.entrySet());
        List<String> res=new ArrayList<>(k);
        for (int i=0;i<k;i++)
        {
            res.add(queue.poll().getKey());
        }
        return res;
    }
}