package com.haotone.week_01;

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        
        int ou = 0;
		int ji = 1;
		int n = A.length;
		while(ji<=n-1 && ou<=n-2){
			
			
			if(A[ji]%2!=0){
				ji += 2;
			}else if(A[ou]%2==0){
				ou += 2;
			}else if(A[ji]%2==0 && A[ou]%2!=0){
				int temp = A[ji];
				A[ji] = A[ou];
				A[ou] = temp;
				ji += 2;
				ou += 2;
			}
		}
		return A;
        
    }
}