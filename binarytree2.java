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
    static class info{
        int dia;
        int ht;
        public info(int dia,int ht){
            this.dia=dia;
            this.ht=ht;
        }
    }
    public static info optdiameter (node root) {
        if (root == null) {
            return new info(0, 0);
        }
        info leftsum = optdiameter(root.left);
        info rightsum = optdiameter(root.right);
        int selfdia=Math.max(Math.max(leftsum.dia, rightsum.dia), leftsum.ht+rightsum.ht+1);
        int ht=  Math.max(leftsum.ht,rightsum.ht)+1;
        return new info(selfdia, ht);
        
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
        System.out.println("height of the tree ="+height(root));
        System.out.println("number of nodes of the tree ="+numberofnode(root));
        System.out.println("sum of nodes the tree ="+sum(root));
        System.out.println("diameter of the tree ="+diameter(root));
        System.out.println("diameter of the tree ="+optdiameter(root).dia);
    }
}
