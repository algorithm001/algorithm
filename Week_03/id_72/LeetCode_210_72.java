class Solution {
    private class CourseVertex {
        int val;
        int inDegree;
        List<CourseVertex> adjacent;

        private CourseVertex(int val) {
            this.val = val;
            this.inDegree = 0;
            this.adjacent = new LinkedList<>();
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        if (numCourses == 0 || prerequisites == null) {
            return result;
        }
        CourseVertex[] vertices = new CourseVertex[numCourses];
        for (int i = 0; i < numCourses; i++) {
            vertices[i] = new CourseVertex(i);
        }
        for (int[] depend : prerequisites) {
            int x = depend[0];
            int y = depend[1];
            vertices[y].adjacent.add(vertices[x]);
            vertices[x].inDegree++;
        }

        int count = 0;
        Queue<CourseVertex> queue = new LinkedList<>();
        for (CourseVertex vertex : vertices) {
            if (vertex.inDegree == 0) {
                queue.offer(vertex);
            }
        }
        while (!queue.isEmpty()) {
            CourseVertex vertex = queue.poll();
            result[count] = vertex.val;
            count++;
            for (CourseVertex adj : vertex.adjacent) {
                if (--adj.inDegree == 0) {
                    queue.offer(adj);
                }
            }
        }
        if (count != numCourses) {
            return new int[0];
        }
        return result;
    }
}