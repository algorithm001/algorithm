class Solution {
    public int findJudge(int N, int[][] trust) {
        if(N == 1) return 1;
        Map<Integer, Integer> map = new HashMap();
        for(int[] aaa: trust){
            if(map.get(aaa[1]) == null){
                map.put(aaa[1], 0);
            }
            int num = map.get(aaa[1]);
            map.put(aaa[1], num+1);
        }
        
        for(int[] aaa: trust){
            if(map.get(aaa[0]) != null){
                map.remove(aaa[0]);
            }
        }
        
        for(int key : map.keySet()){
            if(map.get(key) == N-1){
                return key;
            }
        }
        
        return -1;
    }
}
