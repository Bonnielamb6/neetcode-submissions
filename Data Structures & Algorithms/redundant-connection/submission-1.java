class Solution {
    int[] parent;
    int[] size;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        size = new int[parent.length];
        for(int counter = 0 ; counter < parent.length; counter++){
            parent[counter] = counter;
            size[counter] = 1;
        }
        for(int[] edge : edges){
            int nodeX = edge[0];
            int nodeY = edge[1];
            if(find(nodeX) == find(nodeY))
                return new int[]{nodeX,nodeY};
            union(nodeX, nodeY);
        }
        return new int[]{0,0};
    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY){
            return;
        }
        if(size[rootX] >= size[rootY]){
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }else{
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }
    }
}
