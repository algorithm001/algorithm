package solution

/*
802. Find Eventual Safe States

In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.

Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.

Which nodes are eventually safe?  Return them as an array in sorted order.

The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.

Example:
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Here is a diagram of the above graph.

Illustration of graph

Note:

graph will have length at most 10000.
The number of edges in the graph will not exceed 32000.
Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].
*/

/*
class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<int> res, color(n); // 0 white, 1 gray, 2 black
        for (int i = 0; i < n; ++i) {
            if (helper(graph, i, color)) res.push_back(i);
        }
        return res;
    }
    bool helper(vector<vector<int>>& graph, int cur, vector<int>& color) {
        if (color[cur] > 0) return color[cur] == 2;
        color[cur] = 1;
        for (int i : graph[cur]) {
            if (color[i] == 2) continue;
            if (color[i] == 1 || !helper(graph, i, color)) {
                return false;
            }
        }
        color[cur] = 2;
        return true;
    }
};
*/

// 方法一
// 标记法 使用white(0), gray(1), black三色分别标记未访问，已访问为定性，已访问已定性
// 寻找没有在环上的节点，顺序打印
func eventualSafeNodes(graph [][]int) []int {
	x := len(graph)
	results := make([]int, 0)
	colors := make([]int, x) // 标记元素，0表示未访问，1表示已访问不确定，2表示已访问确定
	for i := 0; i < x; i++ {
		if helper(graph, i, &colors) {
			results = append(results, i)
		}
	}
	return results
}

func helper(graph [][]int, cur int, color *[]int) bool {
	if (*color)[cur] > 0 {
		return (*color)[cur] == 2
	}
	(*color)[cur] = 1
	item := graph[cur]
	for i := 0; i < len(item); i++ {
		if (*color)[item[i]] == 2 {
			continue
		}
		if (*color)[item[i]] == 1 || !helper(graph, item[i], color) {
			return false
		}
	}
	(*color)[cur] = 2
	return true
}

// 方法二
// 寻找不在环内的元素
func eventualSafeNodes2(graph [][]int) []int {
	ans := []int{}                // 返回结果
	endings := make(map[int]bool) // 不在环内
	cycles := make(map[int]bool)  // 在环内
	gLen := len(graph)
	for i := 0; i < gLen; i++ {
		if endings[i] {
			ans = append(ans, i)
		}
		if cycles[i] {
			continue
		}
		// 使用path作中临时映射
		path := make(map[int]bool)
		isCycle := isCyclePresent(graph, path, cycles, endings, i)
		if !isCycle {
			ans = append(ans, i)
		}
	}
	return ans
}

func isCyclePresent(graph [][]int, path, cycles, endings map[int]bool, idx int) bool {
	if cycles[idx] || path[idx] {
		return true
	}
	if endings[idx] {
		return false
	}
	// 认为path中存储的都是环内元素
	path[idx] = true
	for _, item := range graph[idx] {
		// 关键代码，如果为false，则不会执行下面if逻辑
		if isCyclePresent(graph, path, cycles, endings, item) {
			cycles[idx] = true
			return true
		}
	}
	endings[idx] = false
	delete(path, idx)
	return false
}
