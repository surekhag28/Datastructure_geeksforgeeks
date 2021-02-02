//Code by:Saksham Raj Seth
import java.util.*;
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}
class LL{
Node head;
Node tail;
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }
 public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t--> 0) {
            int n = sc.nextInt();
            LL llist = new LL();
			llist.head=null;
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }
			int value=sc.nextInt();
			Node phead=head;
			while(phead.next!=null){
				phead=phead.next;
			}
			phead.next=head;
            GfG g=new GfG();
			head = g.sortedInsert(head,value);
			Node current = head;
			
			if(head != null){
			    do{
			        System.out.print(current.data+" ");
			        current = current.next;
			    }while(current != head);
			}
			System.out.println();
        }
    }
}// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}*/
class GfG
{
	public static Node sortedInsert(Node head,int data)
    {
        Node node = new Node(data);
        Node curr=head;
        Node prev=null;
        
        if(curr.next==head){
            if(curr.data<data){
                curr.next=node;
                node.next=head;
            }else{
                node.next=head;
                head=node;
                curr.next=head;
            }
            return head;
        }
        
        while(curr.data<data && curr.next!=head){
            prev=curr;
            curr=curr.next;
        }
        
        if(curr.next==head){
            curr.next=node;
            node.next=head;
        }else if(curr==head){
            Node last=head;
            while(last.next!=head){
                last=last.next;
            }
            node.next=head;
            head=node;
            last.next=head;
        }else{
            prev.next=node;
            node.next=curr;
        }
        return head;
    }
}
