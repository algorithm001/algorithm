

    // LeetCode 429

    // [2. 深度优先遍历  递归 ]
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null){
            return new ArrayList<>();
        }

        // 结果list
        List<List<Integer>> rstList = new ArrayList<>();
        rstList.add(new ArrayList<Integer>(1));
        rstList.get(0).add(root.val);

        if (root.children != null){
            dfs(root.children, 1, rstList);
        }

        return rstList;
    }

    // children不空就递归。 递归一次说明层数要加1
    public void dfs(List<Node> childList, int deep, List<List<Integer>> rst){
        // 结果list的元素数量 比 当前层数小
        if (rst.size() < deep+1) {
            rst.add(new ArrayList());
        }
        for (Node nd : childList){
            rst.get(deep).add(nd.val);
            if (nd.children != null){
                dfs(nd.children,deep+1, rst);
            }
        }
    }


    // [1. 广度优先遍历  BFS ]
    // currList 记录当前层的节点
    // childList 遍历当前层时，记录子节点
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null){
            return new ArrayList<>();
        }

        // 结果list
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>(1));
        list.get(0).add(root.val);

        List<Node> currList = new ArrayList<>();
        currList.add(root);

        while (currList.size() > 0){
            List<Node> childList = new ArrayList<>();
            list.add(new ArrayList<>());
            int i = list.size() - 1;

            // 遍历当前list，取每个节点的Chinaren
            for (Node nd : currList){
                if (nd.children != null){
                    for (Node cd : nd.children){
                        childList.add(cd);
                        list.get(i).add(cd.val);
                    }
                }
            }
            // 更新当前层节点
            currList = childList;
            if (childList.size() == 0){
                list.remove(i);
            }
        }

        return list;
    }