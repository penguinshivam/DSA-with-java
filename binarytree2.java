import java.util.*;
public class binarytree2 {
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
    public static int height(node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh)+1;
    }
    public static int numberofnode(node root) {
        if (root == null) {
            return 0;
        }
        int lh = numberofnode(root.left);
        int rh = numberofnode(root.right);
        return lh+rh+1;
    }
    static class enfo{
        int dia;
        int ht;
        public enfo(int dia,int ht){
            this.dia=dia;
            this.ht=ht;
        }
    }
    public static int sum (node root) {
        if (root == null) {
            return 0;
        }
        int leftsum = sum(root.left);
        int  rightsum = sum(root.right);
        return  leftsum + rightsum+root.data;

    }
    public static int diameter (node root) {
        if (root == null) {
            return 0;
        }
        int leftsum = diameter(root.left);
        int  rightsum = diameter(root.right);
        int leftht=height(root.left);
        int rightht=height(root.right);
        int selfdia=leftht+rightht+1;
        return  Math.max(selfdia, Math.max(leftsum, rightsum));
        
    }
    public static enfo optdiameter (node root) {
        if (root == null) {
            return new enfo(0, 0);
        }
        enfo leftsum = optdiameter(root.left);
        enfo rightsum = optdiameter(root.right);
        int selfdia=Math.max(Math.max(leftsum.dia, rightsum.dia), leftsum.ht+rightsum.ht+1);
        int ht=  Math.max(leftsum.ht,rightsum.ht)+1;
        return new enfo(selfdia, ht);
        
    }
    public static boolean issubtree(node root,node subroot) {
        if (root==null) {
            return false;
        }
        if (root.data==subroot.data) {
            if(isidentical(root,subroot)){
                return true;
            }
        }
        return issubtree(root.right, subroot)||issubtree(root.left, subroot);

    }
    public static boolean isidentical(node root,node subroot) {
        if (root==null&&root==null) {
            return true;
        }
        else if(root==null||subroot==null||root.data!=subroot.data){
            return false;
        }
        if (!isidentical(root.left, subroot.left)) {
            return false;
        }
        if (!isidentical(root.right, subroot.right)) {
            return false;
        }
        return true;

    }
    static class Info{
        node node;
        int hd;
    
        public Info(node node, int hd){
            this.node = node;
            this.hd = hd;
    
        }
    }
        public static void topView ( node root){
        // level order
            java.util.Queue<Info> q = new LinkedList<>();
            HashMap< Integer, node> map = new HashMap<>();
    
            int min = 0 , max = 0;
            q.add(new Info(root,0));
            q.add(null);
    
            while(!q.isEmpty()){
                Info curr = q.remove();
                if(curr == null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }
    
                else{if( !map.containsKey(curr.hd)){     //first time in my occuring
                     map.put(curr.hd, curr.node);
                }
    
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right, curr.hd+1));
                    max = Math.max(min, curr.hd+1);
                }}
            }
            System.out.print("topview of the tree = ");
            for( int i = min; i<=max;i++){
                System.out.print(map.get(i).data+" ");
            }
            System.out.println();
    
    
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

        node subroot = new node(3);
        subroot.left=new node(8);
        subroot.right=new node(7);
        System.out.println("height of the tree = "+height(root));
        System.out.println("number of nodes of the tree = "+numberofnode(root));
        System.out.println("sum of nodes the tree = "+sum(root));
        System.out.println("diameter of the tree = "+diameter(root));
        System.out.println("diameter of the tree = "+optdiameter(root).dia);
        System.out.println("subtree of the tree = "+issubtree(root, subroot));
        System.out.println("topview of the tree ");
        topView(root);
        topView(subroot);

    }
}
