/**
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/submissions/
 */
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        
        // 1. 边界条件处理
        if(A.length <=1){
            return A;
        }
        
        // 2. 分别定义两个索引，一个找奇数位，一个找偶数位
        //  这个地方容易陷入左右索引的思维定式。
        // 突破点就是，奇数位放奇数，偶数位放偶数，只要每次找到两个都错位的节点，然后进行交换就可以了。
        int even = 0;
        int odd = 1;
        
        // 3. 移动数据
        while(even<A.length && odd<A.length){
            if(!isMatch(even,A[even]) && !isMatch(odd,A[odd])){
                // System.out.println("测试，交换。A.left="+A[left] +"  A.right="+A[right]);
                int tmp = A[even];
                A[even] = A[odd];
                A[odd] = tmp;
                odd+=2;
                even+=2;
            }else{
                if(isMatch(even,A[even])){
                    even+=2;
                }
                if(isMatch(odd,A[odd])){
                    odd+=2;
                }
            }
        }
        return A;
    }
    
    // 都是偶数，或者都是奇数
    boolean isMatch(int index,int value){
        return (index%2==0 && value%2==0) || (index%2!=0 && value%2!=0);
    }
}
