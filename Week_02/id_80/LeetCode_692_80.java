class Solution {


    public List<String> topKFrequent1(String[] words, int k) {
            Map<String, Integer> count = new HashMap();
            for (String word: words) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
            List<String> candidates = new ArrayList(count.keySet());
            Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                    w1.compareTo(w2) : count.get(w2) - count.get(w1));
    
            return candidates.subList(0, k);
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String str : words) {
            Integer count = countMap.get(str);
            if (count != null) {
                count++;
            } else {
                count = 1;
            }
            countMap.put(str, count);
        }
        Map<Integer, List<String>> listMap = new HashMap<>();

        for (String key : countMap.keySet()) {
            Integer count = countMap.get(key);
            List<String> stringList = listMap.get(count);
            if (stringList == null) {
                stringList = new ArrayList<>();
            }
            stringList.add(key);
            listMap.put(count, stringList);
        }

        Set<Integer> keySet = listMap.keySet();
        Object[] keyArray = keySet.toArray();
        Arrays.sort(keyArray);
        List<String> resultList = new ArrayList<>();
        for (int i = keyArray.length - 1; i >= 0; i--) {
            Object count = keyArray[i];
            List<String> sl = listMap.get(count);
            Object[] ss = sl.toArray();
            Arrays.sort(ss);
            for (Object s : ss) {
                if (resultList.size() < k) {
                    resultList.add(String.valueOf(s));
                } else {
                    return resultList;
                }
            }
        }
        return resultList;
    }
}