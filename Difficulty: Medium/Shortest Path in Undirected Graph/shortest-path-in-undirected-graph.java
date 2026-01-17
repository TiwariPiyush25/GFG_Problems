class Solution {
    public class pair{
        int node;
        int dist;
        
        pair(int node,int dist){
            this.dist = dist;
            this.node = node;
        }
    }
    public int[] shortestPath(int V, int[][] edges, int src) {
       List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            int u = edge[0],v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e9);
        
        Queue<pair> q = new LinkedList<>();
        dist[src] = 0;
        q.add(new pair(src,0));
        
        while(!q.isEmpty()){
            pair top  = q.remove();
            int node = top.node, wt = top.dist;
            
            for(int v:adj.get(node)){
                if(wt + 1 < dist[v]){
                    q.add(new pair(v,wt+1));
                    dist[v] = wt+1;
                }
            }
        }
        
        for(int i=0;i<V;i++){
            if(dist[i] == (int)1e9){
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}
