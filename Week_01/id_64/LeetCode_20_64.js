/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 通过栈，匹配左刮号进栈，匹配右刮号出栈
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    var stack = [];
    for (var i = 0; i < s.length; i++) {
        var c = s.charAt(i);
        if (/\{|\[|\(/g.test(c)) {
            stack.push(c);
        } else {
            if (!stack.length) { return false; }
            var topChar = stack.pop();
            if (c == '}' && topChar != '{') {
                return false;
            }
            if (c == ']' && topChar != '[') {
                return false;
            }
            if (c == ')' && topChar != '(') {
                return false;
            }
        }
    }
    return !stack.length;
};