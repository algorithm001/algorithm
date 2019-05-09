
    // LeetCode 373

    // 最终要通过sum来比较大小，所以要键已和与元素对的映射关系
    // Hash表<sum, [1,2]>可以，但是sum可能相同，所以不能用
    // 改成<sum, List<[1,2],[2,1]>>，只是每次插入数据时，要取出list，插入后再put

    // 最小的K对数，类似于TopK(小顶堆)，但正好相反，所以考虑用大顶堆实现
    // 大于堆顶丢弃；小于堆顶则替换堆顶，重新堆化
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0){
            return new ArrayList<>();
        }

        // nums1中前k个数，分别和num2中前k个数组合，sum最小的组合一定在这里面
        if (k > nums1.length * nums2.length){
            k = nums1.length * nums2.length;
        }
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        initHeap(k);

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                int[] pair = {nums1[i], nums2[j]};
                List<int[]> list = null;

                if (map.containsKey(sum)){
                    list = map.get(sum);
                }else{
                    list = new ArrayList<>();

                }
                list.add(pair);
                map.put(sum, list);
                insert(sum);
            }
        }

        List<int[]> rst = new ArrayList<>(count);
        // 堆排序，遍历堆，根据sum，在hash表查数字对
        heapSort(heap, count);
        // 去重
        Set<Integer> set = new TreeSet<>();
        for (int i = 1; i <= count; i++) {
            set.add(heap[i]);
        }
        for (int i : set) {
            for (int[] pair : map.get(i)){
                rst.add(pair);
                if (rst.size() == k){
                    return rst;
                }
            }
        }

        return rst;
    }


    private int n;
    private int count;
    private int[] heap;

    public void initHeap(int k){
        n = k;
        count = 0;
        heap = new int[k+1]; // root放在索引1
    }

    // 大顶堆
    public void insert(int val){
        // 堆满
        if (count >= n){
            if (val < heap[1]){
                // 删除堆顶，用最后一个元素替换，自顶向下堆化
                heap[1] = heap[n];
                count --;
                heapifyFromPeak(heap, count, 1);
            }else {
                return;
            }
        }
        count ++;
        heap[count] = val;
        // 自底向上堆化
        heapifyFromBottom(heap, count);
    }

    // 大顶堆，自顶向下堆化
    public void heapifyFromPeak(int[] heap, int n, int pos){
        int i = pos;

        while (true){
            if (i*2 <= n && heap[i] < heap[i*2]){
                swap(heap, i, i*2);
                i = i*2;
            }
            else if (i*2+1 <= n && heap[i] < heap[i*2+1]){
                swap(heap, i, i*2+1);
                i = i*2+1;
            }
            else {
                break;
            }
        }
    }

    // 大顶堆，自底向上堆化
    public void heapifyFromBottom(int[] heap, int n){
        int i = n;
        while (i/2 > 0 && heap[i] > heap[i/2]){
            swap(heap, i, i/2);
            i = i/2;
        }
    }

    // 大顶堆排序
    public void heapSort(int[] heap, int n){
        int k = n;
        while (k > 1){
            swap(heap, 1, k);
            k --;
            heapifyFromPeak(heap, k, 1);
        }
    }


    public void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

