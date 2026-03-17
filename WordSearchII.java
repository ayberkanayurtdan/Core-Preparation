import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    // Trie-Node Traversal with StringBuilder Backtracking - Time Complexity: O(M * N * 3^L) - Space Complexity: O(Total_Words_Chars + L)
    public List<String> findWords(char[][] board, String[] words) {
        Trie root= new Trie();
        for(String word:words){
            root.insert(word);
        }
        List<String> result=new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,i,j,root,sb,result);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board,int row,int col,Trie trie,StringBuilder sb,List<String> result){
        if(row<0||row>=board.length||col<0||col>=board[0].length||board[row][col]=='#') return;

        char temp=board[row][col];
        int index=temp-'a';
        Trie nextTrie=trie.children[index];
        if(nextTrie==null) return;
        
        sb.append(temp);

        if(nextTrie.isEndOfWord){
            result.add(sb.toString());
            nextTrie.isEndOfWord=false;
        }

        board[row][col] = '#';

        dfs(board, row + 1, col, nextTrie, sb, result);
        dfs(board, row - 1, col, nextTrie, sb, result);
        dfs(board, row, col + 1, nextTrie, sb, result);
        dfs(board, row, col - 1, nextTrie, sb, result);
        board[row][col] = temp;
        sb.deleteCharAt(sb.length()-1);
    }
    /*private static class Trie {
        Trie[] children;
        boolean isEndOfWord;

        public Trie() {
            children = new Trie[26];
            isEndOfWord = false;
        }

        public void insert(String word) {
            Trie curr = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (curr.children[index] == null) curr.children[index] = new Trie();
                curr = curr.children[index];
            }
            curr.isEndOfWord = true;
        }

        public boolean search(String word) {
            Trie curr = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (curr.children[index] == null) return false;
                curr = curr.children[index];
            }
            return curr.isEndOfWord;
        }

        public boolean startsWith(String prefix) {
            Trie curr = this;
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                if (curr.children[index] == null) return false;
                curr = curr.children[index];
            }
            return true;
        }
    }*/
}
