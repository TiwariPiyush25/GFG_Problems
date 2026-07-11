class Solution {
    public ArrayList<Integer> getAlternates(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            if(i % 2 == 0) list.add(arr[i]);
        }
        
        return list;
    }
}