class Solution {
public:
    bool search(vector<int>& nums, int target) {
        if(nums.size()==0) return false;
        int l=0,r=nums.size()-1;
        while(l<=r){
            while(l<r&&nums[l]==nums[l+1]) l++;
            while(l<r&&nums[r]==nums[r-1]) r--;
            int mid=l+((r-l)>>1);
            if(nums[mid]==target) return true;
            else{
                if(nums[mid]<nums[r]){
                    if(nums[mid]<target&&nums[r]>=target)
                        l=mid+1;
                    else
                        r=mid-1;
                }
                else{
                    if(nums[mid]>target&&nums[l]<=target)
                        r=mid-1;
                    else
                        l=mid+1;
                }
            }
        }
        return false;
    }
};
