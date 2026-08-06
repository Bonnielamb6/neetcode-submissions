class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int stone : stones){
            pq.offer(stone);
        }
        while(pq.size() > 1){
            int stone1= pq.poll();
            int stone2 = pq.poll();
            int res = stone1 - stone2;
            if(res > 0){
                pq.offer(res);
            }
        }
        if(!pq.isEmpty()){
            return pq.poll();
        }else {
            return 0;
        }
    }
}
