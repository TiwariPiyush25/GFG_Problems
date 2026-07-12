class Solution {
    public ArrayList<ArrayList<Integer>> multiplyMatrices(int[][] a, int[][] b) {
        
        
        int n = a.length;
        int[][] temp = new int[n][n];
        
        for(int i=0;i <n;i++){
            for(int j=0;j < n;j++){
                for(int k = 0;k < n;k++){
                    temp[i][j] += (a[i][k] * b[k][j]);
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i <n;i++){
            ans.add(new ArrayList<>());
            for(int j=0;j < n;j++){
                ans.get(i).add(temp[i][j]);
            }
        }
        return ans;
    }
}