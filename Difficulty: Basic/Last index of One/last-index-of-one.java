// User function Template for Java

class Solution {
    public int lastIndex(String s) {
        int idx=-1;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                idx=i;
                break;
            }
        }
        
        return idx;
    }
}