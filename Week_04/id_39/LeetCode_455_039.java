/**
 * @author Paula
 *
 */
package com.paula.algorithmsAndDataStructure.greedyAlgorithm;

import java.util.Arrays;
/**
 * 分饼干
 * @author Paula
 *
 */
public class LeetCode_455_039{
	/**
	 * 
	 * @param g 小孩的胃口
	 * @param s 饼干的大小尺寸
	 * @return
	 */
	public int findContentChildren(int[] g, int[] s) {
		if(null == g || null == s || g.length <= 0 || s.length <=0) return 0;

		Arrays.sort(g);
		Arrays.sort(s);
		int count = 0;
		
		for(int i=0, j=0; i<g.length && j<s.length; i++) {
			while (j < s.length && g[i] > s[j]) {
				++j;
			}
			if(j == s.length) break;
			++count;
		    ++j;
		}
		return count;
	}
	
	public static void main(String[] args) {
		LeetCode_455_039 l = new LeetCode_455_039();
		
		int[] g1 = {5,10,2,9,15};
		int[] s1 = {6,1,20,3,8};
		System.out.println("g1 = " + Arrays.toString(g1) + ", s1 = " + Arrays.toString(s1) + ", findContentChildren = " + l.findContentChildren(g1, s1));//3
		
		int[] g2 = {1,2,3};
		int[] s2 = {1,1};
		System.out.println("g2 = " + Arrays.toString(g2) + ", s2 = " + Arrays.toString(s2) + ", findContentChildren = " + l.findContentChildren(g2, s2));//1
		
		int[] g3 = {1,2};
		int[] s3 = {1,2,3};
		System.out.println("g3 = " + Arrays.toString(g3) + ", s3 = " + Arrays.toString(s3) + ", findContentChildren = " + l.findContentChildren(g3, s3));//2
		
	}
}