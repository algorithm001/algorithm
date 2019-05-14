class Solution {
    public String longestWord(String[] words) {
        //给定字符串数组，找出包含最长的字符串（包含其他单词的字母），如果存在相同长度，取字母排序小的
        //思路：对数组排序，再利用Set对字母存储，小的单词一定包含在后面大的单词里面。后面只需要取前缀相同的
        
        Set<String> set=new HashSet<String>();
        for(int i=0;i<words.length;i++){
            set.add(words[i]);
        }
        int length=0;
        String word="";
        for(int i=0;i<words.length;i++){
            if(words[i].length()>length||(words[i].length()==length&&words[i].compareTo(word)<0)){
                //如果存在相同长度的字符串，取字母排序较小的
                int len=words[i].length();
                while(len>0&&set.contains(words[i].substring(0,len))){
                    //求相同的部分
                    len--;
                }
                if(len==0){
                    //说明该单词的所有字符串均为公共字母,将其标记为匹配串
                    length=words[i].length();
                    word=words[i];
                }
            }
        }
        return word;
    }
}
