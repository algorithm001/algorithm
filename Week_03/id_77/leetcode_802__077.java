class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list = new ArrayList<>(1000);
        int[] inCircle = new int[graph.length];
        for(int i=0;i<graph.length;i++){ 
            if(!dfs(graph,i,inCircle)){
                list.add(i);
            }
        }
        
        return list;
        
    }
    
    public boolean dfs(int[][] graph,int n,int[] inCircle){
        if(inCircle[n] == 1){
            //重复节点
            return true;
        }else if(inCircle[n] == -1){
            //找到重复节点
            inCircle[n] = 1;
            return true;
        }else if(inCircle[n] == -2){
            //安全节点
            return false;
        }else{
            //走过标记
          inCircle[n] = -1; 
        }
        
        if(graph[n].length == 0){
            inCircle[n] = -2;
        }else{
            for(int i=0;i<graph[n].length;i++){
                if(dfs(graph,graph[n][i],inCircle)){   
                    return true;
                }else{
                    //恢复现场
                  inCircle[n] = 0;  
                }
            } 
             inCircle[n] = -2;        
        }

        return false;
    }
}