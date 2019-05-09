class Solution {
    public int findJudge(int N, int[][] trust) {

        if(N == 1){
            return N;
        }
        HashMap<Integer ,Integer> hashMap = new HashMap(trust.length);
        int[] ints = new int[trust.length];

        for(int i=0;i<trust.length;i++){
            ints[i] = trust[i][0];
            hashMap.put(trust[i][1],hashMap.getOrDefault(trust[i][1],0)+1);
        }

        for(Integer key :hashMap.keySet()){
            if(hashMap.get(key) ==N-1 ){
                for(Integer s:ints){
                    if(s.equals(key)){
                        return -1;
                    }
                }
                return key;
            }
        }
        return -1;
    }
}