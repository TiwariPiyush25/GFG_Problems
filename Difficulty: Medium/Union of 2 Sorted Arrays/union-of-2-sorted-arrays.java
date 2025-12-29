class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int ele:a){
            if(arr.size() == 0 || arr.get(arr.size()-1)!=ele) arr.add(ele);
        }
        
        int i = 0;
        int j = 0;
        while(i<arr.size() && j<b.length){
            if(i>0 && arr.get(i-1)== b[j]) j++;
            else if (arr.get(i) > b[j]){
                arr.add(i,b[j++]);
            }
            else i++;
        }
        
        while(j<b.length){
            if(arr.get(arr.size()-1)!= b[j]) arr.add(b[j++]);
            else j++;
        }
        
        return arr;
    }
}
