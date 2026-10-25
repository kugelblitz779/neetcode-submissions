class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<tokens.length; i++){
            String curr = tokens[i];
            if(isSingleCharOperator(curr)){

                int op2 = st.pop();
                int op1 = st.pop();

                int res = performOperation(curr.charAt(0), op1, op2);
                st.push(res);
            }else{
                //push into stack
                st.push(Integer.parseInt(curr));
            }
        }
        
        return st.pop();
    }

    public int performOperation(char operator, int op1, int op2){

        if(operator == '+'){
            return op1 + op2;
        }else if(operator == '-'){
            return op1 - op2;
        }else if(operator == '*'){
            return op1 * op2;
        }else{
            return op1/op2;
        }

    }

    public boolean isSingleCharOperator(String s){
        if (s == null || s.length() != 1) {
            return false;
        }
        
        return switch (s.charAt(0)) {
            case '+', '-', '*', '/', '%', '=', '^' -> true;
            default -> false;
        };
    }
}
