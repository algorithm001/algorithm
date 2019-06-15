package com.algorithm;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/06/15
 */
public class LeetCode_51_108 {

    //8皇后
    @Test
    public void test() {
        int num = 8;
        int[][] queens = new int[num][num];
        List<List<String>> result = new LinkedList<>();
        queens(queens, 0, num,result);
        System.out.println(result);
    }

    private List<String> postQueens(int[][] queens){
        List<String> values = new LinkedList<>();
        for (int i = 0; i < queens.length; i++) {
            String row = "";
            for (int j = 0; j < queens[0].length; j++) {
                row = row.concat(parse(queens[i][j]));
            }
            values.add(row);
        }
        return values;
    }

    private String parse(int value){
        return value == 0 ? "." : "Q";
    }

    private void queens(int[][] queens, int i, int num,List<List<String>> result) {
        if (i == num) {
            List<String> value = postQueens(queens);
            printQueens(value);
            result.add(postQueens(queens));
            return;
        }

        for (int j = 0; j < queens[0].length; j++) {
            if (check(queens, i, j)) {
                queens[i][j] = j + 1;
                queens(queens, i + 1, num,result);
            }
            queens[i][j] = 0;
        }
    }

    private void printQueens(List<String> queens) {
        for (int i = 0; i < queens.size(); i++) {
            System.out.println(queens.get(i));
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private boolean check(int[][] queens, int i, int j) {
        int length = queens[0].length;
        int width = queens.length;

        int i_copy = i - 1;
        int j_copy = j - 1;
        //检查左上
        while (i_copy >= 0 && j_copy >= 0) {
            if (queens[i_copy][j_copy] != 0) {
                return false;
            }
            i_copy--;
            j_copy--;
        }
        //检查右上
        i_copy = i - 1;
        j_copy = j + 1;
        while (i_copy >= 0 && j_copy <= length - 1) {
            if (queens[i_copy][j_copy] != 0) {
                return false;
            }
            i_copy--;
            j_copy++;
        }
        //检查上
        i_copy = i - 1;
        j_copy = j;
        while (i_copy >= 0) {
            if (queens[i_copy][j_copy] != 0) {
                return false;
            }
            i_copy--;
        }

        return true;
    }

}
