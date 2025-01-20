class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = (m*n) - 1;
        while(low <= high){
            int mid = low + ((high - low)/2);
            int row = mid/n;
            int col = mid%n;
            if(target == matrix[row][col]){
                return true;
            }else if(target<matrix[row][col]){
                high = mid - 1;
            }else if(target>matrix[row][col]){
                low = mid + 1;
            }
        }
        return false;
    }
}