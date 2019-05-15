import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_241_129 {
    private Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        int len = input.length();
        // check history
        List<Integer> result = memo.get(input);
        if (result != null) {
            return result;
        }
        result = new ArrayList<>();
        // base case
        if (isDigit(input)) {
            result.add(Integer.parseInt(input));
            memo.put(input, result);
            return result;
        }
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1, len));
                for (Integer il : left) {
                    for (Integer ir : right) {
                        switch (c) {
                            case '+':
                                result.add(il + ir);
                                break;
                            case '-':
                                result.add(il - ir);
                                break;
                            case '*':
                                result.add(il * ir);
                                break;
                        }
                    }
                }
            }
        }
        memo.put(input, result);
        return result;
    }

    private boolean isDigit(String s) {
        for (Character c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
