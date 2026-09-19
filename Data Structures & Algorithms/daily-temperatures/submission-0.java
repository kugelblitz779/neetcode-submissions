class Solution {
    public int[] dailyTemperatures(int[] temp) {

        int n = temp.length;
        int[] res = new int[n];
        res[n-1] = 0;

        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && temp[st.peek()] <= temp[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                res[i] = temp[st.peek()] > temp[i] ? st.peek() - i : 0;
            }
            st.push(i);
        }

        return res;
    }
}
