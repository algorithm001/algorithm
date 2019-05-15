class Solution {
    // 默认初始值
    private static final Integer VALUED_EFAULT = Integer.valueOf(-1);
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> stack = new Stack<Integer>();
        //利用哨兵来去除判空
        stack.push(Integer.MAX_VALUE);
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] arr = new int[nums1.length];
        for(Integer node:nums2){
            while( node > stack.peek()){
                map.put(stack.pop(),node);
            }
             stack.push(node);     
        }

        for(int i = 0;i < nums1.length;i++){
            //获取为空时添加默认值
            arr[i] = map.getOrDefault(nums1[i],VALUED_EFAULT);
        }
        return arr;
        
    }
}