// User function Template for Java

class Solution {
    public String toString(int r,int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }
    public void dfs(int r,int c,int[][] grid,boolean[][] vis,ArrayList<String> list,int sr,int sc){
        int m  = grid.length;
        int n = grid[0].length;
        vis[r][c] = true;
        
        list.add(toString(r-sr,c-sc));
        
        int[] row = {-1,0,1,0};
        int[] col = {0,-1,0,1};
        
        
        for(int i=0;i<4;i++){
            int newRow = r + row[i];
            int newCol = c + col[i];
            
            if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && !vis[newRow][newCol] && grid[newRow][newCol]==1){
                dfs(newRow,newCol,grid,vis,list,sr,sc);
            }
        }
    }
    int countDistinctIslands(int[][] grid) {
        int m  = grid.length;
        int n = grid[0].length;
        
        boolean[][] vis = new boolean[m][n];
        HashSet<ArrayList<String>> set = new HashSet<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i,j,grid,vis,list,i,j);
                    set.add(list);
                }
            }
        }
        
        return set.size();
    }
}
