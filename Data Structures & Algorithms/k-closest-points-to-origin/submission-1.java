class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(
            (b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1])
        ));
        for(int[] point : points){
            if(pq.size() < k){
                pq.offer(point);
            }else{
                int[]temp = pq.peek();
                int currentDistance = (point[0] * point[0] + point[1] * point[1]);
                int tempDistance = (temp[0] * temp[0] + temp[1] * temp[1]);
                if(currentDistance < tempDistance){
                    pq.poll();
                    pq.offer(point);
                }
            }

        }
        int result[][] = new int[k][2];
        for(int pointer = 0; pointer < k; pointer++){
            int[] point = pq.poll();
            result[pointer][0] = point[0];
            result[pointer][1] = point[1];
        }
        return result;
    }
}
