/*
// Representation of a node
class Node {
    int data;
    Node next;
    Node (int d) {
       data = d;
       next = null;
    }
};
*/
class Solution {
    public Node arrayToList(int arr[]) {
       Node head=new Node(arr[0]);
       Node temp=head;
       for(int i=1;i<arr.length;i++){
           Node dummy=new Node(arr[i]);
           temp.next=dummy;
           temp=temp.next;
       }
       
       return head;
    }
}
