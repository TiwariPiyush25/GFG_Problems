class Solution {
    public void bfsKahn(int i,List<List<Integer>> adj,boolean[] vis,ArrayList<Integer> ans,int[] indegree ){
        vis[i] = true;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(i);
        
        while(!Q.isEmpty()){
            int top = Q.remove();
            
            for(int ele:adj.get(top)){
                if(indegree[ele] > 0){
                    indegree[ele]--;
                }
                if(!vis[ele] && indegree[ele] == 0){
                    Q.add(ele);
                    vis[ele] = true;
                }
            }
            
            ans.add(top);
        }
    } 
    public boolean isCyclic(int V, int[][] edges) {
       ArrayList<Integer> ans = new ArrayList<>();
       
       List<List<Integer>> adj = new ArrayList<>();
       for(int i=0;i<V;i++){
           adj.add(new ArrayList<>());
       }
       int[] indegree = new int[V];
       for(int[] edge : edges){
           int u = edge[0], v = edge[1];
           
           adj.get(u).add(v);
           indegree[v]++;
       }
       
       boolean[] vis = new boolean[V];
       for(int i=0;i<V;i++){
           if(!vis[i] && indegree[i] == 0){
               bfsKahn(i,adj,vis,ans,indegree);
           }
       }    
       
       return ans.size() != V;
    }
}