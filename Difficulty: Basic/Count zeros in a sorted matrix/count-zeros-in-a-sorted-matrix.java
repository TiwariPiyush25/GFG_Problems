class Solution {
    public int countZeros(int[][] mat) {
        int n = mat.length;
        int i = 0;
        int j = n-1;
        
        
        int total = 0;
        while(i < n){
            while(j >= 0 && mat[i][j] == 1) j--;
            
            total += (j+1);
            i++;
        }
        
        return total;
    }
};