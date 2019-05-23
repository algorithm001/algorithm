package leetcode.Algorithms._701_800._784_LetterCasePermutation;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jialei.zou on 2019/5/10 .
 ref:
 https://leetcode-cn.com/problems/letter-case-permutation/
 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。

 示例:
 输入: S = "a1b2"
 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]

 输入: S = "3z4"
 输出: ["3z4", "3Z4"]

 输入: S = "12345"
 输出: ["12345"]
 注意：

 S 的长度不超过12。
 S 仅由数字和字母组成。
 */
public class LetterCasePermutation {

    /**
     * 后续在看下其他人的提交
     * 关注点：
     * 1. start == chars.length
     * 2. char中 小写字母的值更大
     *
     * @param S
     * @return
     */
    public List<String> letterCasePermutation(String S) {
        List<String> result = new LinkedList<>();
        if(S == null || S ==""){
            return result;
        }
        char[] chars = S.toCharArray();
        helper(0, chars, result);
        return result;
    }

    private void helper(int start, char[] chars, List<String> result){
        if(start == chars.length){
            result.add(new String(chars));
            return;
        }
        if(chars[start]>='a' && chars[start]<='z'){
            chars[start] = (char)(chars[start]-32);
            helper(start+1, chars, result);
            chars[start] = (char)(chars[start]+32);
        }
        if(chars[start]>='A' && chars[start]<='Z'){
            chars[start] = (char)(chars[start]+32);
            helper(start+1, chars, result);
            chars[start] = (char)(chars[start]-32);
        }
        helper(start+1, chars, result);
    }

    public void printList(List<String> list){
        for (String item: list){
            System.out.printf(item+",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LetterCasePermutation permutation = new LetterCasePermutation();
        System.out.println("a1b2");
        permutation.printList(permutation.letterCasePermutation("a1b2"));
//        System.out.println("3z4");
//        permutation.printList(permutation.letterCasePermutation("3z4"));
//        System.out.println("12345");
//        permutation.printList(permutation.letterCasePermutation("12345"));


    }
}
