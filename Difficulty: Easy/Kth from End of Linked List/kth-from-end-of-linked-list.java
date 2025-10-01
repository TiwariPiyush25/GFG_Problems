/* Structure of node
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
} */

class Solution {
    int getKthFromLast(Node head, int k) {
       Node slow=head;
       Node fast=head;
       
       for(int i=1;i<k;i++){
           if(fast!=null) fast=fast.next;
       }
       
       if(fast==null) return -1;
       while(fast.next!=null){
           slow=slow.next;
           fast=fast.next;
       }
       
       if(slow==null) return -1;
       return slow.data;
    }
}