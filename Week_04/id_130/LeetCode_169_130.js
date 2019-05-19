// https://leetcode.com/problems/majority-element/submissions/

var majorityElement = function(nums) {
    var stack = {};
    var maxElement = nums[0];
    for (i = 0; i < nums.length; i++){
        if (!(nums[i] in stack)) {
            stack[nums[i]] = 1
        } else stack[nums[i]]++
        
        if (stack[nums[i]] > stack[maxElement]){
            maxElement = nums[i]
        }
    }
    return maxElement
};

/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    const len = nums.length;
    const counts = {};
    const result = [];
    for (let i = 0; i < len; i++) {
        counts[nums[i]] ? counts[nums[i]]++ : counts[nums[i]] = 1; 
    }
    
    for (let i in counts) {
        if (counts[i] > len / 2) result.push(i);
    }
    
    return result;
};