#include<stdio.h>
/**
 * aiter
 * 4.24 07:03
 */

#define LEN 8
int a[LEN] = { 5, 2, 4, 7, 1, 3, 2, 6 };

/**
 * 稳定的排序
 * 空间复杂度O(n)
 * 时间复杂度O(nlogn)
 *
 * 归并的过程：
 * 1. 申请2个归并区间的数组
 * 2. 两个区间内部是有序的
 * 3. 按大小顺序合并两个区间
 * 4. 把剩余的添加在最后
 */
void merge(int start, int mid, int end) {
	int n1 = mid - start + 1;
	int n2 = end - mid;
	int left[n1], right[n2];
	int i, j, k;
	for (i = 0; i < n1; i++) {
		left[i] = a[start+i];
	}
	for (j = 0; j < n2; j++) {
		right[j] = a[mid+1+j];
	}
	i = j = 0;
	k = start;
	while (i < n1 && j < n2) {
		if (left[i] < right[j]) {
			a[k++] = left[i++];
		} else {
			a[k++] = right[j++];
		}
	}
	//如果left有剩余，放在最后
	while (i < n1) {
		a[k++] = left[i++];
	}
	//如果right有剩余，放在最后
	while (j < n2) {
		a[k++] = right[j++];
	}
}

void sort(int start, int end) {
	int mid = 0;
	if (start < end) {
		mid = start + (end - start)/2;
		int t;
		for(t = 0; t < LEN; t++) {
			printf("%d,",a[t]);
		}
		printf("(%d-%d),(%d-%d)\n", start, mid, mid+1, end);
		sort(start, mid);
		sort(mid+1, end);
		merge(start, mid, end);
		for(t = 0; t < LEN; t++) {
			printf("%d,",a[t]);
		}
		printf("(%d-%d),(%d-%d)\n", start, mid, mid+1, end);
	}
}

int main(void) {
	sort(0, LEN-1);
	return 0;
}
			
