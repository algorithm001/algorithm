// https://leetcode-cn.com/problems/minimize-malware-spread/
// 924.尽量减少恶意软件的传播

// 无向图的连通性问题。
// graph是一个n*n数组（这例子举的真是糟糕，我开始还以为是有向带权图呢...）
// 先用Union-Find分组，再找含有病毒顶点的组内元素最多的组中索引最小的病毒顶点。

class Solution {
    public int minMalwareSpread(int[][] graph, int[] initial) {

        // 1. 取顶点个数
        int N = graph.length;
        
        // 2. 划分连通组。uf：下标=顶点编号；值=所属连通组编号。
        int[] uf = new int[N];
        initUF(uf);
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(graph[i][j]==1){
                    union(uf,i,j);
                }
            }
        }
        
        // 3. 计算每个连通组组内元素个数，默认是0。sz：下标=连通组编号；值=连通组内元素个数。
        int[] sz = new int[N];
        for(int i=0;i<N;i++){
            sz[uf[i]]++;
        }

        // 4. 最后遍历 initial，找出含有 initial 节点且组内顶点个数最多的，输出initial中最小的。
        int M = initial.length;
        if(M<=0){
            return -1;
        }
        
        int minVertex = initial[0];
        int maxGroupSize = sz[uf[minVertex]];
        
        for(int i=1;i<M;i++){
            int vertex = initial[i];
            int groupSize = sz[uf[vertex]];
            if(groupSize > maxGroupSize){
                minVertex = vertex;
                maxGroupSize = groupSize;
            }else if(groupSize == maxGroupSize && vertex<minVertex){
                minVertex = vertex;
            }
        }
        
        return minVertex;
    }
    
    
    // 初始化连通组数组
    void initUF(int[] group){
        for(int i=0;i<group.length;i++){
            group[i]=i;
        }
    }
    
    
    // U：把一条边上两个顶点的组改成一个。
    void union(int[] uf,int from,int to){
        // 设 uf[from]=x，uf[to]=y
        // 若 x==y，则什么都不需要做。
        // 若 x!=y 不同，则把 uf 中，所有值为y的组，改成x。
        int x=uf[from];
        int y=uf[to];
        if(x==y){
            return;
        }
        for(int i=0;i<uf.length;i++){
            if(uf[i]==y){
                uf[i]=x;
            }
        }
    }
    
    
    // ---------不要管我-----------
    
    void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }
    
}
