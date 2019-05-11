class Solution {

	private List<String> result = new ArrayList<>();
	public List<String> letterCasePermutation(String S) {
		findCombination(S.toCharArray(),0,"");
		return result;
	}

	private void findCombination(char[] data,int index,String str) {
		if(index == data.length) {
			result.add(str);
			return;
		}

		Character c = data[index];
		if(Character.isDigit(c)) {
			String str1 = str + c;
			findCombination(data, index+1, str1);
		}
		else {
			String str2 = str + Character.toUpperCase(c);
			findCombination(data, index+1, str2);
			String str3 = str + Character.toLowerCase(c);
			findCombination(data, index+1, str3);
		}

		return;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().letterCasePermutation("a1b2"));
		System.out.println(new Solution().letterCasePermutation("3z4"));
		System.out.println(new Solution().letterCasePermutation("12345"));

	}


}
