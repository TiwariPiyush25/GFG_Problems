class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        boolean[] vis = new boolean[adj.size()];
        
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()){
            int node = q.remove();
            
            ans.add(node);
            
            for(int x : adj.get(node)){
                if(!vis[x]){
                    q.add(x);
                    vis[x] = true;
                }
            }
        }
        
        return ans;
    }
}