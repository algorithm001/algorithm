int arrangeCoins(int n) {
    int low = 0;
    int mid = 0;
    int high = n;
    while(low <= high)
    {
        mid = (low + high) / 2;
        if( 0 <= n - (mid+1)*mid/2 < mid + 1)
                return mid;
        else if(n - (mid+1)*mid/2 >= mid + 1)
                low = mid + 1;
        else if(n - (mid+1)*mid/2 < 0)
                high = mid - 1;
    }
}

//8ms