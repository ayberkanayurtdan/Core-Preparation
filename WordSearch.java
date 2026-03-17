public class WordSearch {
    // In-place Backtracking (DFS) - Time Complexity: O(N * M * 3^L) - Space Complexity: O(L)
    public boolean exist(char[][] board, String word) {
        char[] wordArray=word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==wordArray[0]){
                    if(dfs(board,i,j,0,wordArray)) return true;
                }
            }   
        }
        return false; 
    }

    private boolean dfs(char[][] board, int row, int col, int index, char[] word){
        if(index==word.length) return true;
        if(row<0||row>=board.length||col<0||col>=board[0].length||board[row][col]!=word[index]){
            return false;
        }
        char temp=board[row][col];
        board[row][col]='#';

        boolean found=dfs(board,row+1,col,index+1,word) || dfs(board,row-1,col,index+1,word) || dfs(board,row,col+1,index+1,word) || dfs(board,row,col-1,index+1,word);
        board[row][col]=temp;
        return found;
    }
}
