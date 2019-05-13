import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
 *
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 *
 * Input: S = "12345"
 * Output: ["12345"]
 * Note:
 *
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 */
public class Leetcode_784_140 {

    public List<String> letterCasePermutation(String S) {

        List<String> s = new ArrayList<String>();
        if (S == null) {
            return new LinkedList<>();
        }

        util(S.toCharArray(), s, 0);
        return s;
    }

    public void util(char[] c_arr, List<String> s, int index) {
        if(index == c_arr.length) {
            s.add(new String(c_arr));
            return;
        }

        if(Character.isDigit(c_arr[index])) {
            util(c_arr,s,index+1);
            return;
        }

        c_arr[index] = Character.toLowerCase(c_arr[index]);
        util(c_arr,s, index+1);

        c_arr[index] = Character.toUpperCase(c_arr[index]);
        util(c_arr,s,index+1);
    }

}
