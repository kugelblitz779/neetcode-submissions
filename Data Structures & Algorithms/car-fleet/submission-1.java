class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        double[][] cars = new double[n][2];

        for(int i=0; i<n; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double)(target-position[i])/(double)speed[i];
        }

        //Target : 12
        //12 - 10 / 2 -> 1
        //12 - 8 / 4 -> 1
        //12 - 5 / 1 -> 7
        //12 - 3 / 3 -> 3
        //12 - 0 / 1 -> 12


        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        int fleet = 0;
        double fleetTime = -1;

        for(int i=0; i<n; i++){
            if(fleetTime < cars[i][1]){
                fleet++;
                fleetTime = cars[i][1];
            }
        }

        return fleet;
    }
}
