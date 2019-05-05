class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new LinkedList<>();
        if (graph == null || graph.length == 0) {
            return result;
        }
        boolean[] isSafeNode = new boolean[graph.length];
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (isSafeNode(graph, isSafeNode, i, visited)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isSafeNode(int[][] graph, boolean[] isSafeNode, int node, boolean[] visited) {
        if (isSafeNode[node]) {
            return true;
        }
        if (visited[node]) {
            return false;
        }
        visited[node] = true;
        int[] adjacent = graph[node];
        if (adjacent == null || adjacent.length == 0) {
            isSafeNode[node] = true;
            return true;
        }
        boolean isSafe = true;
        for (int adj : adjacent) {
            if (!isSafeNode(graph, isSafeNode, adj, visited)) {
                isSafe = false;
                break;
            }
        }
        if (isSafe) {
            isSafeNode[node] = true;
        }
        return isSafe;
    }
}