class Solution {
    static boolean searchInSorted(int arr[], int k) {
        int st=0;
        int end=arr.length-1;
        
        while(st<=end){
            int mid=(st+end)/2;
            
            if(arr[mid]==k){
               return true;
            }
            else if(arr[mid]>k) end=mid-1;
            else st=mid+1;
        }
        
        return false;
    }
}