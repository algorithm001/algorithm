package com.fanlu.leetcode.hashtable;
// Source : https://leetcode.com/problems/find-duplicate-file-in-system/
// Id     : 609
// Author : Fanlu Hai
// Date   : 2018-04-23
// Other  :
// Tips   :

import java.util.*;

/**
 * Input:
 * ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
 * Output:
 * [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 */

public class FindDuplicateFileInSystem {
    Map<String, ArrayList<String>> map = new HashMap<>();

    //75.63% 20.59%
    public List<List<String>> findDuplicateOriginal(String[] paths) {
        for (String s : paths) {
            getContentMapFromPath(s);
        }
        //! below codes cause concurrent modification exception, use iterator instead
//        for(String key : map.keySet()){
//            if (map.get(key).size()==1)
//                map.remove(key);
//        }
        Iterator<Map.Entry<String, ArrayList<String>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ArrayList<String>> entry = iterator.next();
            if (entry.getValue().size() == 1) {
                iterator.remove();
            }
        }
        return new ArrayList<List<String>>(map.values());
    }

    public void getContentMapFromPath(String path) {
        String[] tmp = path.split(" ");
        String prefix = tmp[0] + "/";
        for (int i = 1; i < tmp.length; i++) {
            String[] foo = tmp[i].split("\\(");
            // use content value as key, an arrayList of paths as value.
            String key = foo[1].substring(0, foo[1].length() - 1);
            ArrayList<String> value = map.getOrDefault(key, new ArrayList<String>());
            value.add(prefix + foo[0]);
            map.put(key, value);
        }
    }


    //63.86% 76.47%
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, Set<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] tmp = path.split(" ");

            for (int i = 1; i < tmp.length; i++) {
                String[] foo = tmp[i].split("\\(");
                // use content value as key, an arrayList of paths as value.
                String key = foo[1].substring(0, foo[1].length() - 1);
                Set<String> value = map.getOrDefault(key, new HashSet<String>());
                value.add(tmp[0] + "/" + foo[0]);
                map.put(key, value);
            }
        }

        List<List<String>> result = new ArrayList<List<String>>();
        for (Set<String> list : map.values()) {
            if (list.size() != 1)
                result.add(new ArrayList<>(list));
        }

        return result;
    }
}
