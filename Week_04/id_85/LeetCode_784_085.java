import java.util.ArrayList;
import java.util.List;

public class LeetCode_784_085 {
}

/**
 * @Package:
 * @ClassName: LetterCasePermutation
 * @Description: 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * @leetcode_url:https://leetcode-cn.com/problems/letter-case-permutation/
 * @Author: wangzhao
 * @Date: 2019-05-12 10:35:23
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class LetterCasePermutation {


    public List<String> letterCasePermutation(String S) {

        List<String> result = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return result;
        }

        char[] chars = S.toCharArray();

        permutation(chars,0,result);

        return result;
    }

    private void permutation(char[] chars,int cursor,List<String> result ){
        if (cursor>=chars.length){
            return;
        }
        int temp= cursor;

        if (!result.contains(new String(chars))){
            result.add(new String(chars));
        }
        if (Character.isDigit(chars[cursor])){
            permutation(chars,++cursor,result);
        }else if(chars[cursor]>='a'&& chars[cursor]<='z'){
            permutation(chars,++cursor,result);
            chars[temp]=Character.toUpperCase(chars[temp]);
            if (!result.contains(new String(chars))){
                result.add(new String(chars));
            }
            permutation(chars,++temp,result);
        }else if (chars[cursor]>='A'&&chars[cursor]<='Z'){
            permutation(chars,++cursor,result);
            chars[temp]=Character.toLowerCase(chars[temp]);
            if (!result.contains(new String(chars))){
                result.add(new String(chars));
            }
            permutation(chars,++temp,result);
        }
    }

    public static void main(String[] args) {

        String S = "C";
        List<String> list = new LetterCasePermutation().letterCasePermutation(S);
        list.stream().forEach(System.out::println);

    }
}

