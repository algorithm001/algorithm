class Solution {
    public String longestWord(String[] words) {
         // 对字符串数组进行排序
        Arrays.sort(words);

        Set<String> set = new HashSet<>();
        String result = new String();
        for (String str : words) {
            if (set.contains(str.substring(0, str.length() - 1)) || str.length() == 1) {
                // 保存更长的哪一个字符串
                result = str.length() > result.length() ? str : result;
                set.add(str);
            }
        }
        return result;
    }
}
