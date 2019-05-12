class Solution {


    /**
     * 241. Different Ways to Add Parentheses
     * Medium
     * https://leetcode.com/problems/different-ways-to-add-parentheses/
     *
     * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators.
     * The valid operators are +, - and *.
     *
     * Example 1:
     *
     * Input: "2-1-1"
     * Output: [0, 2]
     * Explanation:
     * ((2-1)-1) = 0
     * (2-(1-1)) = 2
     * Example 2:
     *
     * Input: "2*3-4*5"
     * Output: [-34, -14, -10, -10, 10]
     * Explanation:
     * (2*(3-(4*5))) = -34
     * ((2*3)-(4*5)) = -14
     * ((2*(3-4))*5) = -10
     * (2*((3-4)*5)) = -10
     * (((2*3)-4)*5) = 10
     *
     */
    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {

        if(map.containsKey(input)) return map.get(input);

        List<Integer> ret = new ArrayList<>();
        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if(c == '*' || c == '-' || c == '+'){
                //分治
                String left = input.substring(0, i);
                String right = input.substring(i+1);
                List<Integer> part1Ret = map.containsKey(left) ? map.get(left) : diffWaysToCompute(left);
                List<Integer> part2Ret = map.containsKey(right) ? map.get(right) : diffWaysToCompute(right);
                for (Integer p1 :   part1Ret) {
                    for (Integer p2 :   part2Ret) {
                        int result = 0;
                        switch (input.charAt(i)) {
                            case '+': result = p1+p2;
                                break;
                            case '-': result = p1-p2;
                                break;
                            case '*': result = p1*p2;
                                break;
                        }
                        ret.add(result);
                    }
                }
            }
        }
        // in case there is no any operator
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        map.put(input, ret);
        return ret;
    }
}