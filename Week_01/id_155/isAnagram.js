/**
 * 算法训练营第一周作业 排序-->简单
 * 
 * leetcode 242. 有效的字母异位词
 * 
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * 
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */

 /**
  * 第一种方法
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    var len=s.length
    for(var i=0;i<len;i++){
        if(s==t || s.length!=t.length) break;
        t=t.replace(new RegExp(s[0],'g'),"");        
        s=s.replace(new RegExp(s[0],'g'),"");
    }
    return s==t? true:false; 
};








/**
 * 第二种方法
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if(s.length!=t.length) return false;
let sarr={}, tarr={}
for(let i in s){
    if(sarr[s[i]] >=1){
        sarr[s[i]]+=1
    }else{
        sarr[s[i]]=1
    }
}
for(let i in t){
    if(tarr[t[i]] >=1){
        tarr[t[i]]+=1
    }else{
        tarr[t[i]]=1
    }
}
for(let i in sarr){
    if(sarr[i]!=tarr[i]) return false;
}
return true;

};



