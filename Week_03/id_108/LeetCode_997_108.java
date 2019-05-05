package com.algorithm;


/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/05/04
 */
public class LeetCode_997_108 {
    class Solution1 {
        /**
         *1、标记正方形，如果二维数组上含有，则标记为0
         *2、判断正方形符合行为0，列为1（除了行等于列那一格）
         */
        //正方形中，法官一定是行行上的值都为0，列上的值除了自己那一格，都是0
        public int findJudge(int N, int[][] trust) {
            int[][] matrix = markMatrix(N, trust);
            for (int i = 0; i < matrix.length; i++) {
                if (checkRow(i, matrix) && checkColumn(i, matrix)) {
                    return i + 1;
                }
            }
            return -1;
        }

        private int[][] markMatrix(int N, int[][] trust) {
            int[][] matrix = new int[N][N];
            for (int i = 0; i < trust.length; i++) {
                int x = trust[i][0] - 1;
                int y = trust[i][1] - 1;
                matrix[x][y] = 1;
            }
            return matrix;
        }

        private boolean checkRow(int row, int[][] matrix) {
            for (int item : matrix[row]) {
                if (item == 1) {
                    return false;
                }
            }
            return true;
        }

        private boolean checkColumn(int column, int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                if (i != column && matrix[i][column] != 1) {
                    return false;
                }
            }
            return true;
        }
    }

    class Solution2 {
        //参考评论里的方法，直接计算所有节点的出度，出度为0,入度为N-1的即为法官
        public int findJudge(int N, int[][] trust) {
            int[] outDegree = outDegree(N, trust);
            int[] inDegree = inDegree(N, trust);
            for (int i = 0; i < outDegree.length; i++) {
                if(outDegree[i] == 0 && inDegree[i] == N-1){
                    return i + 1;
                }
            }
            return -1;
        }

        private int[] outDegree(int N, int[][] trust){
            int[] outDegree =new int[N];
            for (int i = 0; i < trust.length; i++) {
                int x = trust[i][0]-1;
                outDegree[x] = outDegree[x] + 1;
            }
            return outDegree;
        }

        private int[] inDegree(int N, int[][] trust){
            int[] inDegree =new int[N];
            for (int i = 0; i < trust.length; i++) {
                int x = trust[i][1]-1;
                inDegree[x] = inDegree[x] + 1;
            }
            return inDegree;
        }


    }

}
