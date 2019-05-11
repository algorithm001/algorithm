方法一（不推荐，效率很低，都过不了leetcode，使用字符替换）：
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null && t != null) return false;
        if(s != null && t == null) return false;
        if(s.length() != t.length()) return false;
        
        String exe = t;
        for(int i=0; i< s.length(); i++){
            exe = exe.replaceFirst(s.substring(i, i+1), "");
        }
        
        if(exe.equals("")) return true;
        
        return false;
    }
}
方法二（转成排序，然后再转成字符串比较相等）：
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null && t != null) return false;
        if(s != null && t == null) return false;
        
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        
        quickSort(s1, 0, s1.length-1);   //我自己写了个快排，java有现成的方法：Arrays.sort()
        quickSort(t1, 0, t1.length-1);
        String s2 = String.valueOf(s1);
        String t2 = String.valueOf(t1);
        
        if(s2.equals(t2)) return true;
        return false;
        
    }
    
    private void quickSort(char[] a, int start, int end){         
        if(start >= end) return;
        char middle = a[end];
        int i = start;
        int j = start;
        char tmp;
        
        while(j <= end){
            if(a[j] >= middle){
                tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
            j++;
        }
        
        quickSort(a, start, i-2);
        quickSort(a, i, end);
    }
}

方法三（哈希表）：
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null && t != null) return false;
        if(s != null && t == null) return false;
        
        Map<Character, Integer> map = new HashMap();
        char[] ccc = s.toCharArray();
        char[] ttt = t.toCharArray();
        for(char c : ccc){
            if(map.get(c) == null){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c)+1);
            }
        }
        
        for(char t1: ttt){
            if(map.get(t1) == null){
                return false;
            }else if(map.get(t1) == 1) {
                map.remove(t1);
            }else {
                map.put(t1, map.get(t1)-1);
            }
        }
        
        
        return map.isEmpty();
    }
}

方法四（数组）：
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null && t != null) return false;
        if(s != null && t == null) return false;
        
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        
        int[] s1 = new int[26];
        int[] t1 = new int[26];
        for(char sss: ss){
            s1[sss - 'a']++;
        }
        
        for(char ttt: tt){
            t1[ttt - 'a']++;
        }
        
        for(int i =0; i<26; i++){
            if(s1[i] != t1[i]) return false;
        }
        return true;
    }
}
