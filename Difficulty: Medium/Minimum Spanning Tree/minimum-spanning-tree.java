class Solution {
    public class pair{
        int node;
        int dist;
        
        pair(int n,int d){
            this.node = n;
            this.dist = d;
        }
    }
    public class triplet implements Comparable<triplet>{
        int node;
        int parent;
        int dist;
        
        triplet(int n,int p,int d){
            this.node = n;
            this.parent = p;
            this.dist = d;
        }
        
        public int compareTo(triplet t){
            if(this.dist == t.dist) return this.node - t.node;
            return this.dist - t.dist;
        }
    }
    public int spanningTree(int V, int[][] edges) {
        List<List<pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        
        for(int[] arr:edges){
            int v1 = arr[0];
            int v2 = arr[1];
            int dist = arr[2];
            
            adj.get(v1).add(new pair(v2,dist));
            adj.get(v2).add(new pair(v1,dist));
        }
        
        boolean[] vis = new boolean[V];
        int sum  = 0;
        
        PriorityQueue<triplet> pq = new PriorityQueue<>();
        pq.add(new triplet(0,-1,0));
        
        while(!pq.isEmpty()){
            triplet top = pq.remove();
            int node = top.node, parent = top.parent,dist = top.dist;
            
            if(vis[node]) continue;
            
            if(parent!=-1){
                sum += dist;
            }
            
            for(pair p:adj.get(node)){
                if(!vis[p.node] && p.node!=node){
                    pq.add(new triplet(p.node,node,p.dist));
                }
            }
            vis[node] = true;
        }
        
        return sum;
    }
}
