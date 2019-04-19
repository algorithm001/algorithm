/**
 * 算法训练营第一周作业 数组-->简单
 * 
 * LeetCode  905. 按奇偶排序数组
 * 
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 * 
 * 示例：
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * 
 */


 /**
 * @param {number[]} A
 * @return {number[]}
 */
var sortArrayByParity = function(A) {
    let array =[];
    for(let i=0;i<A.length;i++)
        {
            if(A[i]%2 == 0)
                {
                    array.unshift(A[i]);
                }
            else
                {
                    array.push(A[i]);
                }
        }
    return array;
  
}

 /**
 * @param {number[]} A
 * @return {number[]}
 */
var sortArrayByParity = function(A) {
    return A.sort((a,b)=>(a%2-b%2));
   
 }