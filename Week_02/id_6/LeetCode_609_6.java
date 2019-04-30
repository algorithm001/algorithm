

    // LeetCode 609
	
    // 文件内容作为key，路径做val，建立hash表。最后变量hash表
    public List<List<String>> findDuplicate1(String[] paths) {

        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();

        // 遍历数组，解析字符串。格式："root/a 1.txt(abcd) 2.txt(efgh)"
        for (String ps : paths){
            String[] all = ps.split(" ");

            int len = all.length;
            String path = all[0];
            String file = "";
            String data = "";
            // 可能是多个文件
            for (int i = 1; i < len; i++) {
                String[] s = all[i].split("\\(");
                file = s[0];
                data = s[1].substring(0, s[1].length()-1);
                // key=文件内容   val=[path+/+file]
                if (!map.containsKey(data)){
                    List<String> ls = new ArrayList<>();
                    ls.add(path+"/"+file);
                    map.put(data, ls);
                }else {
                    List<String> ls = map.get(data);
                    ls.add(path+"/"+file);
                    map.put(data, ls);
                }
            }
        }

        // 遍历hash表，把路径方式List
        map.forEach((k, v)->{
            // 相同内容的文件至少要大于1个才进list
            if (v.size() > 1){
                list.add(v);
            }

        });

        return list;
    }

    