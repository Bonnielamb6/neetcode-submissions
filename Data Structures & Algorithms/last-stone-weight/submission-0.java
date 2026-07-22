class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            pq.offer(stone);
        }
        while(pq.size() > 1){
            int bigStone = pq.poll();
            int smallStone = pq.poll();
            int leftOver = bigStone - smallStone;
            if(leftOver!= 0){
                pq.offer(leftOver);
            }
        }
        if(pq.isEmpty()){
            return 0;
        }else{
            return pq.poll();
        }
    }
}