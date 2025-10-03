class Solution {
    public static int intersectSize(int a[], int b[]) {
        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();

        for(int ele:a) set1.add(ele);
        for(int ele:b) {
            if(set1.contains(ele)){
                set2.add(ele);
            }
        }

        return set2.size();
    }
}