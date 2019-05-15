//对nums进行排序，排序后的中位数就是答案
//使用了归并排序算法

class Solution {
public:
	int majorityElement(vector<int>& nums) {
		mergeSort(nums, 0, nums.size() - 1);
		return nums[nums.size() / 2];
	}

private:
	void mergeSort(vector<int>& nums, int start, int end) {
		if (start >= end) return;

		int middle = (end + start) / 2;

		mergeSort(nums, start, middle);
		mergeSort(nums, middle+1, end);
		merge(nums, start, middle, end);

	}

	void merge(vector<int>& nums, int start, int middle, int end) {
		vector<int> temp;
		int p = start, q = middle + 1;

		while (p <= middle && q <= end) {
	        if (nums[p] <= nums[q])
			{
				temp.push_back(nums[p]);
				p++;
			}
			else {
				temp.push_back(nums[q]);
				q++;
			}
		}

		if (p > middle)
		{
			while (q <= end)
			{
				temp.push_back(nums[q]);
				q++;
			}
		}

		if (q > end)
		{
			while (p <= middle)
			{
				temp.push_back(nums[p]);
				p++;
			}
		}

		for (int each : temp)
		{
			nums[start] = each;
			start++;
		}
		
	}
};