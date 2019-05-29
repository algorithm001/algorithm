//
//  ViewController.m
//  Lesson1
//
//  Created by Mengmeng Zhang on 2019/4/18.
//  Copyright © 2019年 Mengmeng Zhang. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()
@property (nonatomic,strong)NSMutableArray * reslutArray;
@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    NSMutableArray * array = [NSMutableArray arrayWithObjects:@2,@22,@12,@12,@12,@224,@112,@32,@62,@63,@3, nil];
  
    
    self.reslutArray = [NSMutableArray arrayWithCapacity:0];
   // [self mergeArray:[NSMutableArray arrayWithObjects:@1,@11,@16,@19,@110, nil] right:[NSMutableArray arrayWithObjects:@2,@21,@36,@49,@100,@101, nil] result:self.reslutArray];
   // [self mergeSort:array];
    
    NSLog(@"pos-%ld",[self binarySearch:array value:112]) ;
    NSLog(@"posfirst-%ld",[self binarySearch:array firstValue:12]) ;
    NSLog(@"poslast-%ld",[self binarySearch:array lastValue:13]) ;
    NSLog(@"posfirstbig-%ld",[self binarySearch:array firstBigValue:23]);
    NSLog(@"poslastsmall-%ld",[self binarySearch:array lastSmallValue:23]);
    //求第K小
    NSLog(@"findk:%ld",[self  findK:array begin:0 end:array.count-1 indexOfK:6]);
   // [self quickSort:array left:0 right:array.count-1 k:8];
    [self quickSort:array begin:0 end:array.count-1];
     NSLog(@"%@",array);
    [self quickSort:array left:0 right:array.count-1];
    NSLog(@"%@",array);
}
//bubblesort
/*
 注意值得比较 比较方式：相邻元素比较
 优化：1.比较次数 2.提前退出标志
 */
- (void)bubbleSort:(NSMutableArray*)array {
    if (array == nil) {
        return;
    }
    if (array.count <= 1) {
        return;
    }
    for (NSInteger i = 0;i < array.count;i++) {
        NSInteger flag = 0;
        for (NSInteger j = 0;j < array.count-1-i;j++) {
            if ([array[j] integerValue] > [array[j+1] integerValue]) {
                NSInteger temp = [array[j] integerValue];
                array[j] = array[j+1];
                array[j+1] = [NSNumber numberWithInteger:temp];
                flag = 1;
            }
        }
        if (!flag) {
            return;
        }
    }
}
//selectSort
/*
 比较方式：每个位置依次找到最大最小值，依次比较
 优化：记录最小值位置，交换次数优化
 */
- (void)selectSort:(NSMutableArray*)array {
    if (array == nil) {
        return;
    }
    if (array.count <= 1) {
        return;
    }
    for (NSInteger i = 0;i < array.count;i++) {
        NSInteger minPos = i;
        for (NSInteger j = i+1; j < array.count;j++) {
            if ( [array[minPos] integerValue] > [array[j] integerValue]) {
                minPos = j;
            }
            if (j == array.count - 1) {
                NSInteger temp = [array[minPos] integerValue];
                array[minPos] = array[i];
                array[i] = [NSNumber numberWithInteger:temp];
            }
        }
        
    }
    
}
//insertSort
/*
 元素比较，元素移动
 已排序区间
 */
- (void)insertSort:(NSMutableArray*)array {
    if (array == nil) {
        return;
    }
    if (array.count <= 1) {
        return;
    }
    for (NSInteger i = 1;i < array.count;i++) {
        //要插入的数据
        NSInteger temp = [array[i] integerValue];
        NSInteger j = i-1;
        //已排序区间
        for (;j >= 0;--j) {
            //查找插入位置
            if ([array[j] integerValue] > temp) {
                //依次向后移动
                array[j+1] = array[j];
            }
            else {
                break;
            }
            
        }
        array[j+1] = [NSNumber numberWithInteger:temp];
    }
}
//归并排序
- (void)mergeSort:(NSMutableArray*)array {
   NSMutableArray * res =  [self mergeSort:array begin:0 end:array.count-1];
    NSLog(@"res--%@",res);
}
- (NSMutableArray*)mergeSort:(NSMutableArray*)array begin:(NSInteger)begin end:(NSInteger)end {
    if (begin >= end) {
        return [NSMutableArray arrayWithObjects:array[begin], nil];
    }
    NSInteger middle = (begin+end)/2;
    NSMutableArray * leftArray = [self devidArray:array begin:begin end:middle];
    NSMutableArray * rightArray = [self devidArray:array begin:middle+1 end:end];
    [self mergeSort:leftArray begin:0 end:leftArray.count-1];
    [self mergeSort:rightArray begin:0 end:rightArray.count-1];
    NSMutableArray * res = [self mergeArray:leftArray right:rightArray ];
    return  res;
}
//分割数组
- (NSMutableArray*)devidArray:(NSMutableArray*)array begin:(NSInteger)begin end:(NSInteger)end {
    NSMutableArray * reslutArray = [NSMutableArray arrayWithCapacity:0];
    for (NSInteger i = begin;i <= end;i++) {
        [reslutArray addObject:array[i]];
    }
    return reslutArray;
}
//合并数组
- (NSMutableArray*)mergeArray:(NSMutableArray*)left right:(NSMutableArray*)right {
    NSMutableArray * resultArray = [NSMutableArray arrayWithCapacity:0];
    NSInteger i = 0;
    NSInteger j = 0;
    while (i < left.count && j < right.count) {
        NSInteger valueL = [left[i] integerValue];
        NSInteger valueR = [right[j] integerValue];
        if (valueL < valueR) {
            [resultArray addObject:[NSNumber numberWithInteger:valueL]];
            i++;
        }
        else {
            [resultArray addObject:[NSNumber numberWithInteger:valueR]];
            j++;
        }
    }
    if (i < left.count) {
        for (;i<left.count;i++) {
            [resultArray addObject:left[i]];
        }
    }
    if (j < right.count) {
        for (;j < right.count;j++) {
            [resultArray addObject:right[j]];
        }
    }
    return resultArray;
}


//有序数组 简单二分查找
//返回 112的位置
- (NSInteger)binarySearch:(NSMutableArray*)array value:(NSInteger)value {
    NSInteger head = 0;
    NSInteger tail = array.count - 1;
    
    while (head <= tail) {
        NSInteger middle = head+(tail-head)/2;
        if ([array[middle] integerValue] > value) {
            tail = middle - 1;
        }
        else if ([array[middle] integerValue] < value) {
            head = middle + 1;
        }
        else {
            return middle;
        }
    }
    return -1;
}
//变形问题
/*
 查找第一个值等于给定值的元素
 查找最后一个值等于给定值得元素
 查找第一个大于等于给定值的元素
 查找最后一个小于等于给定值的元素
 */
//最后一个小于等于给定值的元素
- (NSInteger)binarySearch:(NSMutableArray*)array lastSmallValue:(NSInteger)value {
    NSInteger head = 0;
    NSInteger tail = array.count - 1;
    while (head <= tail) {
        NSInteger middle = head + (tail-head)/2;
        if ([array[middle] integerValue] <= value) {
            if (middle == array.count - 1) {
                return middle;
            }
            else if (middle + 1 <=  array.count - 1) {
                if ([array[middle+1] integerValue] > value) {
                    return middle;
                }
                else {
                   head = middle + 1;
                }
            }
            else {
               head = middle + 1;
            }
            
        }
        else if ([array[middle] integerValue] > value) {
            
             tail = middle - 1;
        }
    }
    return -1;
}
//第一个大于等于给定值
- (NSInteger)binarySearch:(NSMutableArray*)array firstBigValue:(NSInteger)value {
    NSInteger head = 0;
    NSInteger tail = array.count - 1;
    while (head <= tail) {
        NSInteger middle = head + (tail-head)/2;
        if ([array[middle] integerValue] >= value) {
            if (middle == 0) {
                return middle;
            }
            else if (middle - 1 >= 0) {
                if ([array[middle-1] integerValue] < value) {
                    return middle;
                }
                else {
                    tail = middle - 1;
                }
            }
            else {
                tail = middle - 1;
            }
            
        }
        else if ([array[middle] integerValue] <value) {
            head = middle + 1;
        }
    }
    return -1;
}
//查找第一个值等于给定值的元素
/*
 1.是不是第一个元素
 2.前一个元素是不是也等于value
 */
- (NSInteger)binarySearch:(NSMutableArray*)array firstValue:(NSInteger)value {
    NSInteger head = 0;
    NSInteger tail = array.count - 1;
    while (head <= tail) {
        NSInteger middle = head + (tail-head)/2;
        if ([array[middle] integerValue] > value) {
            tail = middle - 1;
        }
        else if ([array[middle] integerValue] <value) {
            head = middle + 1;
        }
        else {
            if (middle == 0) {
                return middle;
            }
            else if (middle >= 1) {
                if ([array[middle - 1] integerValue] != value) {
                    return middle;
                }
                else {
                    //向前找
                    tail = middle - 1;
                }
            }
            else {
                //向前找
                tail = middle - 1;
            }
        }
    }
    return -1;
}
/*
 1.是不是最后一个元素
 2.后一个元素是不是也是value
 */
- (NSInteger)binarySearch:(NSMutableArray*)array lastValue:(NSInteger)value {
    NSInteger head = 0;
    NSInteger tail = array.count - 1;
    while (head <= tail) {
        NSInteger middle = head + (tail-head)/2;
        if ([array[middle] integerValue] > value) {
            tail = middle - 1;
        }
        else if ([array[middle] integerValue] <value) {
            head = middle + 1;
        }
        else {
            if (middle == array.count - 1) {
                return middle;
            }
            else if (middle+1 <= array.count - 1) {
                if ([array[middle + 1] integerValue] != value) {
                    return middle;
                }
                else {
                    //向后找
                    head = middle + 1;
                }
            }
            else {
                //向后找
                head = middle + 1;
            }
        }
    }
    return -1;
}
//求第K大
/*
 思路：1.快速排序，o(nlogn),直接返回下标
 2.借助快排分区函数
 备注：这个函数算法有问题
 */
- (NSInteger)findKInArray:(NSMutableArray*)array k:(NSInteger)k {
    if (k > array.count) {
        return -1;
    }
    NSInteger pivot = [self pivot:array];
    NSInteger count = 0;
    for (NSInteger i = 0;i < array.count - 1; i++) {
        if ([array[i] integerValue] <= [array[pivot] integerValue]) {
            [array addObject:array[i]];
            [array removeObjectAtIndex:i];
            //记录每一次插入后面的个数，则array.count - count即为当前位置是第几大
            count++;
        }
    }
    NSInteger index = array.count - count ;
    if (index == k) {
        return [array[index-1] integerValue];
    }
    NSMutableArray * nextArray = nil;
    if (index < k) {
        k = k - index;
        nextArray = [self devidArray:array begin:index end:array.count-1];
    }
    else {
        nextArray = [self devidArray:array begin:0 end:index-2];
    }
    return [self findKInArray:nextArray k:k];
}
//简单分区函数-以数组最后一个位置为分区
- (NSInteger)pivot:(NSArray*)array {
    return array.count - 1;
}
//求第K小
- (NSInteger)findK:(NSMutableArray*)array begin:(NSInteger)begin end:(NSInteger)end indexOfK:(NSInteger)k {
    if (begin >= end) {
        return -1;
    }
    NSInteger partition = [self partition:array left:begin right:end];
    if (partition+1 == k) {
        return [array[partition] integerValue];
    }
    else if (k > partition+1) {
      return   [self findK:array begin:partition+1 end:end indexOfK:k];
    }
    else {
      return   [self findK:array begin:begin end:partition-1 indexOfK:k];
    }
    return -1;
    
}
//快速排序一
- (void)quickSort:(NSMutableArray*)array begin:(NSInteger)begin end:(NSInteger)end {
    if (begin >= end) {
        return;
    }
   // NSInteger partition = [self partition:array left:begin right:end];
    
    NSInteger i = begin;
    NSInteger j = end;
    NSInteger key = end;
    while (i != j) {
        //注意前后顺序 下面顺序反了，所以错了, 如果key改为end，则能正确输出
        //key从头，先遍历尾;key从尾，先遍历头
        while (i<j && [array[i] integerValue] <= [array[key] integerValue]) {
            i++;
        }
        while (i<j && [array[j] integerValue] >= [array[key] integerValue]) {
            j--;
        }
        
        if (i < j) {
            [array exchangeObjectAtIndex:i withObjectAtIndex:j];
        }
        
    }
    [array exchangeObjectAtIndex:i withObjectAtIndex:end];
    
    [self quickSort:array begin:begin end:i - 1];
    [self quickSort:array begin:i + 1 end:end];
}
//快速排序二
- (void)quickSort:(NSMutableArray*)array left:(NSInteger)left right:(NSInteger)right {
    if (left >= right) {
        return;
    }
    NSInteger partition = [self partition:array left:left right:right];
    //继续左边的排序
    [self quickSort:array left:left right:partition - 1];
    //继续右边的排序
    [self quickSort:array left:partition + 1 right:right];
}
//复杂分区函数
- (NSInteger)partition:(NSMutableArray*)array left:(NSInteger)left right:(NSInteger)right {
    NSInteger key = left;
    NSInteger i = left;
    NSInteger j = right;
    while (i != j) {
        while (i<j && [array[key] integerValue] <= [array[j] integerValue]) {
            j--;
        }
        while (i<j && [array[key] integerValue] >= [array[i] integerValue]) {
            i++;
        }
        if (i<j) {
            [array exchangeObjectAtIndex:i withObjectAtIndex:j];
        }
    }
    
    //最终将基准数归位, 因为i == j, 需要将<基数所在位置的value>与<i/j相等的位置的value>互换位置
    [array exchangeObjectAtIndex:i withObjectAtIndex:left];
    return i;
}


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


@end
