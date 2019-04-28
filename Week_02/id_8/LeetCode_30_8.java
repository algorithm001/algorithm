class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return new ArrayList<>(0);
        }

        HashMap<String, Integer> map = buildMap(words);

        List<Integer> result = new ArrayList<>();
        int wWidth = words[0].length();
        int count = 0;
        String word = "";

        for (int i = 0; i < s.length(); ++i) {
            if (count != 0) {
                map = buildMap(words);
            }
            count = 0;

            int end = i + wWidth * words.length;
            if (end > s.length()) {
                break;
            }
            for (int j = i; j < end; j = j + wWidth) {
                word = s.substring(j, Math.min(s.length(), j + wWidth));
                Integer v = map.get(word);
                if (v == null || v == 0) {
                    break;
                } else {
                    map.put(word, --v);
                    ++count;
                    if (count == words.length) {
                        result.add(i);
                        break;
                    }
                }

            }

        }

        return result;
    }

    public static HashMap<String, Integer> buildMap(String[] words) {
        HashMap<String, Integer> result = new HashMap<>(words.length <<2);
        for (String w : words) {
            Integer v = result.remove(w);
            if (v != null) {
                result.put(w, ++v);
            } else {
                result.put(w, 1);
            }
        }
        return result;
    }
}