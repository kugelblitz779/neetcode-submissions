class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];

        for(char c : s.toCharArray()){
            map[c-'a']++;
        }

        for(char c : t.toCharArray()){
            map[c-'a']--;
        }
        
        int count = 0;
        for(int i=0; i<26; i++){
            if(map[i] == 0){
                count++;
            }
        }

        return count==26 ? true : false;
    }
}
