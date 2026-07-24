class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for(int pointer = 0 ; pointer < position.length ; pointer++){
            cars[pointer][0] = position[pointer];
            cars[pointer][1] = speed[pointer];
        }
        Arrays.sort(cars,(a,b) -> Integer.compare(a[0],b[0]));
        int fleets = 0;
        double maxTime = 0;
        for(int current = cars.length - 1 ; current >= 0; current--){
            double currentTime = (double)(target - cars[current][0]) / cars[current][1];
            if(currentTime> maxTime){
                fleets++;
                maxTime = currentTime;
            }
        }
        return fleets;
    }
}
