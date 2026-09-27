class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        char last = chars[0];
        int count = 1;
        int k = 0;
        int len = 0;
        for(int i=1; i<n; i++){
            char curr = chars[i];
            if(curr == last){
                count++;
            }else{
                chars[k++] = last;
                len += 1;
                if(count > 1){
                    char[] charArr = Integer.toString(count).toCharArray();
                    int sz = charArr.length;
                    len += sz;
                    for(int j=0; j<sz; j++){
                        chars[k++] = charArr[j];
                    }
                }
                    
                count = 1;
            }
            last = curr;
        }
        chars[k++] = last;
        len += 1;
        if(count > 1){
            char[] charArr = Integer.toString(count).toCharArray();
            int sz = charArr.length;
            len += sz;
            for(int i=0; i<sz; i++){
                chars[k++] = charArr[i];
            }
        }

        return len;
    }
}