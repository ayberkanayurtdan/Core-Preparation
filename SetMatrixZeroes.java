public class SetMatrixZeroes {
    //In-Place Method (Most Optimal) - Time Complexity: O(M*N) - Space Complexity: O(1) - In-place using first row/column as markers.
    public void setZeroes(int[][] matrix) {
        int r= matrix.length;
        int c= matrix[0].length;

        boolean rowHasZero=false;
        boolean colHasZero=false;

        for(int i=0;i<r;i++){
            if(matrix[i][0]==0){
                colHasZero=true;
            }
        }
        for(int j=0;j<c;j++){
            if(matrix[0][j]==0){
                rowHasZero=true;
            }
        }
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(rowHasZero){
            for(int j=0;j<c;j++){
                matrix[0][j]=0;
            }
        }
        if(colHasZero){
            for(int i=0;i<r;i++){
                matrix[i][0]=0;
            }
        }
    }
    // Boolean Matrix - Time Complexity: O(M*N) - Space Complexity: O(M*N) - Create 2 new boolean matrixes for row and column.
    public void setZeroesWithBooleanMatrix(int[][] matrix) {
        int r= matrix.length;
        int c= matrix[0].length;
        boolean[] rowHasZero= new boolean[r];
        boolean[] columnHasZero= new boolean[c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==0){
                    rowHasZero[i]=true;
                    columnHasZero[j]=true;
                }                
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(rowHasZero[i]==true || columnHasZero[j]==true){
                    matrix[i][j]=0;
                }
            }
        }
    }
    
}
