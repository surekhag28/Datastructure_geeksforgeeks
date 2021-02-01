// driver code

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}

class GFG
{
    public static void makeLoop(Node head, Node tail, int x){
        if (x == 0) return;
        
        Node curr = head;
        for(int i=1; i<x; i++)
            curr = curr.next;
        
        tail.next = curr;
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = new Node(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = new Node(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, tail, pos);
            
            Solution x = new Solution();
            System.out.println( x.countNodesinLoop(head) );
        }
    }
}
// } Driver Code Ends


/*

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

//Function should return the length of the loop in LL.

class Solution
{
    static int countNodesinLoop(Node head)
    {

        int len=0;
        Node slow_p=head;
        Node fast_p=head;
        boolean flag=false;
        
        while(slow_p!=null && fast_p!=null && fast_p.next!=null){
            slow_p=slow_p.next;
            fast_p=fast_p.next.next;
            
            if(slow_p==fast_p){
                flag=true;
                break;
            }
        }
        
        if(flag){
            fast_p=head;
            while(slow_p!=fast_p){
                slow_p=slow_p.next;
                fast_p=fast_p.next;
            }
            
            slow_p=slow_p.next;
            len++;
            while(slow_p!=fast_p){
                slow_p=slow_p.next;
                len++;
            }
            return len;
        }
        return 0;
    }
}
