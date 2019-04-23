#include<stdio.h>

#define LEN 5
int a[LEN] = {10, 5, 2, 4, 8};

/**
 * 插入排序的特点是：
 * 1、左边都是已排序的
 * 2、从左到右，对每个数据排序，看该数据应该插入左边已排序的位置，并插入
 */
void insertion_sort(void) {
	int i, j, key;
	for (j = 1; j < LEN; j++) {
		printf("%d, %d, %d, %d, %d\n",
		       a[0], a[1], a[2], a[3], a[4]);	
		// 从第二个数开始
		key = a[j];
		i = j - 1;
		// 如果前一个位置大于key，那么就往后移动一位，小于等于key的位置
		while (i >= 0 && a[i] > key) {
			a[i+1] = a[i];
			i--;
		}
		// 插入到对应的位置
		a[i+1] = key;
	}
	printf("%d, %d, %d, %d, %d\n",
	       a[0], a[1], a[2], a[3], a[4]);
}

void insertion_sort1(int *arr, int len) {
	int i, j, key;
	for (j = 1; j < len; j++) {
		int t;
		for(t = 0; t < len; t++) {
			printf("%d,",arr[t]);
		}
		printf("\n");

		key = arr[j];
		i = j - 1;
		while (i >=0 && arr[i] > key) {
			arr[i+1] = arr[i];
			i--;
		}
		arr[i+1] = key;
	}
}

int main(void) {
	insertion_sort();

	printf("-------------\n");
	int arr[] = {10, 5, 15, 12, 90, 80};
    int len = sizeof(arr)/sizeof(arr[0]);
	insertion_sort1(arr, len);
	int t;
	for(t = 0; t < len; t++) {
		printf("%d,",arr[t]);
	}
	printf("\n");
	return 0;
}	
