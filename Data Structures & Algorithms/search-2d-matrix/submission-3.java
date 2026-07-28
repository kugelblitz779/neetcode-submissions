class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        int lo = 0;
        int hi = n-1;
        int upperBoundRow = -1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            if(matrix[mid][0] > target){
                upperBoundRow = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }

        if(upperBoundRow != -1){

            int row = upperBoundRow-1;
            return binary_search(row, matrix, target);

        }

        return binary_search(n - 1, matrix, target);
    }

    public boolean binary_search(int rowIdx, int[][] matrix, int target){
        if(rowIdx < 0) return false;
        int hi = matrix[0].length-1;
        int lo = 0;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            if(matrix[rowIdx][mid] == target){
                return true;
            }else if(matrix[rowIdx][mid] < target){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }

        return false;
    }
}
