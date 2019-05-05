// https://leetcode-cn.com/problems/course-schedule/
// 207.课程表

// 本题可以理解为：判断有向图是否有环，若有环，则不能完成所有课程学习。也可以看成一个拓扑排序问题。

class Solution {
    public boolean canFinish(int N, int[][] prerequisites) {
        
        // 1. 取边数
        int M = prerequisites.length;

        // 2. 计算每个顶点的入度、出度。边，from->to：from出度+1，to入度+1
        int[] in_degree = new int[N];
        int[] out_degree = new int[N];
        for(int i=0;i<M;i++){
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            out_degree[from]+=1;
            in_degree[to]+=1;
        }
        
        // 3. 入度为0的点入拓扑队列。
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<N;i++){
            if(in_degree[i]==0){
                queue.offer(i);
            }
        }
        
        // 4. 队列非空时，做下面的动作：
        //    - 取出一个入度为0的顶点v
        //    - 删除v指向的边，并更新边上顶点的入度出度
        //    - 若这个过程中某个点的入度变为0，则将其入队列
        //    边，from->to：from出度-1，to入度-1
        int count = 0;
        while(queue.size()!=0){
            
            int vertex = queue.poll();
            count++;

            for(int i=0;i<M;i++){
                int from = prerequisites[i][0];
                int to = prerequisites[i][1];
                if(from==vertex){
                    out_degree[from]-=1;
                    in_degree[to]-=1;
                    if(in_degree[to]==0){
                        queue.offer(to);
                    }
                }
            }
        }
        
        // 5.队列中取出的元素个数与顶点数相等，则说明无环。
        if(count==N){
            return true;
        }
        
        return false;
    }
}
