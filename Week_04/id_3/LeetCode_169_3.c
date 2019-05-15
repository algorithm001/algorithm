int majorityElemetCount(int* nums, int num, int low, int high){
    int loop;
    int count = 0;

    for(loop = low; loop <= high; loop++){
        if(num == nums[loop])
        {
            count ++;
        }
    }

    return count;
}

int majotyElemetRec(int* nums, int low, int high){
    int mid;
    int left;
    int right;
    int leftCnt;
    int rightCnt;
    
    if(low == high){
        return nums[low];
    }

    mid = low + (high-low)/2;

    left = majotyElemetRec(nums, low, mid);
    right = majotyElemetRec(nums, mid+1, high);

    if(left == right){
        return left;
    }

    leftCnt = majorityElemetCount(nums, left, low, high);
    rightCnt = majorityElemetCount(nums, right, low, high);

    return leftCnt > rightCnt ? left : right;
}


int majorityElement(int* nums, int numsSize){
    return majotyElemetRec(nums, 0, numsSize-1);
}

