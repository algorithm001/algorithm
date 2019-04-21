/**
 * 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 * 使用 map 累加 s 中每个元素个数，t 递减每个元素个数，元素为零即删除，最终 map size 为 0
 * 
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length != t.length) { return false; }
    const map = new Map();
    for (let i = 0; i < s.length; i++) {
        const e = s.charAt(i);
        if (map.has(e)) {
            map.set(e, map.get(e) + 1);
        } else {
            map.set(e, 1);
        }
    }    
    
    for (let i = 0; i < t.length; i++) {
        const e = t.charAt(i);
        if (map.has(e)) {
            map.set(e, map.get(e) - 1);
            if (map.get(e) == 0) {
                map.delete(e);
            }
        }
    }    
    
    return map.size == 0;
};