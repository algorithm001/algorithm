/*
 169. 求众数
 题目描述
 评论 (329)
 题解New
 提交记录
 
 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 
 你可以假设数组是非空的，并且给定的数组总是存在众数。
 
 示例 1:
 
 输入: [3,2,3]
 输出: 3
 
 示例 2:
 
 输入: [2,2,1,1,1,2,2]
 输出: 2
 
 1.哈希表统计出现次数
 2.加一减一 摩尔投票
 3.二分法，一直取中间值

 */
- (void)testMajorityElement {
   NSLog(@"众数为%ld",[self majorityElement:[NSMutableArray arrayWithObjects:@1,@1,@1,@1,@1,@2,@2,@2, nil]]) ;
}
- (NSInteger)majorityElement:(NSMutableArray*)array {
    if (array == nil) {
        return -1;
    }
    if (array.count == 0) {
        return -1;
    }
    if (array.count == 1) {
        return [array[0] integerValue];
    }
    __block NSInteger moore = [array[0] integerValue];
    __block NSInteger count = 0;
    [array enumerateObjectsUsingBlock:^(id  _Nonnull obj, NSUInteger idx, BOOL * _Nonnull stop) {
        if (count == 0) {
            moore = [obj integerValue];
        }
        if ([obj integerValue] == moore) {
            count++;
        }
        else {
            count--;
        }
        if (idx == array.count - 1) {
            *stop = YES;
        }
    }];
    return moore;
}
