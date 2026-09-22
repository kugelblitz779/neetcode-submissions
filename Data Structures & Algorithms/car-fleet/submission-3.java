class Car{
    int pos;
    int v;

    Car(int pos, int v){
        this.pos = pos;
        this.v = v;
    }
}

// target=10
// 0, 1, 4, 7
// 1, 2, 2, 1


class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        List<Car> ll = new ArrayList<>();
        int n = position.length;

        for(int i=0; i<n; i++){
            ll.add(new Car(position[i], speed[i]));
        }
        Collections.sort(ll, (a, b) -> Integer.compare(b.pos, a.pos));
        
        int fleet = 0;
        double maxTime = 0.0;

        for(int i=0; i<n; i++){
            Car curr = ll.get(i);
            
            double time = (double)(target - curr.pos)/curr.v;

            if(time > maxTime){
                fleet++;
                maxTime = time;
            }
        }

        return fleet;
    }
}
