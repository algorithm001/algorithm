// https://leetcode.com/problems/longest-word-in-dictionary/

/**
 * @param {string[]} words
 * @return {string}
 */
const longestWord = (words) => {
    const dic = {'': true};
    words.forEach(w => dic[w] = null);
    let ret = '';

    const check = (word) => {
        if (dic[word] === undefined) return false;
        if (dic[word] === null) dic[word] = check(word.substring(0, word.length - 1));
        return dic[word];
    };
    
    for (const w of words) {
        if (check(w) && w.length >= ret.length)
            ret = w.length > ret.length ? w : (w > ret ? ret : w);
    }
    return ret;
};