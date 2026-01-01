class Solution {
    public class pair{
        int node;
        int parent;
        
        pair(int n,int p){
            this.node = n;
            this.parent = p;
        }
    }
    public void bfs(int i,List<List<Integer>> adj,boolean[] vis,boolean[] flag){
        vis[i] = true;
        Queue<pair> q = new LinkedList<>();
        
        q.add(new pair(i,-1));
        while(!q.isEmpty()){
            pair p = q.remove();
            int N = p.node;
            int P = p.parent;
            
            for(int ele:adj.get(N)){
                if(!vis[ele] && ele != P){
                    q.add(new pair(ele,N));
                    vis[ele] = true;
                }
                else if(vis[ele] && ele != P){
                    flag[0] = true;
                    return;
                }
            }
        }
        
    }
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        
        for(int[] arr:edges){
            int v1 = arr[0];
            int v2 = arr[1];
            
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }
    
        boolean[] vis = new boolean[V];
        boolean[] flag = new boolean[1];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                bfs(i,adj,vis,flag);
                if(flag[0]) return true;
            }
        }
        
        return false;
    }
}