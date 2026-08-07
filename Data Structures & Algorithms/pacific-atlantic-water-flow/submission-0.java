class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        Deque<int[]> pacificQueue = new ArrayDeque<>();
        Deque<int[]> atlanticQueue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int row = 0 ; row < heights.length; row++){
            pacificQueue.offer(new int[]{row,0});
            atlanticQueue.offer(new int[]{row,heights[0].length - 1});
            pacific[row][0] = true;
            atlantic[row][heights[0].length - 1] = true;
        }
        for(int col = 0 ; col < heights[0].length; col++){
            pacificQueue.offer(new int[]{0,col});
            atlanticQueue.offer(new int[]{heights.length - 1, col});
            pacific[0][col] = true;
            atlantic[heights.length - 1][col] = true;
        }
        while(!pacificQueue.isEmpty()){
            int[] current = pacificQueue.poll();
            bfs(heights, pacific, current[0],current[1],current[0] - 1,current[1],pacificQueue);
            bfs(heights, pacific, current[0],current[1],current[0],current[1] - 1,pacificQueue);
            bfs(heights, pacific, current[0],current[1],current[0] + 1,current[1],pacificQueue);
            bfs(heights, pacific, current[0],current[1],current[0],current[1] + 1,pacificQueue);
        }
        while(!atlanticQueue.isEmpty()){
            int[] current = atlanticQueue.poll();
            bfs(heights, atlantic, current[0],current[1],current[0] - 1,current[1],atlanticQueue);
            bfs(heights, atlantic, current[0],current[1],current[0],current[1] - 1,atlanticQueue);
            bfs(heights, atlantic, current[0],current[1],current[0] + 1,current[1],atlanticQueue);
            bfs(heights, atlantic, current[0],current[1],current[0],current[1] + 1,atlanticQueue);
        }
        for(int row = 0 ; row < heights.length; row++){
            for(int col = 0 ; col < heights[0].length; col++){
                if(atlantic[row][col] == true && pacific[row][col] == true){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(row);
                    temp.add(col);
                    result.add(temp);
                }
            }
        }
        return result;
    }

    public void bfs(int[][] grid,boolean[][] visited, int row, int col, int nr, int nc, Deque<int[]> deque){
        if(nr < 0 || nr > grid.length - 1
        || nc < 0 || nc > grid[0].length - 1){
            return;
        }
        if(visited[nr][nc] == true){
            return;
        }
        if(grid[nr][nc] >= grid[row][col]){
            visited[nr][nc] = true;
            deque.offer(new int[]{nr, nc});
        }
    }
}
