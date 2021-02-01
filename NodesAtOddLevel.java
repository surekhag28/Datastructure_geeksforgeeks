import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
class NodeAtOdd{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Node root=null;
            while(n-->0){
                int a=sc.nextInt();
                int a1=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(root==null){
                    root=new Node(a);
                    switch(lr){
                        case 'L':root.left=new Node(a1);
                        break;
                        case 'R':root.right=new Node(a1);
                        break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                }
            }
            GfG g=new GfG();
            g.nodeAtOdd(root);
            System.out.println();
        }
    }
    public static void insert(Node root,int a,int a1,char lr){
        if(root==null)
            return;
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new Node(a1);
                break;
                case 'R':root.right=new Node(a1);
                break;
            }
        }
        else{
            insert(root.left,a,a1,lr);
            insert(root.right,a,a1,lr);
        }
    }
}
// } Driver Code Ends


/*Complete the function below
Node is as follows
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}*/
class Pair{
    Node node;
    int level;

    Pair(){}

    Pair(Node node,int level){
        this.node=node;
        this.level=level;
    }
}

class GfG{
    public void nodeAtOdd(Node root)
     {
         if(root==null)
            return;
         Queue<Pair> q = new LinkedList<Pair>();
         
         q.add(new Pair(root,1));
         while(!q.isEmpty()){
            Pair p=q.poll();
            int l = p.level;
            
            if(l%2!=0)
                System.out.print(p.node.data+" ");
                
            if(p.node.left!=null){
                q.add(new Pair(p.node.left,l+1));
            }
            if(p.node.right!=null){
                q.add(new Pair(p.node.right,l+1));
            }
         }
     }
}
