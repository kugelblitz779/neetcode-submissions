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

        List<Integer> res = new ArrayList<>();
        while(!st.isEmpty()){
            res.add(st.pop());
        }
        
        Collections.reverse(res);

        int[] res1 = new int[res.size()];
        int k = 0;
        for(int i=0; i<res.size(); i++){
            res1[k++] = res.get(i);
        }

        return res1;
    }

    public boolean isTowardsEachOther(int x, int y){
        if((y > 0 && x < 0)) return true;
        return false;
    }
}