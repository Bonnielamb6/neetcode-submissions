class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            if(pq.size() < k){
                pq.offer(num);
            }else{
                int min = pq.peek();
                if(min < num){
                    pq.poll();
                    pq.offer(num);
                }
            }

        }
        return pq.poll();
    }
}