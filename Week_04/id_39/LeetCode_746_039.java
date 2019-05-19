/**
 * @author Paula
 *
 */
package com.paula.algorithmsAndDataStructure.greedyAlgorithm;

import java.util.Arrays;
/**
 * 使用最小花费爬楼梯
 * @author Paula
 *
 */
public class LeetCode_746_039{
	public int minCostClimbingStairs(int[] cost) {
        int healthCost[]=new int[cost.length+1];//存储爬到某个台阶时所消耗的体力值
        healthCost[0]=0;
        healthCost[1]=0;
        for(int n=2; n<cost.length+1; ++n){
        	healthCost[n]=Math.min(healthCost[n-1]+cost[n-1],healthCost[n-2]+cost[n-2]);
        }
        return healthCost[cost.length]; 
	}

	public static void main(String[] args) {
		LeetCode_746_039 l = new LeetCode_746_039();
		
		int[] cost1 = {10,15,20};
		System.out.println(l.minCostClimbingStairs(cost1));//15
		
		int[] cost2 = {1,100,1,1,1,100,1,1,100,1};
		System.out.println(l.minCostClimbingStairs(cost2));//6
		
	}
}