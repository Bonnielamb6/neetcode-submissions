class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int counter = 0;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                dfs(i, visited, graph);
                counter++;
            }
        }
        return counter;
    }

    public void dfs(int node, boolean[] visited, List<List<Integer>> graph) {
        for (int neighbour : graph.get(node)) {
            if (visited[neighbour] == true) {
                continue;
            }
            visited[neighbour] = true;
            dfs(neighbour, visited, graph);
        }
    }
}
