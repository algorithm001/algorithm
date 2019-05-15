package com.paula.algorithmsAndDataStructure;

public class LeetCode_922_039 {
	public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
    	int i=0; //偶数下标
    	int j=i+1; //奇数下标
    	Boolean evenIndexOddValue = false;
    	Boolean oddIndexEvenValue = false;
    	
        while (i < len-1 && j < len) {
        	evenIndexOddValue = isOdd(A[i]);
            oddIndexEvenValue= isEven(A[j]);

        	if(!evenIndexOddValue) i +=2;
        	if(!oddIndexEvenValue) j +=2;
        	if(evenIndexOddValue && oddIndexEvenValue) {
        		int tempVal = A[i];
        		A[i] = A[j];
        		A[j] = tempVal;
        		
        		i += 2;
        		j += 2;
        		
        	}
        }
        
     
    	return A;
    }
    
    public  boolean isEven(int value) {
    	
    	return value%2 == 0 ? true : false;
    }
    
    public  boolean isOdd(int value) {
    	
    	return value%2 == 1 ? true : false;
    }

}
