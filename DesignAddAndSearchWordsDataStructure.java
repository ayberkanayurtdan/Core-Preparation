class WordDictionary {
    WordDictionary[] children;
    boolean isEndOfWord;

    public WordDictionary() {
        children=new WordDictionary[26];
        isEndOfWord=false;
    }
    
    public void addWord(String word) {
        WordDictionary curr=this;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(curr.children[index]==null) curr.children[index]=new WordDictionary();
            curr=curr.children[index];
        }
        curr.isEndOfWord=true;        
    }
    
    public boolean search(String word) {
        WordDictionary curr=this;

        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c=='.'){
                for(WordDictionary child:curr.children){
                    if(child!=null&&child.search(word.substring(i+1))) return true;
                }
                return false;
            }else{
                int index=c-'a';
                if(curr.children[index]==null) return false;
                curr=curr.children[index];
            }
        }

        return curr.isEndOfWord;
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */