// User function Template for Java
class Solution {
    public class pair{
        int node;
        int dist;
        
        pair(int n,int d){
            this.node = n;
            this.dist = d;
        }
    }
    public void topoSort(int node,List<List<pair>> adj,boolean[] vis,Stack<Integer> st){
        vis[node] = true;
        
        for(pair p :adj.get(node)){
            int v = p.node;
            
            if(!vis[v]){
                topoSort(v,adj,vis,st);
            }
        }
        
        st.push(node);
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        List<List<pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            int u = edge[0],v = edge[1] , dist = edge[2];
            
            adj.get(u).add(new pair(v,dist));
        }
        
        // find topological sort
        boolean vis[] = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                topoSort(i,adj,vis,st);
            }
        }
        
        // Do the relaxation of edges
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e9);
        
        dist[0] = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            
            for(pair p : adj.get(node)){
                int v = p.node,wt = p.dist;
                
                if(dist[node] + wt < dist[v]){
                    dist[v] = dist[node] + wt;
                }
            }
        }
        
        for(int i = 0;i<V;i++){
            if(dist[i]==(int)1e9){
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}