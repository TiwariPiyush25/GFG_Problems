/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        Node slow = head;
        Node fast = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) break;
        }
        
        if(fast.next==null || fast.next.next==null) return 0;
        
        Node temp = head;
        while(temp != slow){
            slow = slow.next;
            temp = temp.next;
        }
        
        int len = 1;
        temp = temp.next;
        while(temp != slow){
            len++;
            temp = temp.next;
        }
        
        return len;
    }
}