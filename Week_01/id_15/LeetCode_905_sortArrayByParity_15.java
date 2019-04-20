package com.haotone.week_01;

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int befor = 0;
		int after = A.length-1;
		while(befor<after){
			
			if(A[befor]%2 != 0 && A[after]%2 == 0){
				int temp = A[befor];
				A[befor] = A[after];
				A[after] = temp;
				befor++;
				after--;
			}
			if(A[befor]%2 == 0){
				befor++;
			}
			if(A[after]%2 != 0){
				after--;
			}
			
		}
        return A;
        
    }
}