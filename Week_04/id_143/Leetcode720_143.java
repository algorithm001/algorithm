public class Leetcode720_143 {

    class Solution{
        private String longestword="";

        public String getLongestword(String[] words){
            Trie trie=new Trie();
            for (String word : words) {
                trie.insert(word);
            }

            searchLongestWord(new StringBuilder(),trie.children);
            return longestword;
        }

        private void searchLongestWord(StringBuilder stringBuilder, Node[] children) {
            if (children==null){
               return;
            }
            for (Node node : children) {
                if (node!=null && node.end){
                    stringBuilder.append(node.val);
                    if (stringBuilder.length()>longestword.length()){
                        longestword=stringBuilder.toString();
                    }
                    searchLongestWord(stringBuilder,node.children);
                    stringBuilder.deleteCharAt(stringBuilder.length()-1);
                }
            }
        }
    }
}
