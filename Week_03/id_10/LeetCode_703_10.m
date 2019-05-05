/*
 703.数据流中第K大元素
 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 
 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 
 示例:
 
 int k = 3;
 int[] arr = [4,5,8,2];
 KthLargest kthLargest = new KthLargest(3, arr);
 kthLargest.add(3);   // returns 4
 kthLargest.add(5);   // returns 5
 kthLargest.add(10);  // returns 5
 kthLargest.add(9);   // returns 8
 kthLargest.add(4);   // returns 8
 
 说明:
 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
思路：
 1.构建大小为k的小顶堆，存储后k个元素
 2.构建小顶堆,k之前插入堆化
 3.k之后比较，如果比堆顶大，插入r元素，交换位置（最后位置与堆顶交换），删除末尾元素（前堆顶）
 4.遍历到末尾，则小顶堆构建完毕
 5.新增元素，与堆顶元素比较，如果比堆顶大，
 */
- (void)testkthLargest {
    NSInteger k = 3;
    NSMutableArray * sourceArray = [NSMutableArray arrayWithObjects:@"4",@"5",@"8",@"2", nil];
    if (k > sourceArray.count) {
        return;
    }
    NSMutableArray * heap = [NSMutableArray arrayWithCapacity:0];
    [heap addObject:@"root"];
    [sourceArray enumerateObjectsUsingBlock:^(id  _Nonnull obj, NSUInteger idx, BOOL * _Nonnull stop) {
        [self buildHeap:heap withValue:[obj integerValue] withK:k];
        if (sourceArray.count - 1 == idx) {
            *stop = YES;
        }
    }];
    NSLog(@"3testkthLargest%ld",[self insertValue:3 heap:heap]);
    NSLog(@"5testkthLargest%ld",[self insertValue:5 heap:heap]);
    NSLog(@"10testkthLargest%ld",[self insertValue:10 heap:heap]);
    NSLog(@"9testkthLargest%ld",[self insertValue:9 heap:heap]);
    NSLog(@"4testkthLargest%ld",[self insertValue:4 heap:heap]);
    
}
- (void)buildHeap:(NSMutableArray*)heap withValue:(NSInteger)value withK:(NSInteger)k {
    //如果kx大于数据源count直接返回
    if (heap.count < k+1) {
        //构建堆
        NSInteger index = heap.count;
        heap[index] = [NSNumber numberWithInteger:value];
        while (index/2 > 0 && [heap[index] integerValue] < [heap[index/2] integerValue]) {
            [heap exchangeObjectAtIndex:index withObjectAtIndex:index/2];
            index /= 2;
        }
        
    }
    else {
        [self insertValue:value heap:heap];
    }
}
- (NSInteger)insertValue:(NSInteger)value heap:(NSMutableArray*)heap {
    //向堆中插入元素
    NSInteger topValue = [heap[1] integerValue];
    if (value > topValue) {
        NSInteger index = heap.count;
        //末尾插入元素
        heap[index] = [NSNumber numberWithInteger:value];
        //交换元素位置
        [heap exchangeObjectAtIndex:1 withObjectAtIndex:index];
        //移除末尾元素，原来的堆顶元素
        [heap removeObjectAtIndex:index];
        //堆化
        NSInteger topIndex = 1;
        while (true) {
            NSInteger minPos = topIndex;
            if (topIndex*2 < heap.count && [heap[topIndex] integerValue] > [heap[topIndex*2] integerValue]) {
                minPos = topIndex*2;
                [heap exchangeObjectAtIndex:topIndex withObjectAtIndex:minPos]; //第一次比较之后交换
                
            }
            if (topIndex*2+1 < heap.count && [heap[topIndex] integerValue] > [heap[topIndex*2+1] integerValue]) {
                minPos = topIndex*2+1;
                [heap exchangeObjectAtIndex:topIndex withObjectAtIndex:minPos]; //第一次比较之后交换
            }
            if (minPos == topIndex) {
                break;//堆化结束标志
            }
            topIndex = minPos;//继续下一位置堆化
        }
        
    }
    return [heap[1] integerValue];
}