class Solution {
    public boolean isPossible(long x,int k,int[] arr){
        long pages = 0;
        int student = 1;
        for(int i = 0;i < arr.length;i++){
            if(arr[i] > x) return false;
            if(pages + arr[i] <= x){
                pages += arr[i];
            }
            else {
                student++;
                pages = arr[i];
            }
        }
        
        return student <= k;
    }
    public int findPages(int[] arr, int k) {
        if(k > arr.length) return -1;
        
        long st = 0;
        long end = 0;
        
        for(int ele : arr){
            end += ele;
        }
        
        long ans = -1;
        while(st <= end){
            long mid = (st + end)/2;
            
            if(isPossible(mid,k,arr)){
                ans = mid;
                end = mid - 1;
            }
            else st = mid + 1;
        }
        
        return (int) ans;
    }
}