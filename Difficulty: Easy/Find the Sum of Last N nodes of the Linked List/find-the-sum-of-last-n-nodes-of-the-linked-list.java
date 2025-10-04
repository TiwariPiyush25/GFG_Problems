/*
Node class is as follows:

class Node {
    int data;
    Node next;

    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    public int sumOfLastN_Nodes(Node head, int n) {
        Stack<Integer> st=new Stack<>();
        Node temp=head;
        
        while(temp!=null){
            st.push(temp.data);
            temp=temp.next;
        }
        
        int sum=0;
        while(n-->0){
            sum+=st.pop();
        }
        
        return sum;
    }
}