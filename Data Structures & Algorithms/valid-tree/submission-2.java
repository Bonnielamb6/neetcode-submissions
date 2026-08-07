class Solution {
    int[] parent;
    int[] rank;
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n -1){
            return false;
        }
        parent = new int[n];
        rank = new int[n];
        for(int pointer = 0 ; pointer < n; pointer++){
            parent[pointer] = pointer;
            rank[pointer] = 1;
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(find(u) == find(v)){
                return false;
            }
            union(u,v);
        }
        return true;

    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY){
            return false;
        }
        if(rank[rootX] > rank[rootY]){
            parent[rootY] = rootX;
        }else if(rank[rootX] < rank[rootY]){
            parent[rootX] = rootY;
        }else{
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
}
