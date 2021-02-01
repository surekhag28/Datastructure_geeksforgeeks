//

import java.io.*;
import java.util.*;

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

class GfG
{
    static Scanner sc = new Scanner(System.in);
    
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        head = tail = new Node(val);
        
        size--;
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
    {
        int t = sc.nextInt();
        while(t-->0)
        {
            int n , m;
            
            n = sc.nextInt();
            Node head1 = inputList(n);
            
            m = sc.nextInt();
            Node head2 = inputList(m);
            
            Sol obj = new Sol();
            
            Node result = obj.findIntersection(head1, head2);
            
            printList(result);
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/* structure of list Node:

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

*/

class Sol
{
    public static Node findIntersection(Node head1, Node head2)
    {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        Node curr=head1;
        
        while(curr!=null){
            map.put(curr.data,map.getOrDefault(curr.data,0)+1);   
            curr=curr.next;
        }
        
        curr=head2;
        while(curr!=null){
            map.put(curr.data,map.getOrDefault(curr.data,0)+1);   
            curr=curr.next;
        }
        
        curr=head1;
        Node prev=head1;
        while(curr!=null){
            if(map.get(curr.data)>1){
                prev=curr;
                curr=curr.next;
            }else{
                if(curr==head1){
                    Node node=head1;
                    head1=head1.next;
                    curr=head1;
                    prev=head1;
                    node=null;
                }else{
                    Node node = curr;
                    curr=node.next;                
                    prev.next=curr;
                    node=null;
                }
            }
        }
        return head1;
    }
}
