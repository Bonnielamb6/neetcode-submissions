class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        int[] size = new int[parent.length];
        for(int i = 0 ; i < parent.length; i++){
            parent[i] = i;
            size[i] = i;
        }

        for(int[] edge : edges){
            int nodeA = edge[0];
            int nodeB = edge[1];
            if(find(nodeA,parent) == find(nodeB,parent)){
                return new int[]{nodeA,nodeB};
            }
            union(nodeA,nodeB,parent,size);
        }
        return new int[]{0,0};
    }

    public int find(int node, int[] parent){
        if(parent[node] != node){
            parent[node] = find(parent[node],parent);
        }
        return parent[node];
    }

    public void union(int nodeA, int nodeB, int[] parent, int[] size){
        int rootA = find(nodeA,parent);
        int rootB = find(nodeB,parent);
        if(rootA == rootB){
            return;
        }
        if(size[rootA] >= size[rootB]){
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }else{
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
    }
}