class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=i;j<n;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for(int i=0;i<m;i++){
            ArrayList<Integer> row=new ArrayList<>();
            for(int j=0;j<n;j++){
                row.add(mat[i][j]);
            }
            ans.add(row);
        }
        
        return ans;
    }
}