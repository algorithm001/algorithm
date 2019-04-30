class LeetCode_609_95 {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList(200);
        HashMap<String,List<String>>map = new HashMap(500);
        for(String path:paths)
        {
            String[] temp = path.split(" ");
            String root = temp[0];
            for(int i = 1;i < temp.length;i++)
            {
                int begin = temp[i].indexOf("(");
                int end = temp[i].lastIndexOf(")");
                String name = temp[i].substring(begin+1,end);
                
                String s = root+"/"+temp[i].substring(0,begin);
                if(map.get(name) == null)
                {
                    List<String> list = new ArrayList(10);
                    list.add(s);
                    map.put(name,list);
                }
                else map.get(name).add(s);
            }
        }
        for(Map.Entry<String,List<String> > entry:map.entrySet())
            if(entry.getValue().size()>1)
            ans.add(entry.getValue());
        
        return ans;
    }
}

