import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeetCode_373_85 {
}

/**
 * @Package:
 * @ClassName: FindKPairsWithSmallestSums
 * @Description: 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 * **************定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 * **************找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 * @leetcodeurl: https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
 * @Author: wangzhao
 * @Date: 2019-05-05 18:08:49
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class FindKPairsWithSmallestSums{
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<int[]> list = new ArrayList<>();
        if (nums1==null||nums1.length==0||nums2==null||nums2.length==0){
            return list;
        }


        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int[] arr = new int[2];
                arr[0]=nums1[i];
                arr[1]=nums2[j];
                list.add(arr);
            }
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int r1 = o1[0]+o1[1];
                int r2 = o2[0]+o2[1];
                return r1-r2;
            }
        });

        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (i<list.size())
            res.add(list.get(i));
        }

        return res;
    }

    public static void main(String[] args) {

        int[] num1 = {1,7,11};
        int[] num2 = {2,4,6};
        int k =3;
        List<int[]> res = new FindKPairsWithSmallestSums().kSmallestPairs(num1,num2,k);

        res.stream().forEach(o->{
            System.out.println("["+o[0]+","+o[1]+"]");
        });
    }
}
