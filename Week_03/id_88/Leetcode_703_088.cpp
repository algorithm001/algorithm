class KthLargest {
private:
	vector<int> heap;
	int K;
public:
	KthLargest(int k, vector<int>& nums) {
		K = k;

		for (int i = 0; i < nums.size(); i++)
		{
			add(nums[i]);
		}
	}


	int add(int val) {

		if (heap.size() < K)
		{
			heap.push_back(val);

			int size = heap.size();
			int i = size - 1;

			while (true)
			{
				int j = (i % 2 == 0) ? i / 2 - 1 : i / 2;
				if (j >= 0 && heap[i] < heap[j])
				{
					swap(heap[j], heap[i]);
				}
				else
				{
					break;
				}
				i = j;
			}
		}
		else
		{
			if (val <= heap[0]) return heap[0];

			heap[0] = val;

			int i = 0;
			while (true)
			{
				int minPos = i;
				if (2 * i + 1 < K && heap[i] > heap[2 * i + 1])
				{
					minPos = 2 * i + 1;
				}
				if (2 * i + 2 < K && heap[minPos] > heap[2 * i + 2])
				{
					minPos = 2 * i + 2;
				}
				if (minPos == i)
				{
					break;
				}
				swap(heap[i], heap[minPos]);
				i = minPos;
			}
		}

		return heap[0];
	}

private:
	void swap(int& a, int& b)
	{
		int temp = 0;
		temp = a;
		a = b;
		b = temp;
	}
};
