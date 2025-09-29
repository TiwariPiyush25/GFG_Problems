// User function Template for Java
class Solution {
    public int search(int k, ArrayList<Integer> arr) {
        int idx=-1;
        
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)==k) {
                idx=i+1;
                break;
            }
        }
        
        return idx;
    }
}