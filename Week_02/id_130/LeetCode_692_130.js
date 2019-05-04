// https://leetcode.com/problems/top-k-frequent-words/

/**
 * @param {string[]} words
 * @param {number} k
 * @return {string[]}
 */
var topKFrequent = function(words, k) {
    const counts = {};
    for(let i = 0; i < words.length; i++) {
        counts[words[i]] ? counts[words[i]]++ : counts[words[i]] = 1;
    }
    
     const keys = Object.keys(counts).sort((a, b) => {
        if (counts[a] === counts[b]) {
            if (a > b) {
                return 1;
            } else {
                return -1;
            }
        }
        else {
            return counts[b] - counts[a];
        }
	})
	.slice(0, k);   
    
    return keys.slice(0, k);
};