class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) ->Integer.compare(
            (b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1])
            )
        );
        for(int[] point : points){
            if(pq.size() < k){
                pq.offer(point);
            }else{
                int[] temp = pq.peek();
                int currentDistance = point[0] * point[0] + point[1] * point[1];
                int topDistance = temp[0] * temp[0] + temp[1] * temp[1];
                if(currentDistance < topDistance){
                    pq.poll();
                    pq.offer(point);
                }
            }
        }
        int[][] closest = new int[k][2];
        int counter = 0;
        while(!pq.isEmpty()){
            int[] point = pq.poll();
            closest[counter][0] = point[0];
            closest[counter][1] = point[1];
            counter++;
        }
        return closest;
    }
}