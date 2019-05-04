typedef struct {
    int* arr;
    int length;
    int size;
} KthLargest;

int kthLargestAdd(KthLargest* obj, int val);


void KthLargestInsert(KthLargest* obj, int val){
    int loop;

    //isFull, error

    //arr[0] is not used
    obj->size += 1;
    for(loop = obj->size; loop > 1 && val < obj->arr[loop/2]; loop/=2){
        obj->arr[loop] = obj->arr[loop/2];
    }

    obj->arr[loop] = val;

    return;
}

KthLargest* kthLargestCreate(int k, int* nums, int numsSize) {
    KthLargest* obj = malloc(sizeof(KthLargest));
    obj->arr = calloc((k + 1), sizeof(int));
    obj->length = k;
    obj->size   = 0;
    int loop;

    for(loop = 0; loop < numsSize; loop++){
        kthLargestAdd(obj, nums[loop]);
    }

    return obj;
}

int kthLargestAdd(KthLargest* obj, int val) {
#if 1
    int loop;
    int *arr = obj->arr;
    int size = obj->size;
    int child;

    if(obj->length != size){
        KthLargestInsert(obj, val);
        return arr[1];
    }

    if(val <= obj->arr[1]){
        return obj->arr[1];
    }

    for(loop = 1; 2*loop <= size; loop = child){
        child = 2*loop;
        if(child != size && arr[child+1] < arr[child]){
            child += 1;
        }

        if(val > arr[child]){
            arr[loop] = arr[child];
        }
        else{
            break;
        }
    }

    arr[loop] = val;

#endif
    return obj->arr[1];
}

void kthLargestFree(KthLargest* obj) {
    free(obj->arr);
    free(obj);
    return;
}

/**
 * Your KthLargest struct will be instantiated and called as such:
 * KthLargest* obj = kthLargestCreate(k, nums, numsSize);
 * int param_1 = kthLargestAdd(obj, val);
 
 * kthLargestFree(obj);
*/