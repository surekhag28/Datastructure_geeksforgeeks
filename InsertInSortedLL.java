
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	
    public static void main(String args[]) throws IOException { 
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
            int n = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Solution g = new Solution();
            head = g.sortedInsert(head,k);
            
            printList(head); 
            t--;
        }
    } 
} 
// } Driver Code Ends



/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

// sortedInsert method should return the head of the modified linked list.
class Solution {
    Node sortedInsert(Node head1, int key) {
        // Add your code here.
        
        if(head1==null){
            Node node = new Node(key);
            head1=node;
            return head1;
        }
        if(key<head1.data){
            Node node = new Node(key);
            node.next=head1;
            head1=node;
            return head1;
        }
        
        int flag=0;
        Node curr=head1;
        Node prev=head1;
        while(curr!=null){
            if(key<curr.data){
                Node node = new Node(key);
                node.next=prev.next;
                prev.next=node;
                flag=1;
                break;
            }else{
                prev=curr;
                curr=curr.next;
            }
        }
        if(flag==0 && curr==null){
            Node node = new Node(key);
            prev.next=node;
        }
        return head1;
    }
}
