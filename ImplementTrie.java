class Trie {
    Trie[] children;
    boolean isEndOfWord;
    public Trie() {
        children= new Trie[26];
        isEndOfWord=false;
    }
    
    public void insert(String word) {
        Trie curr=this;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(curr.children[index]==null) curr.children[index]=new Trie();
            curr=curr.children[index];
        }
        curr.isEndOfWord=true;
    }
    
    public boolean search(String word) {
        Trie curr=this;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(curr.children[index]==null) return false;
            curr=curr.children[index];
        }
        return curr.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        Trie curr=this;
        for(char c:prefix.toCharArray()){
            int index=c-'a';
            if(curr.children[index]==null) return false;
            curr = curr.children[index];
        }
        return true;
    }
}