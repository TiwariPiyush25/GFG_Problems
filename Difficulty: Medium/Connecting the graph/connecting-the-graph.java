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
            if(size[a]  >size[b]){
                parent[b] = a;
                size[a] += size[b];
            }
            else{
                parent[a] = b;
                size[b] += size[a];
            }
        }
    }
    public int Solve(int n, int[][] edge) {
        parent = new int[n];
        size = new int[n];

        for(int i = 0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        
        int cntextras = 0;
        int m = edge.length;
        
        for(int[] e:edge){
            int u = e[0], v = e[1];
            
            if(leader(u) == leader(v)){
                cntextras++;
            }
            else {
                union(u,v);
            }
        }
        
        int cntComponent = 0;
        for(int i=0;i<n;i++){
            if(parent[i]==i) cntComponent++;
        }   
        int ans = cntComponent - 1;
        if(cntextras>= ans) return ans;
        return -1;
    }
}