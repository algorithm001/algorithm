package solution

/*
210. Course Schedule II

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

*/

// 思路1： 暴力破解法， 使用map+链表创建逆邻接矩阵，然后使用for循环枚举，时间复杂度较高

// 思路2：寻找是否存在环，该题假设数字的课必须依赖数字小的课
func findOrder(numCourses int, prerequisites [][]int) []int {

	queue := make([]int, 0, numCourses)
	inDegree := make([]int, numCourses, numCourses)
	graph := make(map[int][]int)

	for _, edge := range prerequisites {
		from, to := edge[1], edge[0]
		inDegree[to]++
		graph[from] = append(graph[from], to)
	}

	// 寻找最小的没有依赖的节点
	for i, n := range inDegree {
		if n == 0 {
			queue = append(queue, i)
		}
	}

	for i := 0; i < numCourses; i++ {
		// no course with no prereq but not all courses are processed yet. must have a cycle in the graph.
		if i >= len(queue) {
			return []int{}
		}
		course := queue[i]
		nextCourses := graph[course]
		for _, next := range nextCourses {
			inDegree[next]--
			// this course has no prereq now, add to queue
			if inDegree[next] == 0 {
				queue = append(queue, next)
			}
		}
	}

	return queue
}
