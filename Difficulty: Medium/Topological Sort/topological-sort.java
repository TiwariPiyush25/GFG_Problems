class Solution {
    public void dfs(int i,List<List<Integer>> adj,boolean[] vis,ArrayList<Integer> ans){
        vis[i] = true;
        
        
        for(int ele:adj.get(i)){
            if(!vis[ele]){
                dfs(ele,adj,vis,ans);
            }
        }
        
        ans.add(i);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
       ArrayList<Integer> ans = new ArrayList<>();
       
       List<List<Integer>> adj = new ArrayList<>();
       for(int i=0;i<V;i++){
           adj.add(new ArrayList<>());
       }
       for(int[] edge : edges){
           int u = edge[0], v = edge[1];
           
           adj.get(u).add(v);
       }
       
       boolean[] vis = new boolean[V];
       for(int i=0;i<V;i++){
           if(!vis[i]){
               dfs(i,adj,vis,ans);
           }
       }    
       
       Collections.reverse(ans);
       return ans;
    }
}