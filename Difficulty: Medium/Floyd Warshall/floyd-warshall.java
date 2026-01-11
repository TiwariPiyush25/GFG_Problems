// User function template for JAVA

class Solution {
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        for(int C = 0;C < n; C++){
            // A to B through C
            for(int A = 0;A < n; A++){ // Node A
                for(int B = 0;B < n;B++){ // Node B
                    if(dist[A][C]==100000000 || dist[C][B]==100000000) continue;
                    dist[A][B] = Math.min(dist[A][B],dist[A][C]+dist[C][B]);
                }
            }
        }
        
    }
}