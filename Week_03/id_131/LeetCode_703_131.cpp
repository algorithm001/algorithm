/*
  703.数据流中的第 K 大元素
  设计一个找到数据流中第 K 大元素的类( class ).注意是排序后的第 K 大元素，
  不是第 K 个不同的元素。
  
  你的 KthLargest 类需要一个同时接收整数 k 和整数数组 nums 的构造器，它包含数据流中的
  初始元素。每次调用 KthLargest.add, 返回当前数据流中第 K 大的元素。
  
  示例:
  int k = 3;
  int[] arr = [4,5,8,2];
  KthLargest kthLargest = new KthLargest(3, arr);
  kthLargest.add(3);   // returns 4
  kthLargest.add(5);   // returns 5
  kthLargest.add(10);  // returns 5
  kthLargest.add(9);   // returns 8
  kthLargest.add(4);   // returns 8
  
  说明:
  你可以假设 nums 的长度≥ k-1 且k ≥ 1。
*/
/*
  思想：
  一开始是将所有的数据都保存起来，添加数据时，对所有数据进行排序，非常耗费时间空间
  查了一些资料才发现，根本就不需要这么做，只需维护 K 个最大数据即可
  
  这样就可以维护一个 小顶堆 与堆顶元素进行比较,大于互换，小于则舍弃
  
  使用 priority_queue<Type, Container, Functional> 大/小顶堆存储数据
  
  Type为数据类型， Container为保存数据的容器，Functional为元素比较方式。
  如果不写后两个参数，那么容器默认用的是vector，
  比较方式默认用operator<，也就是优先队列是大顶堆，队头元素最大。
*/
class KthLargest {
private:
    priority_queue< int, vector<int>, greater<int> > lessPileTop;
	int TopK;
public:
KthLargest(int k, vector<int>& nums) {
	TopK = k;
	for(int i = 0; i < nums.size(); ++i)
	{
		add(nums[i]);
	}
}

int add(int val) {
	if( lessPileTop.size() < TopK ) lessPileTop.push(val);
	else if( lessPileTop.top() < val)
	{
		lessPileTop.pop();
		lessPileTop.push(val);
	}
	return lessPileTop.pop();
}
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */