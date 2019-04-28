/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
 //按单词出现次数排序
/*
 leetcode 692
 ["i", "love", "leetcode", "i", "love", "coding"]
 输出前k个出现次数最多的单词
 */
- (NSMutableArray*)topKFrequent:(NSMutableArray*)array k:(NSInteger)k {
    if (k <= 0) {
        return array;
    }
    if (array.count == 0 || array.count < k) {
        return array;
    }
    NSMutableArray * resultArray = [NSMutableArray arrayWithCapacity:0];
    NSMutableDictionary * dict = [NSMutableDictionary dictionaryWithCapacity:0];
    NSMutableArray * heap = [NSMutableArray arrayWithCapacity:0];
    [heap addObject:@"root"];//第0个位置占位
    for (NSInteger i = 0;i < array.count;i++) {
        NSString * key = array[i];
        [self isContainsKey:key inDict:dict];
    }
    //大顶堆构建
    for (NSString * key in dict) {
        [self buildHeap:dict key:key withArray:heap];
    }
    //输出大顶
    for (NSInteger i = 0;i < k;i++) {
        [resultArray addObject:heap[1]];
        [self removeTopWithHeap:heap dict:dict];// 删除大丁 或者 限制堆化范围

    }
    return resultArray;
}
//插入元素 自下往上堆化
- (void)buildHeap:(NSMutableDictionary*)dict key:(NSString*)key withArray:(NSMutableArray*)array {
    NSInteger index = array.count;
    array[index] = key;
    while (index/2>0 && [[dict valueForKey:array[index]] integerValue] >[[dict valueForKey:array[index/2]] integerValue]) {
        [array exchangeObjectAtIndex:index withObjectAtIndex:index/2];
        index /= 2;
    }
    
}
//删除堆顶元素
- (void)removeTopWithHeap:(NSMutableArray*)heap dict:(NSMutableDictionary*)dict {
    [heap exchangeObjectAtIndex:1 withObjectAtIndex:heap.count-1];
    [heap removeObjectAtIndex:heap.count-1];
    [self heapify:heap withDict:dict index:1];
}
//堆化操作,自上往下堆化
//堆化index位置
- (void)heapify:(NSMutableArray*)heap maxRange:(NSInteger)maxRange withDict:(NSMutableDictionary*)dict  index:(NSInteger)index {
    while (true) {
        NSInteger maxPos = index;
        if (index*2 < maxRange && [[dict objectForKey:heap[index]] integerValue] < [[dict objectForKey:heap[index*2]] integerValue]) {
            maxPos = index*2;
        }
        if (index*2+1 < maxRange && [[dict objectForKey:heap[index]] integerValue] < [[dict objectForKey:heap[index*2+1]] integerValue]) {
            maxPos = index*2+1;
        }
        if (maxPos == index) {
            break;//堆化结束标志
        }
        [heap exchangeObjectAtIndex:index withObjectAtIndex:maxPos]; //第一次比较之后交换
        index = maxPos;//继续下一位置堆化
    }
}
- (void)heapify:(NSMutableArray*)heap withDict:(NSMutableDictionary*)dict  index:(NSInteger)index {
    while (true) {
        NSInteger maxPos = index;
        if (index*2 < heap.count && [[dict objectForKey:heap[index]] integerValue] < [[dict objectForKey:heap[index*2]] integerValue]) {
            maxPos = index*2;
        }
        if (index*2+1 < heap.count && [[dict objectForKey:heap[index]] integerValue] < [[dict objectForKey:heap[index*2+1]] integerValue]) {
            maxPos = index*2+1;
        }
        if (maxPos == index) {
            break;//堆化结束标志
        }
        [heap exchangeObjectAtIndex:index withObjectAtIndex:maxPos]; //第一次比较之后交换
        index = maxPos;//继续下一位置堆化
    }
}
//检测dict是否包含key
//如果包含更新，不包含新增
- (void)isContainsKey:(NSString*)key inDict:(NSMutableDictionary*)dict {
    if ([dict valueForKey:key]) {
        NSInteger count = [[dict valueForKey:key] integerValue];
        count++;
        [dict setValue:[NSNumber numberWithInteger:count] forKey:key];
    }
    else {
        [dict setValue:[NSNumber numberWithInteger:1] forKey:key];
    }
}
