class Solution {
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void sort012(int[] arr) {
        if(arr.length == 0) return;
        
        int low = 0, mid = 0, hi = arr.length-1;

        while(mid <= hi){
            if(arr[mid] == 0){
                swap(arr,low,mid);
                low++;
                mid++;
            }
            else if(arr[mid] == 2){
                swap(arr,mid,hi);
                hi--;
            }
            else mid++;
        }
        
    }
}