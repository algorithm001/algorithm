public class Trie {

    Node[] children;

    Trie(){
        children=new Node[26];
    }

    void insert(String word){
        if (word==null || word.length()==0){
            return;
        }

        insert(0,word.toCharArray(),children);
    }

    private void insert(int index, char[] chars, Node[] children) {
        int i=chars[index]-'a';
        if (children[i]==null){
            children[i]=new Node(chars[index]);
        }
        if (index==chars.length-1){
            children[i].end=true;
            return;
        }
        if (children[i].children==null){
            children[i].children=new Node[26];
        }
        insert(index+1,chars,children[i].children);
    }
}
