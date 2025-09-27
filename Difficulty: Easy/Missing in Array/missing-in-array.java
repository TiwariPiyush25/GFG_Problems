class Solution {
    int missingNum(int arr[]) {
        long calculatedsum=0;
        
        for(int ele:arr){
            calculatedsum+=ele;
        }
        
        long n=arr.length;
        
        long possibleSum=((n+1)*(n+2))/2;
        
        return (int) (possibleSum-calculatedsum);
    }
}