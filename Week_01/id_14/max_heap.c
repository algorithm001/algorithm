#include<stdio.h>
#include<stdbool.h>


int Heap[512];
int size = 0, maxSize = 0;

int parent(int pos) 
{ 
	return pos / 2; 
}

int leftChild(int pos) 
{ 
	return (2 * pos); 
} 

int rightChild(int pos) 
{ 
	return (2 * pos) + 1; 
} 

bool isLeaf(int pos) 
{ 
	if (pos >= (size / 2) && pos <= size) { 
		return true; 
	} 
	return false; 
} 

void swap(int fpos, int spos) 
{ 
	int tmp; 
	tmp = Heap[fpos]; 
	Heap[fpos] = Heap[spos]; 
	Heap[spos] = tmp; 
} 

/**
 * 大顶堆，堆化
 */
void maxHeapify(int pos) 
{ 
	if (isLeaf(pos)) 
		return; 

	if (Heap[pos] < Heap[leftChild(pos)] ||  
			Heap[pos] < Heap[rightChild(pos)]) { 

		if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) { 
			swap(pos, leftChild(pos)); 
			maxHeapify(leftChild(pos)); 
		} 
		else { 
			swap(pos, rightChild(pos)); 
			maxHeapify(rightChild(pos)); 
		} 
	} 
} 

void insert(int element) 
{ 
	Heap[++size] = element; 

	// Traverse up and fix violated property 
	// 插入时，一直向上堆化
	int current = size; 
	while (Heap[current] > Heap[parent(current)]) { 
		swap(current, parent(current)); 
		current = parent(current); 
	} 
} 

void print() 
{ 
	int i = 1;
	for (i = 1; i <= size / 2; i++) { 
		printf(" PARENT : %d LEFT CHILD : %d  RIGHT CHILD : %d ", Heap[i], Heap[2 * i], Heap[2 * i + 1]); 
		printf("\n"); 
	} 
} 

int extractMax() 
{ 
	int popped = Heap[1]; 
	Heap[1] = Heap[size--]; 
	maxHeapify(1); 
	return popped; 
} 

int main(void) {
	Heap[0] = 210000000;
    maxSize = 512;
	insert(5); 
	insert(3); 
	insert(17); 
	insert(10); 
	insert(84); 
	insert(19); 
	insert(6); 
	insert(22); 
	insert(9); 

	print(); 

}
