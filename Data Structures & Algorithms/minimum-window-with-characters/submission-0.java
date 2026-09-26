class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mt = new HashMap<>();
        Map<Character, Integer> ms = new HashMap<>();
        int n = s.length();
        for(char c : t.toCharArray()){
            mt.put(c, mt.getOrDefault(c, 0)+1);
        }
        int minWin = 100001;
        int start = 0;
        int end = 0;
        String res = "";

        while(end < n){
            char c = s.charAt(end);
            ms.put(c, ms.getOrDefault(c, 0)+1);

            while(isSUnderEqualT(ms, mt)){

                if(end-start+1 < minWin){
                    minWin = end-start+1;
                    res = s.substring(start, end+1);
                }

                ms.put(s.charAt(start), ms.get(s.charAt(start))-1);
                start++;
            }

            end++;
        }

        return res;
    }

    public boolean isSUnderEqualT(Map<Character, Integer> ms, Map<Character, Integer> mt){
        for(Character key : mt.keySet()){
            if(!ms.containsKey(key)) return false;
            if(ms.get(key) != mt.get(key) && ms.get(key) < mt.get(key)) return false;
        }
        return true;
    }
}
