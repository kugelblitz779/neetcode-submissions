class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        int[] nse = findNse(heights);
        int[] pse = findPse(heights);

        int maxArea = 0;
        for(int i=0; i<n; i++){
            nse[i] -= 1;
            pse[i] += 1;
            int area = heights[i]*(nse[i] - pse[i] + 1);
            maxArea = Math.max(maxArea, area);
        }
        // printArr(nse);
        // printArr(pse);

        return maxArea;
    }

    public void printArr(int[] arr){
        for(int x : arr){
            System.out.print(x + ", ");
        }
        System.out.println("");
    }

    public int[] findNse(int[] heights){
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] res = new int[n];
        res[n-1] = n;
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return res;
    }

    public int[] findPse(int[] heights){
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] res = new int[n];
        res[0] = -1;
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }
}
