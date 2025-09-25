/*
class Node
{
    int data;
    Node next;
}
*/

class Solution {
    public static void removeLoop(Node head) {
        Node slow=head;
        Node prev=null;
        Node fast=head;
        
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast) break;
        }
        
        if(slow==fast){
            Node temp=head;
            while(slow!=temp){
                prev=slow;
                slow=slow.next;
                temp=temp.next;
            }
            
            prev.next=null;
        }
    }
}