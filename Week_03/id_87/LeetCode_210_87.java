
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {


    /**
     * Medium
     * 210. Course Schedule II
     *
     * There are a total of n courses you have to take, labeled from 0 to n-1.
     *
     * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
     *
     * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
     *
     * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
     *
     * Example 1:
     *
     * Input: 2, [[1,0]]
     * Output: [0,1]
     * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
     *              course 0. So the correct course order is [0,1] .
     *
     * Example 2:
     * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
     * Output: [0,1,2,3] or [0,2,1,3]
     * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
     *              courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
     *              So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
     *
     * Note:
     * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
     * You may assume that there are no duplicate edges in the input prerequisites.
     *
     * https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/representing-graphs
     *
     * inspired by: https://leetcode.com/problems/course-schedule-ii/discuss/271433/Java-using-BFS-(Kahn's-algorithm)-with-detailed-explanation
     *
     * bfs method: https://time.geekbang.org/column/article/70891
     *
     * Detect Cycle in a Directed Graph using BFS
     * https://www.geeksforgeeks.org/detect-cycle-in-a-directed-graph-using-bfs/
     *
     * background knowledge:
     *  https://en.wikipedia.org/wiki/Topological_sorting
     *  https://en.wikipedia.org/wiki/Vertex_(graph_theory)
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] totalCourse = new int[numCourses];
        List<List<Integer>> graphList = new ArrayList<>();
        buildGraph(totalCourse, graphList, prerequisites);

        int[] path = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<totalCourse.length; i++){ // add all vertex with no incoming edge to q.
            if(totalCourse[i]==0){
                q.add(i);
            }
        }

        int index = 0;
        while(!q.isEmpty()){
            int vertex = q.poll();
            path[index++] = vertex; // we can take the course since it has no prereq.

            // we already take the course. Remove indegree for all the adj vertext.
            // It means we already took one prereq of the adjacent class.
            for(int i : graphList.get(vertex)){
                totalCourse[i]--;
                if(totalCourse[i]==0){
                    q.add(i); // we can take i now since all its prereq is taken.
                }
            }
        }

        return index == numCourses? path : new int[0];

    }

    private void buildGraph(int[] totalCourses, List<List<Integer>> graphList, int[][] prerequisites) {
        for (int i = 0; i < totalCourses.length; i++) {
            graphList.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            graphList.get(preCourse).add(course);
            totalCourses[course]++;
        }
    }

}