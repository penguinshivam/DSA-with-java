import java.util.*;
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
    public static node delete(node root,int val) {
        if (root.data>val) {
            root.left=delete(root.left, val);
        }else if(root.data<val){
            root.right= delete(root.right, val);
        }
        else{
            if (root.left == null && root.right==null) {
                return null;
            }

            if (root.left==null) {
                return root.right;
            }else if (root.right==null) {
                return root.left;
            }

            node id=findinodersuccessor(root.right);
            root.data =id.data;
            root.right=delete(root.right, id.data);
        } 
        return root;
    }
    public static node findinodersuccessor(node root) {
        while (root.left!=null) {
            root =root.left;
        }
        return root;
    }
    public static void printinrange(node root, int k1,int k2) {
        if (root==null) {
            return;
        }
        if (k1<=root.data && root.data <=k2) {
            printinrange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printinrange(root.right, k1, k2);
        }
        else if(root.data>k2){
            printinrange(root.right, k1, k2);
        }else  {
            printinrange(root.left, k1, k2);
            
        }

    }
    public static void roottoleaf(node root,ArrayList<Integer> path) {
        
        if (root==null){
            return;
        }
        path.add(root.data);
        if (root.left==null&&root.right==null) {
            for (int index = 0; index < path.size(); index++) {
                System.out.print(path.get(index)+"-->");
            }
            System.out.println("N");

        }
            roottoleaf(root.left,path);
            roottoleaf(root.right,path);
            path.remove(path.size()-1);
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
        int value[]={8,5,3,1,4,6,10,11,14};
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
        // delete(root, 4);
        // inorder(root);
        // printinrange(root, 1, 8);
        roottoleaf(root,new ArrayList<>());
    }
}
