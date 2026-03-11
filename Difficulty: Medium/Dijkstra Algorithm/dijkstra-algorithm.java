class Solution {
    public class pair implements Comparable<pair>{
        int node;
        int dist;
        
        pair(int n,int d){
            this.node = n;
            this.dist = d;
        }
        
        public int compareTo(pair p){
            return this.dist - p.dist;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u = edge[0], v = edge [1], dist = edge[2];
            
            adj.get(u).add(new pair(v,dist));
            adj.get(v).add(new pair(u,dist));
        }
        
        int[] cost = new int[V];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src] = 0;
        PriorityQueue<pair> minheap = new PriorityQueue<>();
        minheap.add(new pair(src,0));
        
        while(!minheap.isEmpty()){
            pair top = minheap.remove();
            
            if(top.dist > cost[top.node]) continue;
            for(pair p:adj.get(top.node)){
                int totaldist = top.dist + p.dist;
                
                if(totaldist < cost[p.node]){
                    minheap.add(new pair(p.node,totaldist));
                    cost[p.node] = totaldist;
                }
            }
        }
        
        return cost;
    }
}