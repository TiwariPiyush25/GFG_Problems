/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    public boolean isSorted(Node head) {
        if(head==null || head.next==null) return true;
        
        Node slow=head;
        Node fast=head.next;
        boolean flag1=false;
        boolean flag2=false;
        
        if(slow.data<fast.data) flag1=true;
        if(slow.data>fast.data) flag2=true;
        while(fast!=null){
            if(flag1 && slow.data>fast.data) return false;
            if(flag2 && slow.data<fast.data) return false;
            
            slow=slow.next;
            fast=fast.next;
        }
        
        return true;
    }
}