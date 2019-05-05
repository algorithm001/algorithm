package leetcode.Algorithms._901_1000._997_FindTheTownJudge;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by jialei.zou on 2019/5/4 .
 * ref:
 * https://leetcode.com/problems/find-the-town-judge/
 *
 */
public class FindTheTownJudge {


    public int findJudge(int N, int[][] trust) {

        if(trust == null || trust.length == 0){
            if(N == 1){
                return 1;
            }else {
                return -1;
            }
        }
        //初始化
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=1; i<=N; i++){
            map.put(i, 0);
        }
        //把相信别人的先排除掉
        for (int i = 0; i<trust.length; i++){
            map.remove(trust[i][0]);
        }
        if(map.size()==0){
            return -1;
        }
        //剩下的被相信的人统计被相信数量
        for (int i = 0; i<trust.length; i++){
            if(map.containsKey(trust[i][1])){
                map.put(trust[i][1], map.get(trust[i][1])+1);
            }
        }
        //只能有一个人被所有人相信
        Iterator iterator = map.entrySet().iterator();
        boolean exist = false;
        int result=-1;
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            Integer val = (Integer) entry.getValue();
            if(val==N-1){
                if(!exist){
                    exist = true;
                    result = (Integer)entry.getKey();
                }else {
                    return -1;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        FindTheTownJudge findTheTownJudge = new FindTheTownJudge();


        System.out.println(findTheTownJudge.findJudge(2, new int[][]{{1,2}}));
        System.out.println(findTheTownJudge.findJudge(3, new int[][]{{1,3},{2,3}}));
        System.out.println(findTheTownJudge.findJudge(3, new int[][]{{1,3},{2,3},{3,1}}));
        System.out.println(findTheTownJudge.findJudge(3, new int[][]{{1,2},{2,3}}));
        System.out.println(findTheTownJudge.findJudge(4, new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}}));


    }



}
