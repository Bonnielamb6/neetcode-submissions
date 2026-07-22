class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int current = edge[0];
            int nodeTo = edge[1];
            graph.get(current).add(nodeTo);
            graph.get(nodeTo).add(current);
        }
        if (!dfs(0, -1, graph, visited)) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int node, int parent, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                if (!dfs(neighbour, node, graph, visited)) {
                    return false;
                }
            } else if (neighbour != parent) {
                return false;
            }
        }
        return true;
    }
}
