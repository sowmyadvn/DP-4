/*
Time: O(MN)
Space: O(MN)
Approach:
=======
1. Observe recurrence relation in the problem
2. If 0, then nothing changes. If 1, then if first row, square of size only 1 can be formed
3. If other rows and columns, then minimum of diagonal, top and left max square values + 1 would be size of 
square that can be formed
4. Update these values in auxilliary matrix, so that length can be found. Square area would be len*len
*/
// ==================== Using [m+1][n+1] auxilliary matrix ========================
class Solution {
    public int maximalSquare(char[][] matrix) {
        //edge cases
        if(matrix == null || matrix.length == 0) return 0;
        
        int m = matrix.length, n = matrix[0].length; 
        int maxLen = 0; 
        int[][] maxSquare = new int[m+1][n+1];
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <=n; j++) {
                if(matrix[i-1][j-1] == '1') {
                    // possible square that can be formed is of length - minimum of lengths of upper row, previous column and diagonal left values
                    maxSquare[i][j] = Math.min(Math.min(maxSquare[i-1][j-1], maxSquare[i-1][j]), maxSquare[i][j-1]) + 1;
                    // check if maxLen of square that can be formed is updated
                    maxLen = Math.max(maxLen, maxSquare[i][j]);
                 }
            }
        }
        
        return maxLen*maxLen;
    }
}

// ==================== Using [m][n] auxilliary matrix ========================

class Solution {
    public int maximalSquare(char[][] matrix) {
        //edge cases
        if(matrix == null || matrix.length == 0) return 0;
        
        int m = matrix.length, n = matrix[0].length; 
        int maxLen = 0; 
        int[][] maxSquare = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == '1') {
                maxSquare[i][0] = 1;
                maxLen = 1;
            }
        }
        
         for(int i = 0; i < n; i++) {
            if(matrix[0][i] == '1') {
                maxSquare[0][i] = 1;
                maxLen  = 1;
            }
        }
        
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j <n; j++) {
                if(matrix[i][j] == '1') {
                    // possible square that can be formed is of length - minimum of lengths of upper row, previous column and diagonal left values
                    maxSquare[i][j] = Math.min(Math.min(maxSquare[i-1][j-1], maxSquare[i-1][j]), maxSquare[i][j-1]) + 1;
                    // check if maxLen of square that can be formed is updated
                    maxLen = Math.max(maxLen, maxSquare[i][j]);
                 }
            }
        }
        
        return maxLen*maxLen;
    }
}