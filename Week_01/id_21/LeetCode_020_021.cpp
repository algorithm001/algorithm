class Solution {
public:
  bool isValid(string s) {
    stack<char> temp;
    for (int i = 0; i < s.size(); i++) {
      if (s.size() > 0 && isPair(temp.top(), s[i])) {
        temp.pop();
      } else {
        temp.push(s[i]);
      }
    }
    return temp.size() == 0;
  }

private:
  bool isPair(char left, char right) {
    if (left == '(' && right == ')') return true;
    if (left == '[' && right == ']') return true;
    if (left == '{' && right == '}') return true;
    return false;
  }
};