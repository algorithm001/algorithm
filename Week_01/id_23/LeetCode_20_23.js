/**
 * https://leetcode.com/problems/valid-parentheses/
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
  const stringArray = s.split("");
  const stack = [];
  const maps = {
    ")": "(",
    "]": "[",
    "}": "{"
  };

  const result = stringArray.reduce((pre, item) => {
    if (maps[item]) {
      return pre && maps[item] === stack.pop();
    }

    stack.push(item);
    return pre;
  }, true);

  return stack.length === 0 && result;
};
