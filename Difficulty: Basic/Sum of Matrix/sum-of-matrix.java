class Solution {
    public int sumOfMatrix(int[][] mat) {
        int sum = 0;
        for(int[] arr : mat){
            for(int ele : arr){
                sum += ele;
            }
        }
        
        return sum;
    }
}