class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjacencyList = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for(int counter = 0 ; counter < numCourses; counter++ ){
            adjacencyList.add(new ArrayList<>());
        }
        for(int [] pre : prerequisites){
            int a = pre[0];
            int b = pre[1];
            adjacencyList.get(b).add(a);
            indegree[a]++;
        }
        for(int pointer = 0 ; pointer < numCourses; pointer++){
            if(indegree[pointer] == 0){
                queue.offer(pointer);
            }
        }
        int coursesTaken = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int course : adjacencyList.get(current)){
                indegree[course]--;
                if(indegree[course] == 0){
                    queue.offer(course);
                }
            }
            coursesTaken++;
        }
        return coursesTaken == numCourses;
    }
}
