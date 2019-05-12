class Solution {
    public String longestWord(String[] words) {
        //先对数组排序，再利用Set储存特性进行存储
        Arrays.sort(words);

        Set<String> set = new HashSet<>();
        
        String res = "";
        for (String s : words) {
            //这里判断如果只有一个长度，说明是一个字母，为共有
            if (1 == s.length() || set.contains(s.substring(0, s.length() - 1))) {
                res = s.length() > res.length() ? s : res;
                set.add(s);
            }
        }
        //最后返回这个字符串
        return res;
    }
}
