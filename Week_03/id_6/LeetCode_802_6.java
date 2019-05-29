

    // LeetCode 802

    // [ 1. DFS ]  超时
    
    // 任意一点到终点，无环的节点
    // 深度遍历，有环路径的点删除，最后剩余的是解
    public List<Integer> eventualSafeNodes1(int[][] graph) {
        // 统计出度
        int len = graph.length;
        HashMap<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            map.put(i, 1);
        }

        // 检测任意一点到终点，有环的路径，从哈希表删除路径上的点
        for (int i = 0; i < len; i++) {
            HashMap<Integer, Integer> visited = new HashMap<>();
            Stack<Integer> path = new Stack<>();
            visited.put(i, 1);
            path.push(i);
            dfs(i, graph, visited, map, path);
        }

        List<Integer> rst = new ArrayList<>(map.size());
        for (int key : map.keySet()){
            rst.add(key);
        }

        return rst;
    }


    public void dfs(Integer node, int[][] graph, HashMap<Integer,Integer> visited, HashMap<Integer, Integer> map, Stack<Integer> path){
        if (graph[node] == null){
            visited.remove(path.pop());
            return;
        }

        for (int i : graph[node]){
            // 环
            if (visited.containsKey(i)){
                for (int key : visited.keySet()){
                    map.remove(key);
                }
                return;
            }else {
                visited.put(i, 1);
                path.push(i);
            }
            dfs(i, graph, visited, map, path);
        }
        visited.remove(path.pop());
    }

    