class Solution {
    void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    void selectionSort(int[] arr) {
       int n=arr.length;
       for(int i=0;i<n;i++){
           int minidx=i;
           for(int j=i+1;j<n;j++){
               if(arr[j]<arr[minidx]){
                   minidx=j;
               }
           }
           swap(arr,i,minidx);
       }
    }
}