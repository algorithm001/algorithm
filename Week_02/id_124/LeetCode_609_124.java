import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 *
 * 假设您有一个真正的文件系统，您将如何搜索文件？广度搜索还是宽度搜索？
 *  广度优先
 * 如果文件内容非常大（GB级别），您将如何修改您的解决方案？
 *   预处理，生成倒排索引
 * 如果每次只能读取 1 kb 的文件，您将如何修改解决方案？
 * 修改后的解决方案的时间复杂度是多少？其中最耗时的部分和消耗内存的部分是什么？如何优化？
 *
 */
public class FindDuplicateFile {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> contentMap = new HashMap<>();
        for (String path : paths) {
            String[] fa = path.split(" ");
            String dir = fa[0];
            for (int i = 1; i < fa.length; i++) {
                String content = fa[i].substring(fa[i].indexOf(".txt(") + 5, fa[i].length() - 1);
                List<String> temp = contentMap.getOrDefault(content, new ArrayList<>());
                temp.add(dir + "/" + fa[i].substring(0, fa[i].indexOf(".txt")+4));
                contentMap.put(content, temp);

            }
        }
        for (List item : contentMap.values()){
            if(item.size() > 1){
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] paths = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        System.out.println(new FindDuplicateFile().findDuplicate(paths));
    }

}
