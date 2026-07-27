class Solution {
    public ArrayList<ArrayList<Integer>> matToAdj(int[][] mat) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0;i < mat.length;i++){
            adj.add(new ArrayList<>());
            
            for(int j = 0;j < mat[0].length;j++){
                if(mat[i][j] == 1){
                    adj.get(adj.size()-1).add(j);
                }
            }
        }
        
        return adj;
    }
}