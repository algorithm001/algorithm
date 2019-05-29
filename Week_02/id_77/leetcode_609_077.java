class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<String, List<String>>(161);
        int start,end;
        String content,pathT;
        for (String path : paths) {
            String[] pathArr = path.split(" ");
            String dir = pathArr[0];
            for (int i = 1; i < pathArr.length; i++) {
                start = pathArr[i].indexOf("(");
                end = pathArr[i].indexOf(")");
                content = pathArr[i].substring(start + 1, end);
                pathT = dir + "/" + pathArr[i].substring(0, start);
                if (map.containsKey(content)) {
                    map.get(content).add(pathT);
                } else {
                    List<String> lp = new ArrayList<String>();
                    lp.add(pathT);
                    map.put(content, lp);
                }     

            }
        }
        List<List<String>> res  = new ArrayList<List<String>>();
        for (List<String> ll:map.values()) {
            if(ll.size()>1){
                res.add(ll);
            }
            
        }
        return res;
        
    }
}