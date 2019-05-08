### 链表

#### [83. 删除排序链表中的重复元素](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/)

给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

**示例 1:**

```
输入: 1->1->2
输出: 1->2
```

**示例 2:**

```
输入: 1->1->2->3->3
输出: 1->2->3
```

**代码:**

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pointer = head;

       while(pointer!=null){
            if(pointer.next!=null && pointer.val== pointer.next.val){
                pointer.next = pointer.next.next;
            }else{
               pointer = pointer.next; 
            } 
           
       }
        return head;
    }
}
```

#### [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

**示例：**

```
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```

**代码:**

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }
        ListNode listNew ;
        if(p1.val<p2.val){
            listNew = new ListNode(p1.val);
            p1 = p1.next;
        }else{
            listNew = new ListNode(p2.val);
            p2 = p2.next;
        }
        ListNode p=listNew;
        

        while(p1!=null && p2!=null){
            if(p1.val<p2.val){
                p.next = new ListNode(p1.val);
                p1 = p1.next;
            }else{
                p.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            p = p.next;
             
        }
        
        if(p1==null){
            p.next = p2;
        }else{
            p.next = p1;
        }
        
        return listNew;
        
    }
}
```

#### [24. 两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)

给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

**你不能只是单纯的改变节点内部的值**，而是需要实际的进行节点交换。

 

**示例:**

```
给定 1->2->3->4, 你应该返回 2->1->4->3.
```

**代码:**

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slowPointer = head;
        ListNode fastPointer = head.next; 
        ListNode p=fastPointer.next;
        
        fastPointer.next = slowPointer;    
        slowPointer.next =p;
            
        if(p == null){
            return fastPointer;
        }
        head = fastPointer;
        ListNode headPointer = fastPointer.next;
        
        slowPointer = p;
        fastPointer = p.next;
        
        while(slowPointer != null && fastPointer !=null){
            p=fastPointer.next;
            fastPointer.next = slowPointer;    
            slowPointer.next =p;
            headPointer.next = fastPointer;
            headPointer = fastPointer.next;
            slowPointer = p;
            if(p!=null){               
                fastPointer = p.next;
            }else{
                fastPointer= null;
            }
        }
        return head;
    }
}
```

#### [142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)

给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 `null`。

为了表示给定链表中的环，我们使用整数 `pos` 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 `pos` 是 `-1`，则在该链表中没有环。

**说明：**不允许修改给定的链表。

 

**示例 1：**

```
输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。
```

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist.png)

**示例 2：**

```
输入：head = [1,2], pos = 0
输出：tail connects to node index 0
解释：链表中有一个环，其尾部连接到第一个节点。
```

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test2.png)

**示例 3：**

```
输入：head = [1], pos = -1
输出：no cycle
解释：链表中没有环。
```

![img](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/12/07/circularlinkedlist_test3.png)

**代码:**

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> cache = new HashSet<ListNode>();
       
        while(head != null){
            if(cache.contains(head)){
                return head;
            }else{
                cache.add(head);
                head = head.next;
            }
        }
        
        return null;
        
    }
}
```

#### 25.k个一组翻转链表

给出一个链表，每 *k* 个节点一组进行翻转，并返回翻转后的链表。

*k* 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 *k* 的整数倍，那么将最后剩余节点保持原有顺序。

**示例 :**

给定这个链表：`1->2->3->4->5`

当 *k* = 2 时，应当返回: `2->1->4->3->5`

当 *k* = 3 时，应当返回: `3->2->1->4->5`

**说明 :**

- 你的算法只能使用常数的额外空间。
- **你不能只是单纯的改变节点内部的值**，而是需要实际的进行节点交换。

**代码:**

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null){
            return null;
        }
        
        //记录头节点
        ListNode headPointer = head;
        //记录尾节点
        ListNode tailPointer = head;
        //记录节点个数
        int n = 0;
        while(tailPointer != null){
             n++;
            if(n == k){
                //k以后的节点递归处理
                ListNode tmpTail = reverseKGroup(tailPointer.next,k);
                //反转前k个节点 并链接尾节点
                reverseK(headPointer,k).next = tmpTail;
                break;
            }
             tailPointer = tailPointer.next;   
        }
        
        if(n < k){
            //不足k个节点 直接返回头节点
            return headPointer;
        }else{
            //有k个节点 返回反转后的头节点 即原来的尾节点
            return tailPointer; 
        }

       
    }
    
    public ListNode reverseK(ListNode head, int k){
        if(k == 1){
            return head;
        }
        ListNode headNew = reverseK(head.next,k-1);
        headNew.next = head;
        head.next = null;
     
        return head;
    }
    

}
```

### 数组

#### [905. 按奇偶排序数组](https://leetcode-cn.com/problems/sort-array-by-parity/)

给定一个非负整数数组 `A`，返回一个由 `A` 的所有偶数元素组成的数组，后面跟 `A` 的所有奇数元素。

你可以返回满足此条件的任何数组作为答案。

 

**示例：**

```
输入：[3,1,2,4]
输出：[2,4,3,1]
输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
```

 

**提示：**

1. `1 <= A.length <= 5000`
2. `0 <= A[i] <= 5000`

```java
class Solution {
        
    
    public int[] sortArrayByParity(int[] A) {
        int[] arr =new  int[A.length];
        int start = -1, end = A.length;
        for(int i=0;i<A.length;i++){
            if(A[i] % 2 == 0){
                arr[++start]=A[i];
            }else{           
               arr[--end]=A[i];
            }
            if((start+1) == end){
                return arr;
            } 
        }
        return arr;
    } 
  
}
```

#### [922. 按奇偶排序数组 II](https://leetcode-cn.com/problems/sort-array-by-parity-ii/)

给定一个非负整数数组 `A`， A 中一半整数是奇数，一半整数是偶数。

对数组进行排序，以便当 `A[i]` 为奇数时，`i` 也是奇数；当 `A[i]` 为偶数时， `i` 也是偶数。

你可以返回任何满足上述条件的数组作为答案。

 

**示例：**

```
输入：[4,2,5,7]
输出：[4,5,2,7]
解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
```

 

**提示：**

1. `2 <= A.length <= 20000`
2. `A.length % 2 == 0`
3. `0 <= A[i] <= 1000`

```java
class Solution {
    
    public int[] sortArrayByParityII(int[] A) {
        int[] arr = new int[A.length];
        int evenStart = -2, oddStart = -1;
        for(int i=0;i<A.length;i++){
            if(A[i] % 2 == 0){
                evenStart += 2;
                arr[evenStart] = A[i];
            }else{   
                oddStart += 2;
                arr[oddStart] = A[i];
            }
        }
        return arr;
    }
}
```

#### [81. 搜索旋转排序数组 II](https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/)

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 `[0,0,1,2,2,5,6]` 可能变为 `[2,5,6,0,0,1,2]` )。

编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 `true`，否则返回 `false`。

**示例 1:**

```
输入: nums = [2,5,6,0,0,1,2], target = 0
输出: true
```

**示例 2:**

```
输入: nums = [2,5,6,0,0,1,2], target = 3
输出: false
```

**进阶:**

- 这是 [搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/) 的延伸题目，本题中的 `nums`  可能包含重复元素。
- 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？

**代码：**

```java
class Solution {
    public boolean search(int[] nums, int target) {
       int left = 0,right = nums.length-1,end = nums.length-1,mid;
        if(end < 0){
            return false;
        }else if(end == 0){
            return nums[0] == target;
        }    

        if(nums[0]<nums[end]){
            return binarySearch(nums,target,0 ,end) > -1;
        }else if(nums[0] == target){
               return true;
         }else{
            while(left < end && nums[left] == nums[left+1]){                 
                left++;               
               }
            while(right > 0 && nums[right] == nums[right-1]){                   
                right--;
            }
           }
   
        int maxIndex = -1;
        
        while(left <= right){  
            mid = left + ((right - left) >> 1);
            if(nums[mid] > nums[mid+1]){
                maxIndex = mid;
                break;
            }else if(nums[mid] < nums[0]){
                 right = mid -1;
             }else{
                 left = mid +1;
             }
        }
        if(target < nums[0]){
            return binarySearch(nums,target,maxIndex+1 ,end) > -1;              
        }else{
          return binarySearch(nums,target,0 ,maxIndex) > -1;             
        }    
        
    }
    
    public int binarySearch(int[] nums,int target,int left ,int right){
        if(left>right){
            return -1;
        }
        int mid = left + ((right - left) >> 1);
        if(nums[mid] > target){
            return binarySearch(nums,target,left,mid-1);
        }else if(nums[mid] < target){
            return binarySearch(nums,target,mid + 1,right);
        }else{
            return mid;
        }
    }
}
```

#### [153. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 `[0,1,2,4,5,6,7]` 可能变为 `[4,5,6,7,0,1,2]` )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

**示例 1:**

```
输入: [3,4,5,1,2]
输出: 1
```

**示例 2:**

```
输入: [4,5,6,7,0,1,2]
输出: 0
```

**代码：**

```java
class Solution {
    public int findMin(int[] nums) {
          int left = 0,right = nums.length-1,end = nums.length-1,mid;
        if(end < 0){
            return -1;
        }else if(end == 0){
            return nums[0];
        }    

        if(nums[0]<nums[end]){
            return nums[0];
        }
   
        int maxIndex = -1;
        
        while(left <= right){  
            mid = left + ((right - left) >> 1);
            if(nums[mid] > nums[mid+1]){
                maxIndex = mid;
                break;
            }else if(nums[mid] < nums[0]){
                 right = mid -1;
             }else{
                 left = mid +1;
             }
        }
        return nums[maxIndex + 1];
    }
}
```

#### [33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 `[0,1,2,4,5,6,7]` 可能变为 `[4,5,6,7,0,1,2]` )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 `-1` 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 *O*(log *n*) 级别。

**示例 1:**

```
输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
```

**示例 2:**

```
输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
```

**代码：**

```java
class Solution {

  public int search(int[] nums, int target) {
   int left = 0,right = nums.length-1,end = nums.length-1,mid;
    if(end < 0){
        return -1;
    }else if(end == 0){
        return nums[0] == target ? 0 : -1;
    }    

    if(nums[0]<nums[end]){
        return binarySearch(nums,target,0 ,end);
    }

    int maxIndex = -1;
    //查找最大值索引
    while(left <= right){  
        mid = left + ((right - left) >> 1);
        if(nums[mid] > nums[mid+1]){
            maxIndex = mid;
            break;
        }else if(nums[mid] < nums[0]){
             right = mid -1;
         }else{
             left = mid +1;
         }
    }
      
    //比较最大值 进行区间二分查找
    if(target < nums[0]){
        return binarySearch(nums,target,maxIndex+1 ,end) ;              
    }else{
      return binarySearch(nums,target,0 ,maxIndex) ;             
    }    

}
    
public int binarySearch(int[] nums,int target,int left ,int right){
    if(left>right){
        return -1;
    }
    int mid = left + ((right - left) >> 1);
    if(nums[mid] > target){
        return binarySearch(nums,target,left,mid-1);
    }else if(nums[mid] < target){
        return binarySearch(nums,target,mid + 1,right);
    }else{
        return mid;
    }
}
}
```

### 栈

#### [20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)

```java
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
```

**代码：**

```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if(s.length() == 0){
            return true;
        }
        boolean flag = true;
        char ch;
        for(int i=0;i<s.length();i++){
            ch = s.charAt(i);
             try {
             if (ch == ')') {
                if ('('==stack.pop()) {
                    continue;
                } else {
                    return false;
                }
            } else if (ch==']') {
                if ('['==stack.pop()) {
                    continue;
                } else {
                   return false;
                }
            } else if (ch =='}') {
                if ('{'==stack.pop()) {
                    continue;
                } else {
                   return false;
                }
            }else{
               stack.push(ch); 
            }
            } catch (Exception e) {
               return false;
            }      
            
        }

        if(stack.size()>0){
            return false;
        }else {
            return flag;
        }
    }
}
```

#### [496. 下一个更大元素 I](https://leetcode-cn.com/problems/next-greater-element-i/)

给定两个**没有重复元素**的数组 `nums1` 和 `nums2` ，其中`nums1` 是 `nums2` 的子集。找到 `nums1` 中每个元素在 `nums2` 中的下一个比其大的值。

`nums1` 中数字 **x** 的下一个更大元素是指 **x** 在 `nums2` 中对应位置的右边的第一个比 **x** 大的元素。如果不存在，对应位置输出-1。

**示例 1:**

```
输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
输出: [-1,3,-1]
解释:
    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
```

**示例 2:**

```
输入: nums1 = [2,4], nums2 = [1,2,3,4].
输出: [3,-1]
解释:
    对于num1中的数字2，第二个数组中的下一个较大数字是3。
    对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
```

**注意:**

1. `nums1`和`nums2`中所有元素是唯一的。
2. `nums1`和`nums2` 的数组大小都不超过1000。

**代码:**

```java
class Solution {
    // 默认初始值
    private static final Integer VALUED_EFAULT = Integer.valueOf(-1);
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> stack = new Stack<Integer>();
        //利用哨兵来去除判空
        stack.push(Integer.MAX_VALUE);
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] arr = new int[nums1.length];
        for(Integer node:nums2){
            while( node > stack.peek()){
                map.put(stack.pop(),node);
            }
             stack.push(node);     
        }

        for(int i = 0;i < nums1.length;i++){
            //获取为空时添加默认值
            arr[i] = map.getOrDefault(nums1[i],VALUED_EFAULT);
        }
        return arr;
        
    }
}
```

