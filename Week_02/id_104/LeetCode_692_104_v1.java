class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //思路 
        //1.遍历单词 统计每个单词出现的数量
        Map<String,Integer> wordsMap=new HashMap<String,Integer>();
        int num=0;
        for(String word:words){
            if(wordsMap.containsKey(word)){
                int c=wordsMap.get(word)+1;
                num=num>c?num:c;
                wordsMap.put(word,c);
            }else{
                wordsMap.put(word,1);
            }
        }
        num=num+1;
        //2.按数量进行排序
        String[] wordsArray=new String[num];
        // for(int i=0;i<num;i++){
        //     wordsArray[i]="";
        // }
        for(Map.Entry<String,Integer> entry:wordsMap.entrySet()){
           String word=entry.getKey();
           int count = entry.getValue();
           if(wordsArray[count]==null){
               wordsArray[count]=word;
           } else{
               //3.数量相同的 按名称排序 
               String oldWord=wordsArray[count];
               //如果当前单词字母更靠前一些 则替换旧值
               if(word.compareTo(oldWord)<0){
                   //替换 
                   wordsArray[count]=word;
               }
           }
        }
       
        //4.遍历排序后的集合，取第n个 
        int  j=0;
        String result="";
        for(int i=num-1;i>=0;i--){
            if(!"".equals(wordsArray[i])){
                j++;
            }
            if(j==k){
                result=wordsArray[i];
                break;
            }
        }
        List resultList=new ArrayList();
        resultList.add(result);
        return resultList;
    }
}