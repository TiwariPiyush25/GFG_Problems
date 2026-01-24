class Solution {
    public class triplet{
        int dist;
        int row;
        int col;
        
        triplet(int d,int r,int c){
            this.dist = d;
            this.row = r;
            this.col = c;
        }
    }
    int shortestPath(int[][] grid, int[] src, int[] dest) {
        if(src[0] == dest[0] && src[1] == dest[1]) return 0;
        int m = grid.length, n = grid[0].length;
        
        int[] row = {-1,0,1,0};
        int[] col = {0,-1,0,1};
        
        int[][] dist = new int[m][n];
        for(int[] arr:dist){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        
        dist[src[0]][src[1]] = 0;
        Queue<triplet> q = new LinkedList<>();
        
        q.add(new triplet(0,src[0],src[1]));
        while(!q.isEmpty()){
            triplet t = q.remove();
            int d = t.dist, r = t.row, c = t.col;
            
            for(int i=0;i<4;i++){
                int newRow = row[i] + r;
                int newCol = col[i] + c;
                
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && grid[newRow][newCol]==1 && (d + 1 < dist[newRow][newCol])){
                    q.add(new triplet(d+1,newRow,newCol));
                    dist[newRow][newCol] = d+1;
                    
                    if(newRow == dest[0] && newCol == dest[1]) return d+1;
                }
            }
        }
        
        
        return -1;
    }
}
