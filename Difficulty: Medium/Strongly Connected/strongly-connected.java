class Solution {
    public void dfs(int node,boolean[] vis,List<List<Integer>> adj,Stack<Integer> st){
        vis[node] = true;
        
        for(int it:adj.get(node)){
            if(!vis[it]){
                dfs(it,vis,adj,st);
            }
        }
        
        st.push(node);
    }
    public void DFS(int node,List<List<Integer>> adjT,boolean[] vis){
        vis[node] = true;
        
        for(int it:adjT.get(node)){
            if(!vis[it]){
                DFS(it,adjT,vis);
            }
        }
    }
    public int kosaraju(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        
        boolean[] vis = new boolean[V+1];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0;i < V;i++){
            if(!vis[i]){
                dfs(i,vis,adj,st);
            }
        }
        
        List<List<Integer>> adjT = new ArrayList<>();
        for(int i=0;i<V;i++) adjT.add(new ArrayList<>());
        
        for(int i=0;i<V;i++){
            vis[i]  = false;
            for(int it:adj.get(i)){
                adjT.get(it).add(i);
            }
        }
        
        int sccCount = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            
            if(!vis[node]){
                sccCount++;
                DFS(node,adjT,vis);
            }
        }
        
        return sccCount;
    }
}