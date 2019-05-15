import java.util.Arrays;


/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
public class LeetCode_455_091 {

        public int findContentChildren(int[] g, int[] s) {
            int child = 0;
            int cookie = 0;
            Arrays.sort(g);
            Arrays.sort(s);
            while (child < g.length && cookie < s.length ){
                if (g[child] <= s[cookie]){
                    child++;
                }
                cookie++;
            }
            return child;
        }
}
