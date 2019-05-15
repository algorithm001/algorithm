import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
class SolutionGraph {
    public int findJudge(int N, int[][] trust) {
        //记录每个人被人相信的次数
        int[] outgoing = new int[N+1];
        //记录每个人相信别人的次数
        int[] incoming = new int[N+1];
        for(int i=0; i<trust.length; i++) {
            int o = trust[i][0];
            int in = trust[i][1];
            outgoing[o] += 1;
            incoming[in] += 1;
        }
        for(int i=1; i<N+1; i++) {
            //相信i的人N-1个且i相信的人为0
            if(incoming[i] == N-1 && outgoing[i] == 0)
                return i;
        }
        return -1;
    }
}

public class TestGraph {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int N = Integer.parseInt(line);
            line = in.readLine();
            int[][] trust = stringToInt2dArray(line);
            int ret = new SolutionGraph().findJudge(N, trust);
            String out = String.valueOf(ret);
            System.out.print(out);
        }
    }
}