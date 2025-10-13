// User function Template for Java

class Solution {
    String firstAlphabet(String S) {
       String[] arr=S.split(" ");
       
       String res="";
       
       for(String ele:arr){
           res+=ele.charAt(0);
       }
       
       return res;
    }
};