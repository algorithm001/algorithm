package com.v0ex.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author bugcoder
 */
public class LeetCode_997_49 {

    public int findJudge(int N, int[][] trust) {
        if(0 == trust.length && 1==N){
            return 1;
        }
        Map<Integer,Set<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int[] item : trust){
            int left = item[0];
            int right =item[1];
            if(left == 0 || right == 0){
                return -1;
            }
            Set<Integer> rights = map.getOrDefault(right,new HashSet<Integer>());
            rights.add(left);
            map.put(right,rights);
            set.add(left);
        }
        for(int key : map.keySet()){
            if(map.get(key).size() == (N-1)){
                if(set.contains(key)){
                    return -1;
                }else{
                    return key;
                }

            }
        }
        return -1;
    }

    /**
     * 把所有的信任关系看做图，所有的信任对trust[]看做有向边。
     * 某个点的入度-出度=N-1，这个点所在的人就是镇法官
     * @param N
     * @param trust
     * @return
     */
    public int findJudgeOther(int N, int[][] trust){
        int[] count = new int[N+1];
        for(int[] t : trust){
            count[t[0]]--;
            count[t[1]]++;
        }
        for(int i = 1;i<=N;++i){
            if(count[i] == N -1){
                return i;
            }
        }
        return -1;
    }
}
