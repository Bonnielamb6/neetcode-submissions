class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Deque<Integer> queue = new ArrayDeque<>();
        for(int iterator = 0 ; iterator < numCourses; iterator++){
            list.add(new ArrayList<>());
        }
        for(int [] pre : prerequisites){
            int a = pre[0];
            int b = pre[1];
            list.get(b).add(a);
            indegree[a]++;
        }
        for(int pointer = 0 ; pointer < numCourses; pointer++){
            if(indegree[pointer] == 0){
                queue.offer(pointer);
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int current = queue.poll();
            result.add(current);
            for(int value : list.get(current)){
                indegree[value]--;
                if(indegree[value] == 0){
                    queue.offer(value);
                }
            }
        }
        if(result.size() == numCourses){
            return result.stream().mapToInt(Integer::intValue).toArray();
        }else{
            return new int[]{};
        }
        
    }
}
