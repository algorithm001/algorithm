/*
 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 输入: s = "anagram", t = "nagaram"
 输出: true
 */
//242有效的字母异位词
- (BOOL)isAnagram:(NSString*)stringA withStringB:(NSString*)stringB {
    if (stringA == nil || stringB == nil) {
        return NO;
    }
    if (stringB.length != stringA.length) {
        return NO;
    }
    NSMutableDictionary * dictA = [NSMutableDictionary dictionaryWithCapacity:0];
    NSMutableDictionary * dictB = [NSMutableDictionary dictionaryWithCapacity:0];
    NSInteger maxCount = 0;
    
    //构建哈希表
    for (NSInteger i = 0;i< stringA.length;i++) {
        char valueA = [stringA characterAtIndex:i];
        [self addCountWithKey:[NSString stringWithFormat:@"%c",valueA] inDict:dictA];
       // [self isContainsKey:[NSString stringWithFormat:@"%c",valueB] inDict:dictB];
    }
    //匹配减值操作哈希表
    for (NSInteger i = 0;i < stringB.length;i++) {
        char valueB = [stringB characterAtIndex:i];
        [self removeCountWithKey:[NSString stringWithFormat:@"%c",valueB] inDict:dictA];
    }
    if (dictA.allKeys.count != 0) {
        return NO;
    }
    
//    if (dictB.allKeys.count != dictA.allKeys.count) {
//        return NO;
//    }
//    //匹配哈希表算法
//    for (NSString * key in dictB) {
//        NSNumber * valueA = [dictA objectForKey:key];
//        if (valueA) {
//            NSNumber * valueB = [dictB objectForKey:key];
//            if ([valueB integerValue] != [valueA integerValue]) {
//                return NO;
//            }
//        }
//        else {
//            return NO;
//        }
//
//    }
    
    return YES;
}
- (void)addCountWithKey:(NSString*)key inDict:(NSMutableDictionary*)dict {
    if ([dict valueForKey:key]) {
        NSInteger count = [[dict valueForKey:key] integerValue];
        count++;
        [dict setValue:[NSNumber numberWithInteger:count] forKey:key];
    }
    else {
        [dict setValue:[NSNumber numberWithInteger:1] forKey:key];
    }
}
- (void)removeCountWithKey:(NSString*)key inDict:(NSMutableDictionary*)dict {
    if ([dict valueForKey:key]) {
        NSInteger count = [[dict valueForKey:key] integerValue];
        if (count > 1) {
            count--;
            [dict setValue:[NSNumber numberWithInteger:count] forKey:key];
        }
        else {
            [dict removeObjectForKey:key];
        }
        
    }
}