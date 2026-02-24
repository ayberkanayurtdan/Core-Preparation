import java.util.HashSet;       //All of O(n)=1 because we know that that rule board 9x9 and numbers 1-9
                                //I have given these O(n) values ​​assuming that we do not know the dimensions and numbers.
public class ValidSudoku {
    //Boolean Matrices (Highly Optimal) - Time Complexity: O(N^2) - Space Complexity: O(N^2)
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows=new boolean[9][10];
        boolean[][] columns=new boolean[9][10];
        boolean[][] blocks=new boolean[9][10];

        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if(board[r][c]=='.') continue;

                int num= Character.getNumericValue(board[r][c]);
                int blockIndex= (r/3)*3+(c/3);

                if(rows[r][num] || columns[c][num] || blocks[blockIndex][num]){
                    return false;
                }

                rows[r][num] = columns[c][num] = blocks[blockIndex][num] = true;
            }
        }
        return true;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})    //Not defined HashSet's type <>, this is for suppress warnings

    //Single Pass with HashSets (Optimal)- Time Complexity: O(N^2) - Space Complexity: O(N^2)
    public boolean isValidSudokuWithHashSets(char[][] board) {
        HashSet[] rows= new HashSet[9];
        HashSet[] columns= new HashSet[9]; 
        HashSet[] blocks= new HashSet[9]; 

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                rows[i] = new HashSet<>();
                columns[i] = new HashSet<>();
                blocks[i] = new HashSet<>();
            }
        }

        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                int blockIndex= (r/3)*3+(c/3);
                if(board[r][c]=='.') continue;

                if(!rows[r].add(board[r][c])|| !columns[c].add(board[r][c])|| !blocks[blockIndex].add(board[r][c])){
                    return false;
                }
            }
        }
        return true;
    }
    //Multi-Pass (Brute Force)(Might Optimal small sizes) - Time Complexity: O(N^2) - Space Complexity: O(N)
    public boolean isValidSudokuBruteForce(char[][] board) {
        HashSet<Character> checker= new HashSet<>();
        
        for(int i=0;i<9;i++){
            checker.clear();
            for(int j=0;j<9;j++){
                if(board[i][j]!='.' && !checker.add(board[i][j])){
                    return false;
                }
            }
        }

        for(int j=0;j<9;j++){
            checker.clear();
            for(int i=0;i<9;i++){
                if(board[i][j] !='.' && !checker.add(board[i][j])){
                    return false;
                }
            }
        }

        for(int rowOffset=0;rowOffset<9;rowOffset+=3){
            for(int columnOffset=0;columnOffset<9;columnOffset+=3){
                checker.clear();
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        if(board[i+rowOffset][j+columnOffset]!='.' && !checker.add(board[i+rowOffset][j+columnOffset])){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
}
