package com.imooc.activiti.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author shironghui on 2019/4/18.
 */


class Solution14 {
    /**
     * 让我们按一定规律排列，第一行放1个，第二行放2个，以此类推，
     * 问我们有多少行能放满。通过分析题目中的例子可以得知最后一行只有两种情况，放满和没放满。
     * 由于是按等差数列排放的，我们可以快速计算出前i行的硬币总数。
     * 我们先来看一种O(n)的方法，非常简单粗暴，就是从第一行开始，一行一行的从n中减去，
     * 如果此时剩余的硬币没法满足下一行需要的硬币数了，我们之间返回当前行数即可
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        for(int i=1;i<Integer.MAX_VALUE;i++){
            if(n>=0){
                n=n-i;
            }
            else {
                return i-2;
            }
        }
        return -1;
    }
}

public class TestArrangeCoins {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Solution14().arrangeCoins(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
