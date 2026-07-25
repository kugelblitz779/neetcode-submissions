class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            // Map<Character, Integer> charMp = new HashMap<>();
            // for(char c : s.toCharArray()){
            //     charMp.put(c, charMp.getOrDefault(c, 0)+1);
            // }

            char[] ch = s.toCharArray();
            Arrays.sort(ch);

            String sorted = new String(ch);
            if(map.containsKey(sorted)){
                map.get(sorted).add(s);
            }else{
                List<String> li = new ArrayList<>();
                li.add(s);
                map.put(sorted, li);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for(String s : map.keySet()){
            res.add(map.get(s));
        }

        return res;
    }
}
