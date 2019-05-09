public class Solution {


	public int findJudge(int N, int[][] trust) {

		//N=1的特殊场景
		if(null == trust || trust.length == 0)
		{
			if(1==N) return 1;
		}

		Map<Integer, Integer> xMap = new HashMap<>();
		Map<Integer, Integer> yMap = new HashMap<>();

		for (int i = 0; i < trust.length; i++) {
			if (xMap.containsKey(trust[i][0])) {
				xMap.put(trust[i][0], xMap.get(trust[i][0]) + 1);
			} else {
				xMap.put(trust[i][0], 1);
			}

			if (yMap.containsKey(trust[i][1])) {
				yMap.put(trust[i][1], yMap.get(trust[i][1]) + 1);
			} else {
				yMap.put(trust[i][1], 1);
			}
		}

		//统计被出自己外全部人信任的人的个数
		int key = -1;
		int num = 0;
		for (Integer y : yMap.keySet()) {
			if (yMap.get(y) == N - 1) {
				key = y;
				num++;
			}
		}

		//仅有一个被其他人全部信任且这个人不信任任何人
		if (num == 1 && xMap.get(key) == null)
			return key;
		else
			return -1;
	}

	public static void main(String[] args) {
		int[][] trust5 = { };

		System.out.println(new Solution().findJudge(1, trust5));

		int[][] trust = { { 1, 2 } };

		System.out.println(new Solution().findJudge(2, trust));

		int[][] trust1 = { { 1, 3 },{ 2, 3 } };

		System.out.println(new Solution().findJudge(3, trust1));

		int[][] trust2 = { { 1, 3 },{ 2, 3 },{ 3, 1 } };

		System.out.println(new Solution().findJudge(3, trust2));

		int[][] trust3 = { { 1, 2 } ,{ 2, 3 }};

		System.out.println(new Solution().findJudge(3, trust3));

		int[][] trust4 = {{1,3},{1,4},{2,3},{2,4},{4,3}};

		System.out.println(new Solution().findJudge(4, trust4));

	}

}
