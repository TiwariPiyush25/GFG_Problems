// User function Template for Java

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
    public boolean isValid(int adjr,int adjc,int m,int n){
        return adjr>=0 && adjr<m  && adjc>=0 && adjc<n;
    }
    public List<Integer> numOfIslands(int m, int n, int[][] operators) {
        parent = new int[m*n];
        size = new int[m*n];
        
        for(int i = 0;i<m*n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        List<Integer> ans = new ArrayList<>();
        int[][] vis = new int[m][n];
        int cnt = 0;
     
        for(int[] it : operators){
            int row = it[0], col = it[1];
            
            if(vis[row][col] == 1){
                ans.add(cnt);
                continue;
            }
            
            vis[row][col] = 1;
            cnt++;
            
            int[] dr = {-1,0,1,0};
            int[] dc = {0,1,0,-1};
            
            for(int i=0;i<4;i++){
                int adjr = row + dr[i];
                int adjc = col + dc[i];
                
                if(isValid(adjr,adjc,m,n)){
                    if(vis[adjr][adjc] == 1){
                        int nodeNo = (row * n) + col;
                        int adjnodeNo = (adjr * n) + adjc;
                        
                        if(leader(nodeNo) != leader(adjnodeNo)){
                            cnt--;
                            union(nodeNo,adjnodeNo);
                        }
                    }
                }
            }
            
            ans.add(cnt);
        }
        
        
        return ans;
    }
}