class Solution {
    // Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s) {
        Stack<Integer> temp=new Stack<>();
        
        int n=s.size();
        int i=0;
        while(i<n/2){
            temp.push(s.pop());
            i++;
        }
        
        s.pop();
        
        while(!temp.isEmpty()){
            s.push(temp.pop());
        }
    }
}