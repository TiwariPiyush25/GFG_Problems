class Solution {
    public int[][] adjToMat(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        
        int[][] mat = new int[n][n];
        
        for(int i = 0;i < n;i++){
            for(int j : adj.get(i)){
                mat[i][j] = 1;
            }
        }
        
        return mat;
    }
}
