// https://leetcode-cn.com/problems/valid-anagram/submissions/
// 有效的字母异位词
class Solution {
    public boolean isAnagram(String s, String t) {
        // 考察题型：哈希表
        // （1）把26个字母作为 key，出现次数作为 value，初始值为0表示没出现过或互相抵消了。
        // （2）遍历 s，做 value++；再遍历 t，做 value--。这过程中如果有 value 被减成负的，直接返回 false
        // （3）然后扫描一遍哈希表，如果有非0元素，则false。
        
        // 1. 边界条件，若字符长度不一样，则直接返回
        if(s.length() != t.length()){
            return false;
        }
        
        // 2. 定义哈希表（java语言不需要单独做初始化操作，默认值就是0）
        int[] hash_map = new int[27];
        
        // 3. 第一遍扫描
        for(int i=0;i<s.length();i++){
            int key = s.charAt(i)-'a';
            hash_map[key] += 1;
        }
        
        // 4. 第二遍扫描
        for(int i=0;i<t.length();i++){
            int key = t.charAt(i)-'a';
            if(hash_map[key]==0){
                return false;
            }
            hash_map[key] -= 1;
        }
        
        // 5.扫描哈希表
        for(int i=0;i<27;i++){
            if(hash_map[i]!=0){
                return false;
            }
        }
        
        return true;
    }
}
