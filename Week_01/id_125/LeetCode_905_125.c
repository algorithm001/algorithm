/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* sortArrayByParity(int* A, int ASize, int* returnSize) {
    int *returnA = (int*)malloc(ASize*sizeof(int));
    int i, j, tmp;
    for(i = 0, j = 0; i < ASize; i++) {
        if(A[i]%2 == 0) {
            returnA[j++] = A[i];
        }
    }
    for(i = 0; i<ASize; i++){
        if(A[i]%2 != 0) {
            returnA[j++] = A[i];
        }
    }
    *returnSize = j;
    return returnA;
}

int main(int argc, char *argv[]) {
    int A[] = {3, 1, 2, 4};
    //int A[] = {3, 1};
    int size;
    int *newA;
    int i;
    newA = sortArrayByParity(A, sizeof(A)/sizeof(int), &size);
    for(i = 0; i < size; i++){
        printf("%d: %d\n", i, newA[i]);
    }
    return 0;
}
