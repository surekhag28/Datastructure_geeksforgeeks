class Tree{
    
    public int sumTree(Node root){
        if(root==null)
            return 0;
        
        int old_val = root.data;
        
        root.data = sumTree(root.left) + sumTree(root.right);
        return old_val+root.data;
    }
    
    public void toSumTree(Node root){
        sumTree(root);
    }
}
