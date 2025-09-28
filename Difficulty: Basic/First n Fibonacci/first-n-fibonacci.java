// User function Template for Java

class Solution {
    public static int helper(int n){
        if(n<=1) return n;
        
        return helper(n-1)+helper(n-2);
    }
    public static int[] fibonacciNumbers(int n) {
        int[] ans=new int[n];
        
        for(int i=0;i<n;i++){
            ans[i]=helper(i);
        }
        return  ans;
    }
}