public class binaryStree {
    static class node{
        int data;
        node left;
        node right;

        node(int data){
            this.data=data;
            this.left=null;
            this.right=null;

        }

    }
    public static node insert(node root , int val) {
        if (root==null) {
            node newnode = new node(val);
            return newnode;
        }
        if (root.data>val) {
            root.left=insert(root.left, val);
        }
        else{
            root.right=insert(root.right, val);
        }
        return root;
    }
    public static boolean search(node root, int val){
        if (root==null) {
            // System.out.println("false");
            return false;
        }
        if (root.data==val) {
            // System.out.println("true");
            return true;
        }
        if (root.data>val) {
            return search(root.left, val);
        }else{
            return search(root.right, val);
        } 
    }
    
    public static void inorder(node root) {
        if (root== null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        int value[]={5,1,3,4,2,7};
        node root=null;
        for (int i = 0; i < value.length; i++) {
            root=insert(root, value[i]);
        }
        inorder(root);
        System.out.println();
        if (search(root, 1)) {
            System.out.println("found");
        }else{
            System.out.println("not found");
        }
    }
}
