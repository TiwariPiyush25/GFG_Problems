class Solution {
    public void bfs(int i,boolean[] vis,List<List<Integer>> adj,int[] In,ArrayList<Integer> ans){
        vis[i] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        
        while(!q.isEmpty()){
            int temp = q.remove();

            for(int ele:adj.get(temp)){
                if(In[ele] > 0) {
                    In[ele]--;
                }
                if(!vis[ele] && In[ele]==0){
                    q.add(ele);
                    vis[ele] = true;
                }
            }
            ans.add(temp);
        }
        
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        
        int[] indegree = new int[V];
        for(int[] arr:edges){
            int src = arr[0];
            int dest = arr[1];
            
            indegree[dest]++;
            adj.get(src).add(dest);
        }
        
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i] && indegree[i]==0){
                bfs(i,vis,adj,indegree,ans);
            }
        }
        
        return ans;
    }
}