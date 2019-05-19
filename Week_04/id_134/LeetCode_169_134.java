public class Solution {
    public int majorityElement(int[] num) {
        
        int ans = 0, cnt = 0;
		 for(int i=0; i<num.length; i++) {
			 if(cnt == 0) {
				 ans = num[i];
				 cnt ++;
			 } else {
				 if(ans == num[i]) {
					 cnt ++;
				 } else {
					 cnt --;
				 }
 			 }
		 }
		 
		 return ans;
        
    }
}
