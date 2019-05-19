class KthLargest {

    private int[] array;
    private int count = 0;
    public KthLargest(int k, int[] nums) {
        System.out.println("k:" + k + "; arrays:" + Arrays.toString(nums));
        array = new int[k + 1];

        for (int num : nums) {
            int r = add(num);
        }
    }

    public int add(int val) {
        if (count == array.length - 1) {
            if (val > array[1]) {
                array[1] = val;
                int i = 1;
                while (true) {
                    int maxPos = i;
                    if (i * 2 < array.length && array[i] > array[i * 2]) maxPos = i * 2;
                    if ((i * 2 + 1) < array.length && array[maxPos] > array[i * 2 + 1]) maxPos = i * 2 + 1;
                    if (maxPos == i) break;
                    swap(array, i, maxPos);
                    i = maxPos;
                }
            }

        } else {
            // 自下向上堆化
            ++count;
            array[count] = val;
            int i = count;
            while (i/2 > 0 && array[i] < array[i/2]) {
                swap(array, i, i/2);
                i = i/2;
            }
        }

        return array[1];

    }

    private void swap(int[] a, int i, int maxPos) {
        int t = a[maxPos];
        a[maxPos] = a[i];
        a[i] = t;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */