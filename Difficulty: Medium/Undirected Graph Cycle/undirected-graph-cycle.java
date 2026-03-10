class Solution {
    public boolean flag;
    public class pair{
        int node;
        int parent;
        
        pair(int n,int p){
            this.node = n;
            this.parent = p;
        }
    }
    public void bfs(int i,List<List<Integer>> adj,boolean[] vis){
        vis[i] = true;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(i,-1));
        
        while(!q.isEmpty()){
            pair top = q.remove();
            
            for(int ele : adj.get(top.node)){
                if(!vis[ele] && ele!=top.parent){
                    q.add(new pair(ele,top.node));
                    vis[ele] = true;
                }
                else if(vis[ele] && ele!=top.parent){
                    flag = true;
                }
            }
        }
    }
    public boolean isCycle(int V, int[][] edges) {
        flag = false;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        
        for(int[] edge :edges){
            int u = edge[0], v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(flag) break;
            if(!vis[i]){
                bfs(i,adj,vis);
            }
        }
        return flag;
    }
}