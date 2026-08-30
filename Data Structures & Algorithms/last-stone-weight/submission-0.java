class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones){
            pq.offer(stone);
        }

        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();

            if(first == second)
                continue;
            else if(first > second)
                pq.offer(first-second);
        }

        if(pq.size() == 1)
            return pq.poll();

        return 0;
    }
}
