class Solution {
    public class Triplet{
        int row;
        int col;
        int dist;
        
        Triplet(int r,int c,int d){
            this.row = r;
            this.col = c;
            this.dist = d;
        }
    }
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] vis = new int[m][n];
        ArrayList<ArrayList<Integer>> dist = new ArrayList<>();
        
        for(int i=0;i<m;i++){
            dist.add(new ArrayList<>());
            for(int j=0;j<n;j++){
                dist.get(i).add(0);
            }
        }
        
        Queue<Triplet> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new Triplet(i,j,0));
                    vis[i][j] = 1;
                }
                else{
                    vis[i][j] = 0;
                }
            }
        }
        int[] row = {-1,0,1,0};
        int[] col = {0,-1,0,1};
        
        while(!q.isEmpty()){
            Triplet top = q.remove();
            int r = top.row, c = top.col ,d = top.dist;
            
            dist.get(r).set(c,d);
            
            for(int i=0;i<4;i++){
                int newrow = row[i] + r;
                int newcol = col[i] + c;
                
                if(newrow>=0 && newrow<m && newcol>=0 && newcol<n && vis[newrow][newcol]!=1){
                    vis[newrow][newcol] = 1;
                    q.add(new Triplet(newrow,newcol,d+1));
                }
            }
        }
        
        return dist;
    }
}