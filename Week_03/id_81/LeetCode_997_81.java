import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 找到小镇的法官
 * 
 * @link leetcode 997
 * @author apple
 */
public class FindJudge {
	// 目前短暂的思路: 把其想象成一个有向图，所以设置了两个map来保存，一个保    // 存其出度，一个保存其入度。如果某个的出度为0 ，入度为N-1,那就认为这个
	// 值就是要找的法官
    public static int findJudge(int N, int[][] trust) {
        Map<Integer, Integer> output = new HashMap<>();
        Map<Integer, Integer> input = new HashMap<>();

        for (int n = 1; n <= N; ++n) {
            output.put(n, 0);
            input.put(n, 0);
        }
        for (int i = 0; i < trust.length; ++i) {
            int[] arr = trust[i];
            output.put(arr[1], output.get(arr[1]) + 1);
            input.put(arr[0], input.get(arr[0]) - 1);
        }
        for (Entry<Integer, Integer> entry : output.entrySet()) {
            int key = entry.getKey();
            if (entry.getValue() == N - 1 && input.get(key) == 0)
                return key;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] trust = new int[][] { { 1, 3 }, { 2, 3 }, { 3, 1 } };
        System.out.println(findJudge(3, trust));
    }
}
