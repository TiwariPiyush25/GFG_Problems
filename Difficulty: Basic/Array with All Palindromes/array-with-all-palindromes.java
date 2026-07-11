class Solution {
    public static boolean isit(int n){
        String s = ""+n;
        
        int i = 0,j = s.length()-1;
        
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        
        return true;
    }
    public static boolean isPalinArray(int[] arr) {
        
        for(int ele : arr){
            if(!isit(ele)) return false;
        }
        
        return true;
    }
}