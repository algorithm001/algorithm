class Solution {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
        
		LinkedList<Integer>[] neiList = new LinkedList[numCourses];
		for(int i=0;i<numCourses;i++)
			neiList[i] = new LinkedList<>();
		//source[i] 记录节点i有几个邻居指向节点i
		int[] source = new int[numCourses];
		for(int[] pair:prerequisites) {
			neiList[pair[1]].add(pair[0]);
			source[pair[0]]++;
		}
		//unreachable记录不可达的节点
		int[] unreachable = new int[numCourses];
		int cur = 0;
		for(int i=0;i<numCourses;i++)
			if(source[i]==0)
				unreachable[cur++] = i;
		int end = cur;
		cur = 0;
		for(;cur<end;cur++) {
			for(int neb:neiList[unreachable[cur]]) {
				source[neb] -= 1;
				if(source[neb]==0)
					unreachable[end++] = neb;
			}
		}
		return end==numCourses?unreachable:new int[0];
	}
}