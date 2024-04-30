import java.util.ArrayList;

public class binarytree3 {
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
    public static void klevel(node root,int level,int k ) {
        if (root==null) {
            return;
        }
        if (level==k) {
            System.out.print(root.data+" ");
            return;
        }
        klevel(root.left,level+1,k);
        klevel(root.right,level+1,k);
    }
    public static boolean getpath(node root,int n,ArrayList<node> path) {
       if (root==null) {
            return false;
       }
        path.add(root);
       if (root.data==n) {
        return true;
       }
       boolean foundleft=getpath(root.left, n, path);
       boolean foundright=getpath(root.right, n, path);

       if (foundleft||foundright) {
            return true;
       }
       path.remove(path.size()-1);
       return false;

    }
        public static void main(String[] args) {
        System.out.println("      1");
        System.out.println("   2      3");
        System.out.println(" 4   5  6   7");   
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.left = new node(6);
        root.right.right = new node(7);
        System.out.println("element at k level of binary tree are");
        klevel(root, 1, 3);
        System.out.println();
        // int n1=4 , n2=6;

        // System.out.println("lowest common ancestor of "+n1+" and "+n2+" = "+lowestcommonancestor(root, n1, n2).data);
        // System.out.println("lowest common ancestor of "+n1+" and "+n2+" = "+lca2(root, n1, n2).data);
        // System.out.println("Distance between nodes "+n1+" and "+n2+" = "+minddistancebtnodes(root, n1, n2));
    }
}
