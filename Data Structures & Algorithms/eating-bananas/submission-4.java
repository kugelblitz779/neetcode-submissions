class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++){
            maxi = Math.max(maxi, piles[i]);
        }

        int lo = 1;
        int hi = maxi;
        int ans = -1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(checkIfWorks(mid, piles, h)){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }

        return ans;
    }

    public boolean checkIfWorks(long k, int[] piles, int h){
        long timetaken = 0;
        for(int pile : piles){
            timetaken += (int)Math.ceil((double)pile/(double)k);
        }
        return timetaken <= h;
    }
}
