class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        int end = 0;
        int currSize = 0;
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<s.length(); i++){
            currSize++;

            int last = lastIndex.get(s.charAt(i));
            if(last > end)
                end = last;

            if(i == end){
                res.add(currSize);
                currSize = 0;
            }
        }

        return res;
    }
}
