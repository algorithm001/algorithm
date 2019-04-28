/**
  * @author okbeng
  * @desc 首先将字符串转换成 char 数组，然后对其进行排序，最后在用 Arrays 工  *       具类判断其是否相同。注意限类判断条件。
  * @date 2019-04-18 22:49
  */
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] arr1 = s.toCharArray();
        Arrays.sort(arr1);
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}
