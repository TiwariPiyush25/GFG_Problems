class Solution {
    public static int[] parent;
    public static int[] size;
    public static int leader(int u){
        if(parent[u]==u) return u;
        
        return parent[u] = leader(parent[u]);
    }
    public static void union(int u,int v){
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
    static int kruskalsMST(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        Arrays.sort(edges,(a,b) -> a[2] - b[2]);
       
        int minCost = 0;
        for(int[] edge:edges){
            int u = edge[0],v = edge[1],dist = edge[2];

            if(leader(u)!=leader(v)){
                minCost += dist;
                union(u,v);
            }
        }

        return minCost;
    }
}
