class Solution {
    public int findJudge(int N, int[][] trust) {
        if(N==1 && trust.length==0){
            return N;
        }
        //二维数组 人（被信任次数，信任别人次数）
        int[][] peopleAry=new int[N+1][2];
        
        //1. 遍历信任关系
        for(int[] t:trust){
            //2. 设计数据结构 存储每个人的信任与被信任关系 
        
            //信任别人的人
            int trustOther = t[0];
                //2.2 信任别人次数 ++
            peopleAry[trustOther][1]++;
            
            //被信任的人
            int receiveTrust=t[1];
             //2.1 被信任次数 ++ 
            peopleAry[receiveTrust][0]++;
              
        }
        List<Integer> result=new ArrayList();
   
        //3.遍历每个人的信任情况
        for(int i=0;i<=N;i++){
            int[] person=peopleAry[i];
            if(person[0]==N-1 && person[1]==0){
                result.add(i);
            }
        }
           
        //4.判断数组长度 是不是为1 为1，则输出数组记录的人 
        if(result.size()==1){
            return result.get(0);
        }
        return -1;
            
            
    }
}