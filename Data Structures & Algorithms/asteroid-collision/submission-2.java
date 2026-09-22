class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            int x = asteroids[i];

            if(st.isEmpty()){
                st.push(x);
            }else{
                //opposite side asteroids with different size
                while(!st.isEmpty() 
                && isTowardsEachOther(x, st.peek()) 
                && Math.abs(st.peek()) < Math.abs(x)){
                    st.pop();
                }

                //opposite exact same size asteroids
                if(!st.isEmpty() 
                && isTowardsEachOther(x, st.peek()) 
                && Math.abs(st.peek()) == Math.abs(x)){
                    st.pop();
                    continue;
                }

                if(st.isEmpty() || !isTowardsEachOther(x, st.peek()))
                    st.push(x);
            }
        }

        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop(); // Fills from last index down to 0
        }
        return res;
    }

    public boolean isTowardsEachOther(int x, int y){
        if((y > 0 && x < 0)) return true;
        return false;
    }
}