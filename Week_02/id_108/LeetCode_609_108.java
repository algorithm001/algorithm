import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/04/28
 */
public class LeetCode_609_108 {
    class Solution {
        public  List<List<String>> findDuplicate(String[] paths) {
            HashMap<String,List<String>> contextIndexMap = new HashMap<>();
            List<List<String>> duplicatePaths = new LinkedList<>();
            for (String path : paths) {
                HashMap<String, List<String>> subContextIndexMap = contentIndex(path);
                for (Map.Entry<String, List<String>> entry : subContextIndexMap.entrySet()) {
                    String key = entry.getKey();
                    List<String> value = entry.getValue();
                    List<String> addrs = contextIndexMap.get(key);
                    if(!contextIndexMap.keySet().contains(key)){
                        addrs = new LinkedList<>();
                    }
                    addrs.addAll(value);
                    contextIndexMap.put(key, addrs);
                }
            }

            for (Map.Entry<String, List<String>> entry : contextIndexMap.entrySet()) {
                if(entry.getValue().size()>1){
                    duplicatePaths.add(entry.getValue());
                }
            }
            return duplicatePaths;
        }

        private  HashMap<String,List<String>> contentIndex(String value){
            HashMap<String,List<String>> map = new HashMap<>();
            String[] fileDir = value.split("\\s");
            for (int i = 1; i < fileDir.length; i++) {
                String text = fileDir[i];
                String content = text.substring(text.indexOf("(") + 1,text.indexOf(")"));
                String fileAddr = fileDir[0] + "/" + text.substring(0,text.indexOf("("));
                List<String> addrs = map.get(content);
                if(!map.containsKey(content)){
                    addrs = new LinkedList<>();
                }
                addrs.add(fileAddr);
                map.put(content,addrs);
            }
            return map;
        }
    }
}
