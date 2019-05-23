package leetcode.Algorithms._1_100._72_EditDistance;

/**
 * Created by jialei.zou on 2019/4/16 .
 ref: https://leetcode.com/problems/edit-distance/
 Given two words word1 and word2, find the minimum number of operations required
 to convert word1 to word2.

 You have the following 3 operations permitted on a word:

 Insert a character
 Delete a character
 Replace a character
 Example 1:

 Input: word1 = "horse", word2 = "ros"
 Output: 3
 Explanation:
 horse -> rorse (replace 'h' with 'r')
 rorse -> rose (remove 'r')
 rose -> ros (remove 'e')
 Example 2:

 Input: word1 = "intention", word2 = "execution"
 Output: 5
 Explanation:
 intention -> inention (remove 't')
 inention -> enention (replace 'i' with 'e')
 enention -> exention (replace 'n' with 'x')
 exention -> exection (replace 'n' with 'c')
 exection -> execution (insert 'u')
 */
public class EditDistance {

    /**
     *  注意点：
     *  1. 要有0 0开始的地方
     *
     *  初始化首行首列后，后续二维数组逐个计算，当前位置的值可以来自三个方向（取最小的作为当前值）
     *  1. 从左侧过来，表明horse的字母增加一个，同一行ros方向字母不变，所以增加为+1
     *  2. 从上面过来，表明ros的字母增加一个，同一列horse方向字母不变，所以增加为+1
     *  3. 从斜上角45度过来，表明行列个增加一个字母，要看增加的字母是否相等，
     *     相等不需要编辑，故+0，不相等，则表示替换，故+1
     *
     *         h   o   r   s   e
     *    -------------------------
     *    | 0 | 1 | 2 | 3 | 4 | 5 |
     *  r | 1 | 1 | 2 | 2 | 3 | 4 |
     *  o | 2 | 2 | 1 | 2 | 3 | 4 |
     *  s | 3 | 3 | 2 | 2 | 2 | 3 |
     *    -------------------------
     */
    public int minDistance(String word1, String word2) {
        if(word1 == null || word1.length()==0){
            return word2 == null? 0: word2.length();
        }
        if(word2 == null || word2.length()==0){
            return word1 == null? 0: word1.length();
        }
        int result[][] = new int[word2.length()+1][word1.length()+1];
        //init for the first row
        for (int i = 0; i<=word1.length(); i++){
            result[0][i] = i;
        }
        //init for the first column
        for (int i = 0; i<=word2.length(); i++){
            result[i][0] = i;
        }
        //calculate the result array
        for (int i = 1; i<= word2.length(); i++){
            for (int j = 1; j<=word1.length(); j++){
                result[i][j] = Math.min(Math.min(result[i-1][j]+1, result[i][j-1]+1),
                        word1.charAt(j-1)==word2.charAt(i-1)? result[i-1][j-1]:result[i-1][j-1]+1);
            }
        }
        return result[word2.length()][word1.length()];
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance("horse", "ros"));
    }
}
