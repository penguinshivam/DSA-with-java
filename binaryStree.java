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

    public static boolean validbst(node root,node min ,node max){
        if (root==null){
            return true;
        }
        if (min!=null && root.data<=min.data) {
            return false;
        }
        else if (max!=null && root.data>=max.data) {
            return false;
        }
        return validbst(root.left,min,root)&&validbst(root.right,root,max);
    }

    public static node mirror(node root) {
        if (root== null) {
            return null;
        }
        node leftsubtree=mirror(root.left);
        node rightsubtree=mirror(root.right);
        root.left=rightsubtree;
        root.right=leftsubtree;
        return root;

    }

    public static void preorder(node root) {
        if (root== null) {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static node sortedarrtoBST(int arr[],int start,int end) {
        if (start>end) {
            return null;
        }
        int mid=(start+end)/2;
        node root=new node(arr[mid]);
        root.left=sortedarrtoBST(arr, start, mid-1);
        root.right=sortedarrtoBST(arr, mid+1,end );
        return root;
    }

    public static node sortedarrtoBST1(ArrayList<Integer> arr,int start,int end) {
        if (start>end) {
            return null;
        }
        int mid=(start+end)/2;
        node root=new node(arr.get(mid));
        root.left=sortedarrtoBST1(arr, start, mid-1);
        root.right=sortedarrtoBST1(arr, mid+1,end );
        return root;
    }

    public static node BSTtoBlanceBST(node root) {
        ArrayList<Integer> inorder=new ArrayList<>();
        getinorder(root,inorder);
        return sortedarrtoBST1(inorder, 0, inorder.size()-1);
    }

    public static void getinorder(node root,ArrayList<Integer> inorder) {
        if (root== null) {
            return;
        }
        getinorder(root.left,inorder);
        inorder.add(root.data);
        getinorder(root.right,inorder);
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
        delete(root, 4);
        inorder(root);
        printinrange(root, 1, 8);
        roottoleaf(root,new ArrayList<>());
        if (validbst(root, null, null)) {
            System.out.println("valid");
        }else{
            System.out.println("not valid");
        }
        System.out.println();
        root=mirror(root);
        preorder(root);
        System.out.println();
        System.out.println(" -------------****-------------");

        int value1[]={3,5,6,8,10,11,12};
        node root1=sortedarrtoBST(value1, 0, value1.length-1);
        preorder(root1);
        System.out.println();
        inorder(root1);
        System.out.println();
        node root3=new node(4);
        root3.left=new node(3);
        root3.right=new node(5);

        root3.left.left=new node(2);
        root3.right.right=new node(6);

        root3.left.left.left=new node(1);
        root3.right.right.right=new node(7);

        inorder(root3);
        System.out.println();
        preorder(root3);
        root3 =BSTtoBlanceBST(root3);
        System.out.println();
        inorder(root3);
        System.out.println();
        preorder(root3);
    }
}