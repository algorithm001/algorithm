class Solution {
    public int findJudge(int N, int[][] trust) {
        //思路是法官不相信任何人且相信他的人数为N-1，同时这样的人只能有一个
        //创建两个数据，一个用来保存相信别人的数量，另一个用来保存被相信人的数量
        int[] trustNum = new int[N+1];
        int[] beTrustNum = new int[N+1];
        
        for(int i=0; i< trust.length; i++){
            trustNum[ trust[i][0] ] ++;
            beTrustNum[ trust[i][1] ] ++;
        }
        
        //如果这个人不相信别人那么对应的trustNum应该为0，同时对应的beTrustNum为N-1说明还是唯一的说明这个人就是法官
        //创建两个参数，一个是记录满足条件的个数，另一个是记录这个人的值
        int tNum = 0 ; 
        int name = 0 ;
        for(int i=1; i<= N; i++){
            if(trustNum[i] == 0 && beTrustNum[i]== N-1){
                tNum ++ ;
                name = i;
            }
        }
        
        //trustNum=0 ， beTrustNum=N-1 如果还唯一说明为法官
        if(tNum != 1 ){
            return -1;
        }else{
            return name;
        }
        
    }
}
