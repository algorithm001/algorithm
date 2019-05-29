/*
 200.岛屿的个数
 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 
 示例 1:
 
 输入:
 11110
 11010
 11000
 00000
 
 输出: 1
 
 示例 2:
 
 输入:
 11000
 11000
 00100
 00011
 
 输出: 3
 
 算法核心框架：深度搜索+递归
 
 深度搜索：整个岛屿是一个“二维矩阵”（vector<vectro<char>>），使用深度优先搜索遍历一遍整个矩阵；
 递归：当扫描到'1'时，调用infect（）函数，将该 ‘1’ 上下左右相邻的位置都感染为 ‘2’，递归调用infect（）的结果是从起始的 ‘1’ 开始而相连的一片‘1’都被感染为 ‘2’；

 */
- (void)testNumOfLand {
    NSMutableArray * array1 = [NSMutableArray arrayWithObjects:@1,@1,@0,@0,@0, nil];
    NSMutableArray * islandArray = [NSMutableArray arrayWithCapacity:0];
    [islandArray addObject:array1];
    [islandArray addObject:array1];
    NSMutableArray * array2 = [NSMutableArray arrayWithObjects:@0,@0,@1,@0,@1, nil];
    NSMutableArray * array3 = [NSMutableArray arrayWithObjects:@0,@0,@0,@1,@0, nil];
    [islandArray addObject:array2];
    [islandArray addObject:array3];
    NSLog(@"islandnums%ld",[self numIsLands:islandArray]) ;
}
- (NSInteger)numIsLands:(NSMutableArray*)island {
    NSInteger res = 0;
    if (island.count == 0) {
        return 0;
    }
    NSMutableArray * array = island[0];
    if (array.count == 0) {
        return 0;
    }
    //深度优先，暴力破解，回溯
    for (NSInteger i = 0;i < island.count;i++) {
        NSMutableArray * yArray = island[i];
        for (NSInteger j = 0; j < yArray.count; j++) {
            if ([yArray[j] integerValue] == 1) {
                res++;
                //递归
                [self infect:i xCount:island.count y:j yCount:yArray.count array:island];
            }
        }
    }
    return res;
}
- (void)infect:(NSInteger)x xCount:(NSInteger)xCount y:(NSInteger)y yCount:(NSInteger)yCount array:(NSMutableArray*)array {
    if (x < 0 || y < 0 || x > xCount-1 || y > yCount-1) {
        return;
    }
    NSMutableArray * xArray = array[x];
    if ([xArray[y] integerValue] != 1) {
        return;
    }
    xArray[y] = [NSNumber numberWithInteger:2];
    [self infect:x+1 xCount:xCount y:y yCount:yCount array:array];
    [self infect:x-1 xCount:xCount y:y yCount:yCount array:array];
    [self infect:x xCount:xCount y:y-1 yCount:yCount array:array];
    [self infect:x xCount:xCount y:y+1 yCount:yCount array:array];
}