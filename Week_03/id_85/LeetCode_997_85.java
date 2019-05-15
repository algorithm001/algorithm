import java.util.ArrayList;
import java.util.HashMap;

public class LeetCode_997_85 {
}


/**
 * @Package:
 * @ClassName: FindTownJudge
 * @Description: 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 * **************如果小镇的法官真的存在，那么：
 * **************小镇的法官不相信任何人。
 * ***************每个人（除了小镇法官外）都信任小镇的法官。
 * ***************只有一个人同时满足属性 1 和属性 2 。
 * ***************给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 * ***************如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 * @leetcode url:https://leetcode-cn.com/problems/find-the-town-judge/
 * @Author: wangzhao
 * @Date: 2019-05-05 10:12:48
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class FindTownJudge {

    public int findJudge(int N, int[][] trust) {
        if (trust == null) {
            return -1;
        }
        if (N <= 0) {
            return -1;
        }
        if(trust.length==0){
            return 1;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        HashMap<Integer, ArrayList<Integer>> map2 = new HashMap<>();

        for (int i = 0; i < trust.length; i++) {
            int t0 = trust[i][0];
            int t1 = trust[i][1];

            ArrayList<Integer> array = map.get(t0);
            if (array == null) {
                array = new ArrayList<Integer>();
            }
            array.add(t1);
            map.put(t0, array);

            if (map.get(t1) == null) {
                map.put(t1, new ArrayList<Integer>());
            }

            ArrayList<Integer> array2 = map2.get(t1);
            if (array2 == null) {
                array2 = new ArrayList<Integer>();
            }
            array2.add(t0);
            map2.put(t1, array2);

            if (map2.get(t0) == null) {
                map2.put(t0, new ArrayList<Integer>());
            }
        }

        int jude = -1;
        for (Integer integer : map.keySet()) {
            ArrayList list = map.get(integer);
            if (list.size() == 0) {
                jude = integer;
                break;
            }
        }

        if (jude != -1) {
            ArrayList arr = map2.get(jude);
            if (arr == null || arr.size() != N - 1) {
                jude = -1;
            }
        }

        return jude;
    }

    public static void main(String[] args) {
//        int N = 4;
//        int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};

        int N = 3;
        int[][] trust = {{1, 3}, {2, 3}};

        int res = new FindTownJudge().findJudge(N, trust);

        System.out.println(res);
    }

}