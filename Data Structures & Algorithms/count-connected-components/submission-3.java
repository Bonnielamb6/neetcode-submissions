class Solution {
    public int countComponents(int n, int[][] edges) {
        int result = 0;
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int counter = 0 ; counter < n; counter++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int pointer = 0 ; pointer < n ; pointer++){
            if(!visited[pointer]){
                dfs(pointer, visited, graph);
                result++;
            }
        }
        return result;
    }

    public void dfs(int node, boolean[] visited, List<List<Integer>> graph){
        visited[node] = true;
        for(int neighbour: graph.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour,visited,graph);
            }
        }
    }
}
