class TrieNode{
    public char data;
    public boolean isword = false;
    public TrieNode[] next = new TrieNode[26];
    public TrieNode(char c){
        data = c;
    }
}

class Trie{
    TrieNode root = new TrieNode('/');
    
    public void insert(String string){
        char[] ccc = string.toCharArray();
        TrieNode p = root;
        for(int i=0; i<ccc.length; i++){
            if(p.next[char[i]-'a'] == null){
                TrieNode trienode = new TrieNode(char[i]);
                p.next[char[i]-'a'] = trienode;
            }
            p = p.next[char[i]-'a'];
        }
        p.isword = true;
    }
}

class Solution {
    public String longestWord(String[] words) {
        
    }
}
