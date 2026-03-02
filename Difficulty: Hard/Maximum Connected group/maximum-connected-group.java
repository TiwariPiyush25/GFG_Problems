class Solution {
    public int[] parent;
    public int[] size;
    public int leader(int u){
        if(parent[u]==u) return u;
        
        return parent[u] = leader(parent[u]);
    }
    public void union(int u,int v){
        int a = leader(u);
        int b = leader(v);

        if(a != b){
            if(size[a]  > size[b]){
                parent[b] = a;
                size[a] += size[b];
            }
            else{
                parent[a] = b;
                size[b] += size[a];
            }
        }
    }
    public boolean isValid(int newr,int newc,int n){
        return newr>=0 && newr<n && newc>=0 && newc<n;
    }
    public int MaxConnection(int grid[][]) {
        int n  = grid.length;
        parent = new int[n*n];
        size = new int[n*n];

        for(int i = 0;i<n*n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        // step 1 : 
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0) continue;
                int[] dr = {-1,0,1,0};
                int[] dc = {0,-1,0,1};
                
                for(int k=0;k<4;k++){
                    int newr = i + dr[k];
                    int newc = j + dc[k];
                    
                    if(isValid(newr,newc,n) && grid[newr][newc]==1){
                        int nodeNo = i * n + j;
                        int adjnodeNo = newr * n + newc;
                        
                        union(nodeNo,adjnodeNo);
                    }
                }
            }
        }
        
        // step 2 : 
        int maxSize = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) continue;
                int[] dr = {-1,0,1,0};
                int[] dc = {0,-1,0,1};
                HashSet<Integer> set = new HashSet<>();
                
                for(int k=0;k<4;k++){
                    int newr = i + dr[k];
                    int newc = j + dc[k];
                    
                    if(isValid(newr,newc,n)){
                        if(grid[newr][newc]==1) set.add(leader(newr * n + newc));
                    }
                }
                int sizeTotal = 0;
                for(int it:set){
                    sizeTotal += size[it];
                }
                
                maxSize = Math.max(maxSize,sizeTotal+1);
            }
        }
        
        for(int cellNo = 0;cellNo<n*n;cellNo++){
            maxSize = Math.max(maxSize , size[leader(cellNo)]);
        }
        
        return maxSize;
    }
}