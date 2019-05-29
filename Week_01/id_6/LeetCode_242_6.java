

// LeetCode 242
    public boolean isAnagram(String s, String t) {

        // 两个字符串长度必须相等
        int sLen = s.length();
        int tLen = t.length();

        if (sLen != tLen){
            return false;
        }

        // s存入hash表，<字符, 次数>
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sLen; i++) {
            char a = s.charAt(i);
            if (map.containsKey(a)){
                map.put(a, map.get(a)+1);
            }else {
                map.put(a, 1);
            }
        }


        // 遍历t，在hash表查找每个字符
        for (int i = 0; i < tLen; i++) {
            char a = t.charAt(i);
            if (map.containsKey(a)){
                // 次数-1
                int n = map.get(a);
                if (n-1 > 0) {
                    map.put(a, n-1);
                }else {
                    map.remove(a);
                }
            }
            else {
                return false;
            }
        }

        return true;
    }

    