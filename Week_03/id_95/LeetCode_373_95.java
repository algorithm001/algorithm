public class LeetCode_373_95 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new LinkedList<>();
        Queue<int[]> queue = new PriorityQueue<>(k,new Comparator<int[]>(){
            public int compare(int[] o1,int[] o2){
                int tmp1 = o1[0]+o1[1];
                int tmp2 = o2[0]+o2[1];

                return tmp1 - tmp2;
            }            
        });

       for(int i = 0;i<nums1.length;i++){
           for(int j = 0;j<nums2.length;j++){
               queue.add(new int[]{nums1[i],nums2[j]});
           }
       }

       while(k-->0){
           int[] tmp = queue.poll();
           if(tmp == null)
                break;
            res.add(tmp);
       }

       return res;
    }
}