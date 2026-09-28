class Solution {
    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> ms1 = new HashMap<>();
        Map<Character, Integer> ms2 = new HashMap<>();

        int k = s1.length();
        int n = s2.length();

        if(n < k) return false;
        for(int i=0; i<k; i++){
            ms1.put(s1.charAt(i), ms1.getOrDefault(s1.charAt(i), 0)+1);
        }
        
        for(int i=0; i<k; i++){
            ms2.put(s2.charAt(i), ms2.getOrDefault(s2.charAt(i), 0)+1);
        }

        if(compareMaps(ms2, ms1)) return true;

        int end = k;
        int start = 0;

        while(end < n){
            char c = s2.charAt(end);
            //add character to the end
            ms2.put(c, ms2.getOrDefault(c, 0)+1);

            //remove character from start
            ms2.put(s2.charAt(start), ms2.get(s2.charAt(start))-1);
            if(ms2.get(s2.charAt(start))==0)
                ms2.remove(s2.charAt(start));

            if(compareMaps(ms2, ms1)) return true;

            start++;
            end++;
        }

        return false;
    }

    public boolean compareMaps(Map<Character, Integer> map1, Map<Character, Integer> map2){
        if(map1.size() != map2.size()) return false;
        for(Character key : map1.keySet()){
            if(!map2.containsKey(key)) return false;
            if(map2.get(key) != map1.get(key)) return false;
        }
        return true;
    }
}
