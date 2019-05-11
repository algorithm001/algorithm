

    // LeetCode 310

    // [2. 广度优先遍历  ]
    // 叶子节点做root，必然不会是最小高度树
    // 一次一次的删除叶子节点，直到最后剩余1或2个点
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> rst = new ArrayList<>();
        if (n == 0) {
            return rst;
        }
        if (n == 1) {
            rst.add(0);
            return rst;
        }
        if (n == 2) {
            rst.add(0);
            rst.add(1);
            return rst;
        }

        // 邻接矩阵表示的无向图
        LinkedList<Integer>[] graph = createGraphLink(n, edges);

        List<Integer> currList = new ArrayList<>();
        // 记录删除叶子节点后剩余的节点，map.size<=2作为循环结束条件
        HashMap<Integer,Integer> map = new HashMap<>();
        // 顶点度值表. 索引作为顶点
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            inDegree[i] = graph[i].size();
            map.put(i, 1);
            // 度为1的点入队
            if (inDegree[i] == 1){
                currList.add(i);
            }
        }

        // 删除叶子节点
        while (currList.size() > 0) {
            List<Integer> nextList = new ArrayList<>();
            for (Integer nd : currList){
                map.remove(nd);
                for (int j : graph[nd]){
                    inDegree[j] --;
                    if (inDegree[j] == 1){
                        nextList.add(j);

                    }
                }

            }
            if (map.size() <= 2){
                break;
            }
            currList = nextList;
        }

        for (int k : map.keySet()){
            rst.add(k);
        }
        return rst;
    }


    // [1. 广度优先遍历  BFS ]  超时
    // 题目要求的是，整棵树有最小高度，然后返回根节点
    // 相当于求树的最大高度，然后选最小的情况时的root
    // 让每一个顶点做root，求出最大高度
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> rst = new ArrayList<>();
        if (n == 0) {
            return rst;
        }
        if (n == 1) {
            rst.add(0);
            return rst;
        }

        // 邻接矩阵表示的无向图
        LinkedList<Integer>[] graph = createGraphLink(n, edges);

        int[] hashMap = new int[n];
        // 已找到的最小深度
        int minDeep = 0;
        // 每个顶点i做为root广度遍历，找出最大深度
        for (int i = 0; i < n; i++) {
            // 记录已经访问的点
            HashMap<Integer, Integer> map = new HashMap<>();
            int deep = 0;

            List<Integer> currLayer = new ArrayList<>();
            currLayer.add(i);
            map.put(i, 1);

            while (currLayer.size() > 0){
                List<Integer> nextLayer = new ArrayList<>();
                for (int curr : currLayer){
                    // 当前点的link
                    List<Integer> tmp = new ArrayList<>(graph[curr].size());
                    for (int nd : graph[curr]){
                        if (!map.containsKey(nd)){
                            map.put(nd, 1);
                            tmp.add(nd);
                            nextLayer.add(nd);
                        }
                    }
                }
                currLayer = nextLayer;
                deep ++;
                // 优化：如果已经大于当前的最小高度，不再遍历
                if (deep > minDeep && minDeep != 0){
                    break;
                }
            }
            hashMap[i] = deep;
            if (minDeep == 0){
                minDeep = deep;
            }else {
                if (deep < minDeep){
                    minDeep = deep;
                }
            }
        }

        int len = hashMap.length;
        for (int i = 0; i < len; i ++){
            if (hashMap[i] == minDeep){
                rst.add(i);
            }
        }

        return rst;
    }


    // 创建图 邻接表存储
    public LinkedList<Integer>[] createGraphLink(int num, int[][] src){
        LinkedList<Integer>[] graph = new LinkedList[num];

        for (int i = 0; i < num; i++){
            graph[i] = new LinkedList<>();
            // graph[i].add(i);
        }

        int len = src.length;
        // 无向图
        for (int i = 0; i < len; i++) {
            // [0,1]
            int p = src[i][0];
            int q = src[i][1];
            graph[p].add(q);
            graph[q].add(p);
        }

        return graph;
    }

    
