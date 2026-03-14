class Solution {
    public void dfs(int i,int j,char[][] grid,int[][] vis){
        int m = grid.length; int n = grid[0].length;
        vis[i][j] = 1;
        
        int[] row = {-1,0,1,0,-1,-1,1,1};
        int[] col = {0,-1,0,1,-1,1,-1,1};
        
        for(int k=0;k<8;k++){
            int newRow = i + row[k];
            int newCol = j + col[k];
            
            if(newRow >=0 && newCol>=0 && newRow<m && newCol<n && vis[newRow][newCol]==0 && grid[newRow][newCol] == 'L'){
                dfs(newRow,newCol,grid,vis);
            }
            
        }
    }
    public int countIslands(char[][] grid) {
        int m = grid.length; int n = grid[0].length;
            
        int[][] vis = new int[m][n];
        int cnt = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(vis[i][j] == 0 && grid[i][j] == 'L'){
                    dfs(i,j,grid,vis);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}