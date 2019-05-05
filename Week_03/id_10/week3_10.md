# 堆排序与优先级队列

堆排序（heapsort）是一种比较快速的排序方式，它的时间复杂度为O(nlgn)，而且堆排序具有空间原址性：即任何时候只需要有限（常数个）的空间来存储临时数据。而且堆排序还被应用在构造优先级队列中。

堆排序是一个优秀的算法，在操作系统中可以利用最大堆实现最大优先队列来实现共享计算机系统的作业调度。最大优先队列记录各个作业之间的相对优先级，当某个作业中断后选出具有最高优先级的队列来执行。

常用操作OC实现如下（ LeetCode703.数据流中第K大元素）：

1.构建堆（自下而上的堆化）

```
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
```

2.插入元素（以更新堆顶元素举例）（自上而下的堆化）

```
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
```

3.堆排序，借助堆化（不断取出堆顶元素，每次取出元素后堆化操作logn,所以总时间复杂对nlogn）。

