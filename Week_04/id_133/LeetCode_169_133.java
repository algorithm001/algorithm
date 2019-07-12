class Solution {
    public int majorityElement(int[] nums) {
        //借鉴评论中的投票摩尔法
        //第一次接触，大概解释是：在每一轮投票过程中，从数组中找出一对不同的元素，将其从数组中删除。这样不断的删除直到无法再进行投票，如果数组为空，则没有任何元素出现的次数超过该数组长度的一半。如果只存在一种元素，那么这个元素则可能为目标元素。
        int temp=nums[0];
    	int count=1;
        
        for(int i=1;i<nums.length;i++){
        	if(nums[i]==temp){
        		count++;
        	}else{
        		count--;
        		if(count==0){
        			temp=nums[i];
                    count=1;
        		}
        	}
        }
        return temp;
    }
}
