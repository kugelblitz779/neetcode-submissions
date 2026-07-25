class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        
        int top = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length-1;
        int left = 0;

        while(top <= bottom && left <= right){
            //traverse top row
            if(left <= right && top <= matrix.length-1){
                for(int i=left; i<=right; i++){
                    list.add(matrix[top][i]);
                }
                top++;
            }

            //traverse right column
            if(top <= bottom && left <= right){
                for(int i=top; i<=bottom; i++){
                    list.add(matrix[i][right]);
                }
                right--;
            }

            //traverse bottom row
            if(left <= right && top <= bottom){
                for(int i=right; i>=left; i--){
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //traverse left column
            if(top <= bottom && left <= right){
                for(int i=bottom; i>=top; i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        return list;
    }
}
