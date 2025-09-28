/*
class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}*/

class Solution {
    public int getCount(Node head) {
        int length=0;
        
        Node temp=head;
        
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        
        return length;
    }
}