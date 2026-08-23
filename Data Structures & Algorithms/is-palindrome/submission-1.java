class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder("");

        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            }
        }

        String sb_str = sb.toString();
        String snew = sb_str.toLowerCase();
        return check(snew);
    }

    public boolean check(String s){
        int i=0;
        int n = s.length();

        while(i < n/2){
            if(s.charAt(i) != s.charAt(n-i-1))
                return false;

            i++;
        }

        return true;
    }
}
