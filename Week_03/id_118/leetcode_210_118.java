// https://leetcode-cn.com/problems/course-schedule-ii/
// 210.课程表2
// 本题可以理解为输出一个拓扑排序。
// 注意：
// - 题目中给出的边 [1,0] 表示的是，学习1之前要先学0，这个和 207 题目中的含义正好相反。
// - 所以，要么处理出度为0的边，要么把边的方向转一下。我选择后者，在 207 的基础上，把 from 和 to 互换一下就好了。
// - 注意，如果有环，要输出空数组。

class Solution {
    public int[] findOrder(int N, int[][] prerequisites) {
                   
        // 1. 取边数
        int M = prerequisites.length;

        // 2. 计算每个顶点的入度、出度。边，from->to：from出度+1，to入度+1
        int[] in_degree = new int[N];
        int[] out_degree = new int[N];
        for(int i=0;i<M;i++){
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];
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
        int[] result = new int[N];
        while(queue.size()!=0){
            
            int vertex = queue.poll();
            result[count++]=vertex;

            for(int i=0;i<M;i++){
                int to = prerequisites[i][0];
                int from = prerequisites[i][1];
                if(from==vertex){
                    out_degree[from]-=1;
                    in_degree[to]-=1;
                    if(in_degree[to]==0){
                        queue.offer(to);
                    }
                }
            }
        }
        
        // 5.队列中取出的元素个数与顶点数相等，则说明无环，输出result数组。
        if(count==N){
            return result;
        }
        
        // 否则有环，返回空数组
        return new int[0];
    }
}
