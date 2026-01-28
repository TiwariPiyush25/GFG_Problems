class Solution {
    public class pair implements Comparable<pair>{
        int dist;
        int node;
        
        pair(int d,int n){
            this.dist = d;
            this.node = n;
        }
        
        public int compareTo(pair p ){
            if(this.dist == p.dist) return this.node - p.node;
            return this.dist - p.dist;
        }
    }
    public int countPaths(int n, int[][] edges) {
       List<List<pair>> adj = new ArrayList<>();
       for(int i=0;i<n;i++) adj.add(new ArrayList<>());
       
       for(int[] edge : edges){
           int u = edge[0] , v = edge[1], dist = edge[2];
           adj.get(u).add(new pair(dist,v));
           adj.get(v).add(new pair(dist,u));
       }
       
       PriorityQueue<pair> minheap = new  PriorityQueue<>();
       int[] ways = new int[n];
       int[] dist = new int[n];
       Arrays.fill(dist,(int) 1e9);
       dist[0] = 0; ways[0] = 1;
       
       minheap.add(new pair(0,0));
       int mod = (int)(1e9 + 7);
       
       while(!minheap.isEmpty()){
           pair top = minheap.remove();
           int d = top.dist, node = top.node;
           
           for(pair p:adj.get(node)){
               int adjnode = p.node;
               int dis = p.dist;
               
               if(d + dis < dist[adjnode]){
                   dist[adjnode] = d + dis;
                   minheap.add(new pair(d + dis,adjnode));
                   ways[adjnode] = ways[node];
               }
               else if(d + dis <= dist[adjnode]){
                   ways[adjnode] = (ways[adjnode] +  ways[node]) % mod ;
               }
           }
       }
       
       return ways[n-1] % mod;
    }
}
