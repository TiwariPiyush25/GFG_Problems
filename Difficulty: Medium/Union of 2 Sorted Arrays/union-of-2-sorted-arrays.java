class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        HashSet<Integer> set=new HashSet<>();
        
        for(int ele:a){
            set.add(ele);
        }
        
        for(int ele:b){
            set.add(ele);
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int ele:set) arr.add(ele);
        
        Collections.sort(arr);
        return arr;
    }
}
