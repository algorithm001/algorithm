package com.paula.algorithmsAndDataStructure.leetcode_104;

/**
 * 
 * @author Paula
 *
 */
public class  LeetCode_104_039{
	
		int[] heapArray;
		int count;
		int k = 0;
		
	    public LeetCode_104_039(int k, int[] nums) {
	    	heapArray = new int[k+1];
	    	count = 0;
	    	
	    	if(nums.length == 0) return;
	        
	        for(int i=0; i<nums.length; i++) {
	        	add(nums[i]);
	        }
	    }
	    
	    
	    public int add(int val) {
	    	if(count < heapArray.length-1) {
	    		count++;
	    		heapArray[count] = val;
	    		heapify(heapArray, count, 1);
	    	}else if(count == heapArray.length-1) {
	    		if(val > heapArray[1]) {
	    			heapArray[1] = val;
	    			heapify(heapArray, count, 1);
	    		}
	    	}
	    	return heapArray[1];
	    }
	    
		/**
		 * 堆化, 自上而下
		 * @param array
		 * @param n 堆中数据个数
		 * @param i 堆化某个数据
		 */
		private void heapify(int[] a, int n, int i) {	
			while(true) {
				int minPos = i;
				if(i*2 <= n && a[minPos] > a[i*2]) minPos = i*2;
				if(i*2+1 <= n && a[minPos] > a[i*2+1]) minPos = i*2+1;
				
				if(minPos == i) break;//不需要交换
				
				swap(a, minPos, i);
				i=minPos;
			}
		}
		
		public static void swap(int[] array, int i, int j) {
			int tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
			//System.out.println("exchange in array: " + Arrays.toString(array));
		}
  
}
