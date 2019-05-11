// https://leetcode-cn.com/problems/longest-word-in-dictionary/
// 720.词典中最长的单词
// 解题思路：构建Trie树，对每个单词的末尾做标记；然后扫描Trie树，找出最长单词
// - 为了快速计算单词，对Trie树做个小小的变形，每个节点存储的不是一个字符，而是到当前节点为止的字串
// - 这样，可以使用层次遍历，找出最长单词
// - 若出现多个最长单词，第一个遇到的就是字典序最前的

class Solution {
    
    // 定义一个内部类
    class TrieNode{
        String data;// 以当前字符结尾的字符串
        boolean isEndingChar;// 用来标识当前节点是否为某个单词的终点。
        TrieNode[] children;
        TrieNode(String data){
            this.data = data;
            this.children = new TrieNode[26];
        }
    }
    
    // 向Trie树中插入一个单词
    void insertToTrie(TrieNode root,String word){
        TrieNode tmp = root;
        
        // 遍历单词的每一个字符
        for(int i=0;i<word.length();i++){
            // 取字符，并计算索引
            char c = word.charAt(i);
            int index = c-'a';
            String data = word.substring(0,i+1);
            // 查看当前根节点对应索引位置是否为null，若为null，则new 一个新节点，插入
            if(tmp.children[index] == null){
                TrieNode newNode = new TrieNode(data);
                tmp.children[index] = newNode;
            }
            tmp = tmp.children[index];
        }
        // 最后一个单词，标记
        tmp.isEndingChar = true;        
    }
    
    // 构建 Trie 树
    void buildTrie(TrieNode root,String[] words){
        for(int i=0;i<words.length;i++){
            insertToTrie(root,words[i]);
        }
    }
    
    
  
    
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode("");
        buildTrie(root,words);
        
        String longestWord = "";
        Queue<TrieNode> queue = new LinkedList<TrieNode>();
        
        // 先遍历第一层子节点，初始化Queue。
        for(int i=0;i<26;i++){
            if(root.children[i]!=null && root.children[i].isEndingChar==true){
                queue.offer(root.children[i]);
                if(longestWord.length() < root.children[i].data.length()){
                    longestWord = root.children[i].data;
                }
            }
        }
        
        // 层次遍历，每次从队列中取出一个节点来，向下遍历
        while(queue.size()!=0){
            TrieNode node = queue.poll();
            for(int i=0;i<26;i++){
                if(node.children[i]!=null && node.children[i].isEndingChar==true){
                    queue.offer(node.children[i]);
                    if(longestWord.length() < node.children[i].data.length()){
                        longestWord = node.children[i].data;
                    }
                }
            }
        }
        
        return longestWord;
    }

}
