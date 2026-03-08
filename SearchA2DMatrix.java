public class SearchA2DMatrix {
    //Binary Search (Optimal) - Time Complexity: O(log(m*n)) - Space Complexity: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int total= matrix.length*matrix[0].length;
        int left=0,right=total-1;
        int columnLength=matrix[0].length;
        while(left<=right){
            int middle= left+(right-left)/2;
            int row= middle/columnLength;
            int column= middle%columnLength;

            if(matrix[row][column]==target){
                return true;
            }else if(matrix[row][column]<target){
                left=middle+1;
            }else{
                right=middle-1;
            }
        }
        return false;
    }
    //Nested Loops (Brute Force) - Time Complexity: O(m*n) - Space Complexity: O(1)
    public boolean searchMatrixBruteForce(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==target) return true;
            }
        }
        return false;
    }
}
