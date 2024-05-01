import java.util.*;

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
    public static node lowestcommonancestor(node root,int n1,int n2) {
        ArrayList<node> path1= new ArrayList<>();
        ArrayList<node> path2= new ArrayList<>();
        getpath(root,n1,path1);
        getpath(root,n2,path2);
        int i=0;
        for (; i < path1.size() && 1<path2.size(); i++) {
            if (path1.get(i)!=path2.get(i)) {
                break;
            }
        }
        node lowestcommonancestor=path1.get(i-1);
        return lowestcommonancestor;
    }
    public static node lca2(node root,int n1,int n2) {
        if (root==null||root.data==n1||root.data==n2) {
            return root;
        }
        node leftlca=lca2(root.left, n1, n2);
        node rightlca=lca2(root.right, n1, n2);

        if (leftlca==null) {
            return rightlca;
        }
        if (rightlca==null) {
            return leftlca;
        }
        return root;
    }
    public static int lcadistance(node root,int n) {
        if (root==null) {
            return -1;
        }
        if (root.data==n) {
            return 0; 
        }
        int leftdis=lcadistance(root.left, n);
        int rightdis=lcadistance(root.right, n);
        if (leftdis==-1&&rightdis==-1) {
            return -1;
        }
        else if (leftdis == -1) {
            return rightdis+1;
        }
        else{
            return leftdis+1;
        }
    }
    public static int minddistancebtnodes(node root,int n1,int n2) {
        node lca =lca2(root, n1, n2);
        int dist1=lcadistance(lca,n1);
        int dist2=lcadistance(lca,n2);
        return dist1+dist2;
    }
    public static void kAncestorofnode(node root,int n,int k) {
        ArrayList<node> path1= new ArrayList<>();
        getpath(root,n,path1);
        int r =path1.size()-1-k;
        System.out.println(path1.get(r).data);
    }
    public static int kAncestorofnodeopt(node root,int n,int k) {
        
        if (root==null) {
            return -1;
        }
        if (root.data==n) {
            return 0;
        }
        int leftDist =kAncestorofnodeopt(root.left, n, k);
        int rightDist =kAncestorofnodeopt(root.right, n, k);
        if (leftDist==-1 &&rightDist==-1) {
            return -1;
        }
        int max = Math.max(leftDist, rightDist);
        if (max+1==k) {
            System.out.println(root.data);
        }
        return max+1;
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
        int n1=6 , n2=6;
        System.out.println("lowest common ancestor of "+n1+" and "+n2+" = "+lowestcommonancestor(root, n1, n2).data);
        System.out.println("lowest common ancestor of "+n1+" and "+n2+" = "+lca2(root, n1, n2).data);
        System.out.println("Distance between nodes "+n1+" and "+n2+" = "+minddistancebtnodes(root, n1, n2));
        kAncestorofnode(root, n1, 1);
        kAncestorofnodeopt(root, n1, 1);
    }
}
