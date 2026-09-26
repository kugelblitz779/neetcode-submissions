class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        // int maxH = 0;
        // for(int x : piles){
        //     maxH = Math.max(x, maxH);
        // }
        int hi = 1000000001;
        int lo = 1;
        int res = 0;

        while(lo <= hi){
            int k = lo + (hi - lo)/2;

            if(canSolve(piles, k, h)){
                res = k;
                hi = k - 1;
            }else{
                lo = k + 1;
            }
        }
        return res;
    }

    public boolean canSolve(int[] piles, int k, int h){

        int hrsReq = 0;
        int n = piles.length;
        for(int i=0; i<n; i++){
            hrsReq += Math.ceil((double)piles[i]/k); 
        }

        return hrsReq <= h;
    }
}
