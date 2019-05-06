/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

int* sortArrayByParity(int* A, int ASize, int* returnSize){
    int* B = NULL;
    int loop;
    int evenIndex = 0;
    int oddIndex = ASize - 1;

    if(!A){
        return NULL;
    }

    B = malloc(ASize * sizeof(int));

    for(loop = 0; loop < ASize; loop++){
        if(A[loop]%2){
            B[oddIndex] = A[loop];
            oddIndex--;
        }
        else{
            B[evenIndex] = A[loop];
            evenIndex++;
        }
 
    }

    *returnSize = ASize;
    return B;
}