class Solution {
    public int maxArea(int[] heights) {
        
        int n = heights.length;
        int start = 0;
        int end = n-1;
        int area = 0;
        int maxArea = 0;
        while(start <= end){
            int l = end-start;
            int h = Math.min(heights[start], heights[end]);
            // System.out.println("Area: " + l*h);
            maxArea = Math.max(maxArea, l*h);
            if(heights[start] < heights[end]){
                start++;
            }else{
                end--;
            }
        }
        return maxArea;
    }
}
