class Solution {
    void segregate0and1(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        
        while(i < j){
            while(i < arr.length && arr[i] == 0) i++;
            while(j >= 0 && arr[j] == 1) j--;
            
            if(i < j && arr[i] == 1 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
