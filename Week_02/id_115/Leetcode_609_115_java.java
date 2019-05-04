package data.leetcode.hash;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode609 {
    /**
     * 给定一个目录信息列表，包括目录路径，以及该目录中的所有包含内容的文件，您需要找到文件系统中的所有重复文件组的路径。
     * 一组重复的文件至少包括二个具有完全相同内容的文件。
     * <p>
     * 输入列表中的单个目录信息字符串的格式如下：
     * <p>
     * "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
     * <p>
     * 这意味着有 n 个文件（f1.txt, f2.txt ... fn.txt 的内容分别是 f1_content, f2_content ... fn_content）在目录 root/d1/d2/.../dm 下。注意：n>=1 且 m>=0。如果 m=0，则表示该目录是根目录。
     * <p>
     * 该输出是重复文件路径组的列表。对于每个组，它包含具有相同内容的文件的所有文件路径。文件路径是具有下列格式的字符串：
     * <p>
     * "directory_path/file_name.txt"
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
     * 输出：
     * [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
     *
     * @param paths
     * @return 最终输出不需要顺序。
     * 您可以假设目录名、文件名和文件内容只有字母和数字，并且文件内容的长度在 [1，50] 的范围内。
     * 给定的文件数量在 [1，20000] 个范围内。
     * 您可以假设在同一目录中没有任何文件或目录共享相同的名称。
     * 您可以假设每个给定的目录信息代表一个唯一的目录。目录路径和文件信息用一个空格分隔。
     */

    /**
     * 执行用时 : 61 ms, 在Find Duplicate File in System的Java提交中击败了73.58% 的用户
     * 内存消耗 : 75 MB, 在Find Duplicate File in System的Java提交中击败了6.90% 的用户
     * @param paths
     * @return
     */
    public static List<List<String>> findDuplicate(String[] paths) {

        HashMap<String, List<String>> contentMap = new HashMap<>();
        for (int i = 0; i < paths.length; i++) {
            String[] split = paths[i].split(" ");
            for (int j = 1; j < split.length; j++) {
                int contentStartSplit = split[j].indexOf("(");
                String newPath = split[0]+"/" +split[j].substring(0,contentStartSplit).trim();
                String content = split[j].substring(contentStartSplit+1, split[j].length()-1);
                List<String> contentList = contentMap.get(content);
                if (contentList == null) {
                    contentList = new ArrayList<>();
                    contentMap.put(content, contentList);
                }
                contentList.add(newPath);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : contentMap.entrySet()) {
            if(entry.getValue().size()>1){
                result.add(entry.getValue());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] path = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        List<List<String>> duplicate = findDuplicate(path);
    }
}
