class Solution {
    public class pair implements Comparable<pair>{
        int node;
        int dist;
        
        pair(int n,int dist){
            this.node = n;
            this.dist = dist;
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
        
        for(int[] arr:edges){
            int node1 = arr[0];
            int node2 = arr[1];
            int dist = arr[2];
            
            adj.get(node1).add(new pair(node2,dist));
            adj.get(node2).add(new pair(node1,dist));
        }
        
        int[] cost = new int[V];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src] = 0;
        
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(src,0));
        
        while(!pq.isEmpty()){
            pair top = pq.remove();
            
            if(top.dist > cost[top.node]) continue;
            for(pair p:adj.get(top.node)){
                int totaldist = p.dist + top.dist;
                if(totaldist < cost[p.node]){
                    cost[p.node] = totaldist;
                    pq.add(new pair(p.node,totaldist));
                }
            }
        }
        
        return cost;
    }
}