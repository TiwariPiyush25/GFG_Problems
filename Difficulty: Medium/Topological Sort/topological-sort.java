class Solution {
    public void dfs(int i,boolean[] vis,List<List<Integer>> adj,ArrayList<Integer> ans){
        vis[i] = true;
        
        for(int ele:adj.get(i)){
            if(!vis[ele]){
                dfs(ele,vis,adj,ans);
            }
        }
        
        ans.add(i);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        
        for(int[] arr:edges){
            int src = arr[0];
            int dest = arr[1];
            
            adj.get(src).add(dest);
        }
        
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,vis,adj,ans);
            }
        }
        
        Collections.reverse(ans);
        return ans;
    }
}