class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frequencies = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        int[] result = new int[k];
        for(int actual : nums){
            frequencies.put(actual,frequencies.getOrDefault(actual,0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry : frequencies.entrySet()){
            priorityQueue.offer(entry);
        }
        int kCounter = 0;
        while(kCounter < k){
            result[kCounter] = priorityQueue.poll().getKey();
            kCounter++;
        }
        return result;
    }
}
