

    // LeetCode 210

    // [ 2. Kahn 算法. 入度减1在独立的数组上操作 ]
    public int[] findOrder(int numCourses, int[][] prerequisites){
        // 邻接表--图。 第一个元素是顶点本身
        LinkedList<Integer>[] graph = createGraphLink(numCourses, prerequisites);
        // 统计顶点的入度
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int j = 1; j < graph[i].size(); j++) {
                // 链表上包含一次该顶点，就有一个入度
                int w = graph[i].get(j);
                // 索引即顶点
                inDegree[w] ++;
            }
        }

        // 入度为0的顶点入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0){
                queue.add(i);
            }
        }
        // 栈，按顺序保存遍历过的顶点(不重复)
        Stack<Integer> stack = new Stack<>();
        // 去除入度为0的点
        while (!queue.isEmpty()){
            int m = queue.poll();
            stack.push(m);
            // 与该点有关的入度 - 1
            for (int i = 1; i < graph[m].size(); i++) {
                int n = graph[m].get(i);
                inDegree[n] --;
                if (inDegree[n] == 0){
                    queue.add(n);
                }
            }
        }

        if (stack.size() == numCourses){
            int[] rst = new int[stack.size()];
            for (int i = 0; !stack.isEmpty(); i++) {
                rst[i] = stack.pop();
            }
            return rst;
        }

        return new int[0];
    }

    // [ 1. 逆邻接表. 入度减1在逆邻接表上操作 ]
    public int[] findOrder(int numCourses, int[][] prerequisites){
        // 逆邻接表--图
        LinkedList<Integer>[] graph = createInverseGraphLink(numCourses, prerequisites);
        // 栈，按顺序保存遍历过的顶点
        Stack<Integer> stack = new Stack<>();
        // 散列表，记录点是否被访问过
        HashMap<Integer, Integer> map = new HashMap<>();

        // 遍历总次数=顶点数，每次选出入度为0的点
        for (int i = 0; i < numCourses; i++) {
            // 选出入度为0的点
            for (LinkedList<Integer> g : graph){
                // 入度为0的顶点
                if (g.size() == 1){
                    int n = g.get(0);
                    stack.push(n);
                    map.put(n, 1);
                    // 包含该点的顶点入度都减1
                    for (LinkedList<Integer> h : graph){
                        for (int j = 0; j < h.size(); j++) {
                            if (h.get(j) == n){
                                h.remove(j);
                            }
                        }
                    }
                }
            }
        }
        if (stack.size() == numCourses){
            int[] rst = new int[stack.size()];
            for (int i = 0; !stack.isEmpty(); i++) {
                rst[i] = stack.pop();
            }
            return rst;
        }

        return new int[0];
    }


    // 创建图 逆邻接表存储
    public LinkedList<Integer>[] createInverseGraphLink(int num, int[][] src){
        LinkedList<Integer>[] graph = new LinkedList[num];

        for (int j = 0; j < num; j++){
            graph[j] = new LinkedList<>();
            graph[j].add(j);
        }

        int len = src.length;
        for (int i = 0; i < len; i++) {
            // [0,1] 1索引
            // 逆邻接表，索引是前序课程
            int p = src[i][1];
            int q = src[i][0];
            graph[p].add(q);
        }

        return graph;
    }




