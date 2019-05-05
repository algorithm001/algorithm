import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/05/04
 */
public class LeetCode_210_108 {
    class Solution {
        //拓扑排序、广度优先遍历
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[][] matrix = markMatrix(numCourses, prerequisites);
            int[] inDegree = inDegree(numCourses, prerequisites);
            List<Integer> starts = new ArrayList<>();

            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    starts.add(i);
                }
            }
            if (starts.isEmpty()) {
                return new int[]{};
            }
            return bfs(matrix,inDegree,starts);
        }

        private int[] bfs(int[][] matrix,int[] inDegree, List<Integer> starts) {
            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> result = new LinkedList<>();
            queue.addAll(starts);
            while (!queue.isEmpty()){
                Integer poll = queue.poll();
                if(result.contains(poll)){
                    return new int[]{};
                }
                result.offer(poll);
                List<Integer> destinations = destinations(matrix, poll);
                destinations.forEach(i->{
                    if((--inDegree[i]) == 0){
                        queue.offer(i);
                    }
                });
            }
            if (result.size() != matrix.length){
                return new int[]{};
            }
            int[] orderArr = new int[matrix.length];
            for (int i = 0; i < orderArr.length; i++) {
                orderArr[i] = result.poll();
            }
            return orderArr;
        }

        private List<Integer> destinations(int[][] matrix, int start){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < matrix[start].length; i++) {
                if(matrix[start][i] == 1){
                    list.add(i);
                }
            }
            return list;
        }

        private int[][] markMatrix(int N, int[][] trust) {
            int[][] matrix = new int[N][N];
            for (int i = 0; i < trust.length; i++) {
                int x = trust[i][1];
                int y = trust[i][0];
                matrix[x][y] = 1;
            }
            return matrix;
        }

        private int[] inDegree(int N, int[][] trust) {
            int[] inDegree = new int[N];
            for (int i = 0; i < trust.length; i++) {
                int x = trust[i][0];
                inDegree[x] = inDegree[x] + 1;
            }
            return inDegree;
        }
    }
}
