class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        TreeMap<Integer, List<Integer[]>> tm = new TreeMap<>();
        for(int i=0;i<nums1.length;i++) {
            for(int j=0;j<nums2.length;j++) {
                Integer key = nums1[i] + nums2[j];
                List<Integer[]> list = tm.get(key);
                if(list == null) {
                    list = new ArrayList();
                    tm.put(key, list);
                }
                list.add(new Integer[]{nums1[i], nums2[j]});
            }
        }

        List<int[]> list = new ArrayList();
        Iterator<Map.Entry<Integer, List<Integer[]>>> it = tm.entrySet().iterator();

        int c = 0;
        while(it.hasNext()) {
            if (c == k) break;
            Map.Entry<Integer, List<Integer[]>> entry = it.next();
            List<Integer[]> coords = entry.getValue();
            Iterator<Integer[]> it2 = coords.iterator();
            while(it2.hasNext()) {
                Integer[] coord = it2.next();
                list.add(new int[]{coord[0], coord[1]});
                ++c;
                if (c == k) break;
            }
        }

        return list;
    }
}
