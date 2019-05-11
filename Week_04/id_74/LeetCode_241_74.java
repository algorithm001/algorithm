import java.util.*;

class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char op = input.charAt(i);
            if (op == '-' || op == '*' || op == '+') {
                String p1 = input.substring(0, i);
                String p2 = input.substring(i+1);
                List<Integer> result1 = diffWaysToCompute(p1);
                List<Integer> result2 = diffWaysToCompute(p2);
                
                for (Integer r1 : result1) {
                    for (Integer r2 : result2) {
                        if (op == '+') {
                            result.add(r1 + r2);
                        } else if (op == '-') {
                            result.add(r1 - r2);
                        } else if (op == '*') {
                            result.add(r1 * r2);
                        }
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}