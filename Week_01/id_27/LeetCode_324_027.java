class Solution {
    public void wiggleSort(int[] nums) {


		int arrLen = nums.length;
		int[] tmp = Arrays.copyOf(nums, arrLen);
		Arrays.sort(tmp);
		int pos = 0;

		int smallIndex = arrLen % 2 == 0 ? arrLen / 2-1 : arrLen / 2;
		int bigIndex = arrLen-1;
		for (int i = smallIndex, j = bigIndex;; i--,j--) {
			if (pos >= arrLen)	break;
			nums[pos++] = tmp[i];
			if (pos>= arrLen)	break;
			nums[pos++] = tmp[j];
		}


    }
}
