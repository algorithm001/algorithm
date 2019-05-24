package divideandconquer;
// Source : https://leetcode.com/problems/different-ways-to-add-parentheses/
// Id     : 241
// Author : Fanlu Hai
// Date   : 2018-05-24
// Other  :
// Tips   : "improvements" can make program run slower

import java.util.*;

public class DifferentWaysToAddParentheses {

    //32.84% 3 ms 34.61% 39.6 MB
    public List<Integer> diffWaysToComputeSlow(String input) {
        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);

                List<Integer> resultPart1 = new LinkedList<>();
                List<Integer> resultPart2 = new LinkedList<>();
                resultPart1 = diffWaysToComputeSlow(part1);
                resultPart2 = diffWaysToComputeSlow(part2);

                // when either on is empty, nothing will be added to result
                for (int res1 : resultPart1) {
                    for (int re2 : resultPart2) {
                        switch (input.charAt(i)) {
                            case '+':
                                result.add(res1 + re2);
                                break;
                            case '-':
                                result.add(res1 - re2);
                                break;
                            case '*':
                                result.add(res1 * re2);
                                break;
                        }
                    }
                }
            }
        }
        // if nothing is added to result list, it means the string is a number
        if (result.isEmpty())
            result.add(Integer.valueOf(input));
        return result;
    }

    // use map to store intermediate results to speed up recursion
    Map<String, List<Integer>> resultCache = new HashMap<>();


    //1 ms 100%  34.2 MB 100%
    public List<Integer> diffWaysToCompute(String input) {

        if (resultCache.containsKey(input))
            return resultCache.get(input);

        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);

                List<Integer> resultPart1 = new LinkedList<>();
                List<Integer> resultPart2 = new LinkedList<>();
                resultPart1 = diffWaysToCompute(part1);
                resultPart2 = diffWaysToCompute(part2);

                // when either on is empty, nothing will be added to result
                for (int res1 : resultPart1) {
                    for (int re2 : resultPart2) {
                        //using swith here is not very efficient
                        // 78.94% 2 ms 100.00% 34.2 MB
                        //                        switch (input.charAt(i)) {
//                            case '+':
//                                result.add(res1 + re2);
//                                break;
//                            case '-':
//                                result.add(res1 - re2);
//                                break;
//                            case '*':
//                                result.add(res1 * re2);
//                                break;
//                        }
                        if (input.charAt(i) == '+')
                            result.add(res1 + re2);
                        else if (input.charAt(i) == '-')
                            result.add(res1 - re2);
                        else
                            result.add(res1 * re2);

                    }
                }
            }
        }
        // if nothing is added to result list, it means the string is a number
        if (result.isEmpty())
            result.add(Integer.valueOf(input));
        resultCache.put(input, result);
        return result;
    }
}
