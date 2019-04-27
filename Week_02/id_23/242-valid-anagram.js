/**
 * https://leetcode.com/problems/valid-anagram/
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  let result = true;

  const map = s.split("").reduce((pre, cur) => {
    if (undefined === pre[cur]) {
      pre[cur] = 1;
    } else {
      pre[cur]++;
    }
    return pre;
  }, {});

  const lastMap = t.split("").reduce((pre, cur) => {
    if (undefined === pre[cur]) {
      result = false;
    } else {
      pre[cur]--;
    }
    return pre;
  }, map);

  return (
    result &&
    Object.values(lastMap).reduce((pre, cur) => {
      return pre && cur === 0;
    }, true)
  );
};
