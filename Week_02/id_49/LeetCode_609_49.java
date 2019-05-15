package com.v0ex.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find Duplicate File in System
 *
 * @author bugcoder
 */
public class LeetCode_609_49 {

    /**
     * 用哈希表来处理，key就是文件的内容，value就是文件的路径
     * @param paths
     * @return
     */
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] split = path.split(" ");
            String rootPath = split[0]+"/";
            for (int i = 1; i < split.length; i++) {
                String file = split[i];
                String fileName = file.substring(0,file.indexOf("("));
                //拆分字符串获取文件的内容
                String fileContent = file.substring(file.indexOf("(")+1, file.lastIndexOf(")"));
                //获取文件的全部路径
                String filePath = rootPath + fileName;
                if (map.containsKey(fileContent)){
                    List<String> list = map.get(fileContent);
                    list.add(filePath);
                    map.put(fileContent,list);
                }else {
                    List<String> list = new ArrayList<>();
                    list.add(filePath);
                    map.put(fileContent,list);
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String,List<String>> entry : map.entrySet()){
            if (entry.getValue().size()>1){
                result.add(entry.getValue());
            }
        }
        return result;
    }
}
