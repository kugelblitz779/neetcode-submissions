class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> st = new Stack<>();
        int n = s.length();

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                st.push(c);
            }else{

                if(!st.isEmpty() && (st.peek() == map.get(c))){
                    st.pop();
                }else{
                    st.push(c);
                }
            }
        }

        return st.isEmpty();
    }
}
