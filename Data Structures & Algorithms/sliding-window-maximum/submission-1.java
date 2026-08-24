class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[n-k+1];

        for(int i=0; i<n; i++){
            //remove elements outside the window
            while(!dq.isEmpty() && dq.peekFirst() < i - k + 1){
                dq.pollFirst();
            }

            //remove elements smaller than current
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }

            //add new element
            dq.offerLast(i);

            //record the max element once window is formed
            if(i >= k - 1){
                res[i+1-k] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
