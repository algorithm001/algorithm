public class LeetCode_169_044 {
    public int majorityElement(int[] nums) {
        return divc(nums, 0, nums.length - 1); 
    }
    private int divc(int[] nums, int l, int r){
        if(l == r)
            return nums[l];
        int mid = l + (r - l)/2;
        int ls = divc(nums, l, mid);
        int rs = divc(nums, mid+1, r);
        if(ls == rs)
            return ls;
        int c1 = 0, c2 = 0;
        for(int i = l; i <= r; i++){
            if(nums[i] == ls) c1++;
            if(nums[i] == rs) c2++;
        }
        return c1 > c2 ? ls : rs;
    }
}
