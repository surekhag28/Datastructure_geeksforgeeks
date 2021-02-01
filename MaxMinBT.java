import java.util.*;
import java.util.Scanner;
import java.util.HashMap;
import java.lang.Math;
    class Node
    {
        int data;
        Node left,right;
        Node(int d) {data = d; left =right= null; }
    }
		
public class GFG2
{
	public static void inorder(Node root)
	{
	    if(root==null)
	    return;
	    inorder(root.left);
	    System.out.print(root.data);
	    inorder(root.right);
	}
     /* Drier program to test above functions */
    public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 
		 while(t-->0)
         {
			int n = sc.nextInt();
			GFG2 llist=new GFG2();
			Node root=null,parent=null;
			HashMap<Integer, Node> m = new HashMap<>();
            for(int i=0;i<n;i++)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                char c=sc.next().charAt(0);
                if(m.containsKey(a)==false)
                {
                    parent=new Node(a);
                    m.put(a,parent);
                    if(root==null)
                    root=parent;
                }
                else
                    parent=m.get(a);
                Node child=new Node(b);
                if(c=='L')
                parent.left=child;
                else
                parent.right=child;
                m.put(b,child);
            }
            GFG obj = new GFG();
            int Max=obj.findMax(root);
            int Min=obj.findMin(root);
            System.out.println(Max+" "+Min);
		}
	}
}// } Driver Code Ends


/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

//Complete the findMax and findMin functions.
class GFG
{
    
    
	public static int findMax(Node root)
	{
	    if(root==null)
	        return Integer.MIN_VALUE;
	   
	    int max=root.data;
	    int lMax = findMax(root.left);
	    int rMax = findMax(root.right);
	    
	    if(lMax>max)
	        max=lMax;
	    if(rMax>max)
	        max=rMax;
	   
	   return max;
	}
	
	public static int findMin(Node root)
	{
	   if(root==null)
	        return Integer.MAX_VALUE;
	   
	    int min=root.data;
	    int lMin = findMin(root.left);
	    int rMin = findMin(root.right);
	    
	    if(lMin<min)
	        min=lMin;
	    if(rMin<min)
	        min=rMin;
	   
	   return min;
	}
}
