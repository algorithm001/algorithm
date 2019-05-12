/*
 312戳气球
 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 
 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 
 求所能获得硬币的最大数量。
 
 说明:
 
 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 
 示例:
 
 输入: [3,1,5,8]
 输出: 167
 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 

 */
- (NSInteger)maxCoins:(NSMutableArray*)array {
    
    self.maxCoins = 0;
    [self helper:array coins:0 ans:self.maxCoins];
    return self.maxCoins;
}
//回溯法
- (void)helper:(NSMutableArray*)array coins:(NSInteger)coins ans:(NSInteger)ans {
    //boundary
    if (array.count == 0) {
        self.maxCoins = MAX(self.maxCoins,coins);
        return;
    }
    //search
    for (NSInteger i = 0;i < array.count;i++) {
        NSInteger temp = [array[i] integerValue];
        NSInteger delta = temp * (i - 1 < 0 ?1:[array[i-1] integerValue]) * (i + 1 > array.count - 1 ? 1:[array[i+1] integerValue] );
        //戳破气球
        [array removeObjectAtIndex:i];
        //递归调用
        [self helper:array coins:coins+delta ans:self.maxCoins];
        //回溯
        [array insertObject:@(temp) atIndex:i];
    }
}
//动态规划 记忆法（备忘录法）
/*
最优子结构，状态转移方程
 */
- (NSInteger)dpMaxCoins:(NSMutableArray*)array {
    self.dpStateArray = [NSMutableArray arrayWithCapacity:0];
    NSInteger size = array.count;
    [array insertObject:@1 atIndex:0];
    [array addObject:@1];
    //构造状态记录数组
    for (NSInteger i = 0;i < size+2;i++) {
        NSMutableArray * lineArray = [NSMutableArray arrayWithCapacity:0];
        for (NSInteger j = 0;j < size+2;j++) {
            [lineArray addObject:@0];
        }
        [self.dpStateArray addObject:lineArray];
    }
    
    NSInteger ans = [self dpHelper:array i:1 j:size];
    return ans;
}
- (NSInteger)dpHelper:(NSMutableArray*)array i:(NSInteger)i j:(NSInteger)j {
    //boundary
    if (i > j) {
        return 0;
    }
    //缓存加速
    if ([self.dpStateArray[i][j] integerValue] > 0) {
        return [self.dpStateArray[i][j] integerValue];
    }
    //search
    for (NSInteger k = i;k <= j;++k) {
        NSInteger left = [self dpHelper:array i:i j:k-1];
        NSInteger right = [self dpHelper:array i:k+1 j:j];
        NSInteger delta = [array[k] integerValue] * [array[i-1] integerValue] * [array[j+1] integerValue];
        self.dpStateArray[i][j] = @(MAX( [self.dpStateArray[i][j] integerValue], left+right+delta));
    }
    return [self.dpStateArray[i][j] integerValue];
}