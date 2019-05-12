// https://leetcode-cn.com/problems/minimize-malware-spread-ii/
// 928.尽量减少恶意软件的传播2。
// 和 924 不太一样。

// 暴力解法：

// 1. 统计病毒顶点，能够感染的顶点列表，注意遇到其他病毒顶点，则略过，不再走这一支。
//     【病毒组】
//      - k，顶点编号
//      - v，当前顶点是否为原始病毒顶点
//     【感染哈希表】：
//      - k，病毒顶点编号
//      - v，当前病毒顶点能够感染的顶点列表（包括他自己和其他非病毒顶点）

// 2. 统计顶点，被感染的途径有几个（也就是它能被几个病毒顶点感染）
//     【被感染途径】
//      - k，顶点编号
//      - v，当前顶点被感染途径有几个

// 3. 计算每一个病毒顶点，其感染顶点中，仅能够被它感染的顶点个数。
//     【病毒单一感染组】
//      - k，病毒顶点编号（实际上是顶点编号，只不过只有病毒顶点才有意义）
//      - v，当前病毒顶点能够感染的、且仅能被当前病毒顶点感染的顶点个数

// 4. 选出3中病毒顶点编号最小，而仅能被它感染顶点个数最多的病毒顶点，输出编号。

// 去掉输出日志，AC了，不然会超时。。。

class Solution {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        
        // 1. 顶点数
        int N = graph.length;
        
        // 2. 病毒组
        int[] virus = new int[N];
        initVirus(virus,initial);
        // System.out.println("----病毒组：");
        // print(virus);
        
        // 3. 感染哈希表
        Map<Integer,List<Integer>> inffectMap = new HashMap();
        for(int i=0;i<initial.length;i++){
            List<Integer> list = getInffect(graph,virus,initial[i]);
            inffectMap.put(initial[i],list);
        }
        // System.out.println("----感染哈希表：");
        // print(inffectMap);

        
        // 4. 被感染途径
        int[] passive_infect = new int[N];   
        updatePassiveInfect(inffectMap,passive_infect);
        // System.out.println("----被感染途径：");
        // print(passive_infect);
        
        
        // 5. 病毒单一感染组
        int[] filter_effect = new int[N];
        for(Integer key:inffectMap.keySet()){
            int count=0;
            List<Integer> value = inffectMap.get(key);
            for(Integer v:value){
                if(passive_infect[v]==1){
                    count++;
                }
            }
            filter_effect[key]=count;
        }
        // System.out.println("----病毒单一感染组：");
        // print(filter_effect);
                
        // 6. 选出，filter_effect 影响范围更大，initial 节点索引更小的。
        int resultVertex = initial[0];
        int resultEffect = filter_effect[resultVertex];
        for(int i=1;i<initial.length;i++){
            int vertex = initial[i];
            int effect = filter_effect[vertex];
            if(effect>resultEffect){
                resultEffect = effect;
                resultVertex=vertex;
            }else if(effect==resultEffect && vertex<resultVertex){
                resultVertex = vertex;
            }
        }
        
        return resultVertex;
    }
    
    
    // 计算去掉 init，整张图中受影响的节点数。
    List<Integer> getInffect(int[][] graph, int[] virus,int init){
        List<Integer> list = new ArrayList();
        
        int[] visited = new int[graph.length];
        
        Queue<Integer> queue = new LinkedList();
        queue.offer(init);
        visited[init]=1;
        
        while(queue.size()!=0){
            int vertex = queue.poll();
            visited[vertex]=1;
            list.add(vertex);
            // count++;
            // 找一行或者一列就行了，都一样的。
            // 若：非对角线位置、非初始节点，则入队列，否则直接忽略。
            // 如果 i 没被访问，且不是
            for(int i=0;i<graph.length;i++){
                if(vertex!=i && graph[vertex][i]==1 && visited[i]==0 && virus[i]==0){
                    queue.offer(i);
                }
            }            
        }
        
        return list;
    }
    
    
    
    // 初始化病毒组
    void initVirus(int[] virus,int[] initial){
        for(int i=0;i<initial.length;i++){
            virus[initial[i]]=1;
        }
    }
    
    
    // 更新被感染数组
    void updatePassiveInfect(Map<Integer,List<Integer>> effectMap,int[] passive_infect){
        for(Integer vertex:effectMap.keySet()){
            List<Integer> effectList = effectMap.get(vertex);
            for(Integer v:effectList){
               passive_infect[v]++;
            }
        }
    }
   
    
    
    // --------------------------
    
    void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    void print(Map<Integer,List<Integer>> map){
        for (Integer key : map.keySet()) { 
            List<Integer> value = map.get(key);
            System.out.println("key:"+key+" value:"+value.toString());
        } 
    }
}
