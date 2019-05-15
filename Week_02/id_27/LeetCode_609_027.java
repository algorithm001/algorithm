package a609;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	/*
	 * 输入： ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)",
	 * "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"] 输出：
	 * [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt",
	 * "root/c/3.txt"]]
	 */

	public List<List<String>> findDuplicate(String[] paths) {
		List<String> fileList = converArr(paths);

		List<List<String>> result = new ArrayList<List<String>>();
		Map<String,List<String>> map = new HashMap<String,List<String>>();

		for(String path:fileList) {
			String content = getContent(path);
			List<String> files = new ArrayList<>();
			if(map.containsKey(content)) {
				files = map.get(content);
			}
			files.add(getFile(path));
			map.put(content, files);
		}

		for(String key:map.keySet()) {
			List<String> files = map.get(key);
			if(files.size()>1) {
				result.add(files);
			}
		}

		return result;
	}

	private static List<String> converArr(String[] paths){
		List<String> result = new ArrayList<>();
		for(String path:paths) {
			String[] tmp = path.split(" ");
			for(int i=1;i<tmp.length;i++)
			{
				result.add(tmp[0]+"/"+tmp[i]);
			}
		}
		return result;
	}

	private static String getContent(String path) {
		int begin = path.indexOf("(");
		int end = path.indexOf(")");
		return path.substring(begin+1, end);
	}

	private static String getFile(String path) {
		int begin = path.indexOf("(");
		return path.substring(0, begin);
	}

	public static void main(String[] args) {
		String[] paths = new String[] {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
		System.out.println(new Solution().findDuplicate(paths));
	}

}
