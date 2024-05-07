public class RedBlackTree {
    public Node root;
    public RedBlackTree() {
        super();
        root = null;
    }
    class Node {
        int data;
        Node left;
        Node right;
        char colour;
        Node parent;
        Node(int data) {
            super();
            this.data = data; 
            this.left = null; 
            this.right = null; 
            this.colour = 'R'; 
            this.parent = null; 
        }
    }
    Node rotateLeft(Node node) {
        Node x = node.right;
        Node y = x.left;
        x.left = node;
        node.right = y;
        node.parent = x;
        if(y!=null)
            y.parent = node;
        return(x);
    }
    Node rotateRight(Node node) {
        Node x = node.left;
        Node y = x.right;
        x.right = node;
        node.left = y;
        node.parent = x;
        if(y!=null)
            y.parent = node;
        return(x);
    }
    
    boolean ll = false;
    boolean rr = false;
    boolean lr = false;
    boolean rl = false;
    
    Node insertHelp(Node root, int data) {
        boolean f=false;      
        if(root==null)
        return(new Node(data));
        else if(data<root.data) {
            root.left = insertHelp(root.left, data);
            root.left.parent = root;
        if(root!=this.root) {
            if(root.colour=='R' && root.left.colour=='R')
                f = true;
            }
        }
        else {
            root.right = insertHelp(root.right,data);
            root.right.parent = root;
            if(root!=this.root) {
                if(root.colour=='R' && root.right.colour=='R')
                    f = true;
                }
            }
        if(this.ll) {
            root = rotateLeft(root);
            root.colour = 'B';
            root.left.colour = 'R';
            this.ll = false;
        }
        else if(this.rr) {
            root = rotateRight(root);
            root.colour = 'B';
            root.right.colour = 'R';
            this.rr = false;
        }
        else if(this.rl) {
            root.right = rotateRight(root.right);
            root.right.parent = root;
            root = rotateLeft(root);
            root.colour = 'B';
            root.left.colour = 'R';
            this.rl = false;
        }
        else if(this.lr) {
            root.left = rotateLeft(root.left);
            root.left.parent = root;
            root = rotateRight(root);
            root.colour = 'B';
            root.right.colour = 'R';
            this.lr = false;
        }
        if(f) {
            if(root.parent.right == root) {
                if(root.parent.left==null || root.parent.left.colour=='B') {
                    if(root.left!=null && root.left.colour=='R')
                        this.rl = true;
                    else if(root.right!=null && root.right.colour=='R')
                        this.ll = true;
                }
                else {
                    root.parent.left.colour = 'B';
                    root.colour = 'B';
                    if(root.parent!=this.root)
                        root.parent.colour = 'R';
                }
            }
            else {
                if(root.parent.right==null || root.parent.right.colour=='B') {
                    if(root.left!=null && root.left.colour=='R')
                        this.rr = true;
                    else if(root.right!=null && root.right.colour=='R')
                        this.lr = true;
                }
                else {
                    root.parent.right.colour = 'B';
                    root.colour = 'B';
                    if(root.parent!=this.root)
                    root.parent.colour = 'R';
                }
            }
            f = false;
        }
        return(root);
    }
    public void insert(int data) {
        if(this.root==null) {
            this.root = new Node(data);
            this.root.colour = 'B';
        }
        else
            this.root = insertHelp(this.root,data);
    }
    void inorderTraversalHelper(Node node) {
        if(node!=null) {
            inorderTraversalHelper(node.left);
            System.out.printf("%d ", node.data);
            inorderTraversalHelper(node.right);
        }
    }
    public void inorderTraversal() {
        inorderTraversalHelper(this.root);
    }
    void printTreeHelper(Node root, int space) {
        int i;
        if(root != null) {
            space = space + 10;
            printTreeHelper(root.right, space);
            System.out.printf("\n");
            for ( i = 10; i < space; i++) {
                System.out.printf(" ");
            }
            System.out.printf("%d", root.data);
            System.out.printf("\n");
            printTreeHelper(root.left, space);
        }
    }
    public void printTree() {
        printTreeHelper(this.root, 0);
    }
    public static void main(String[] args) {
        RedBlackTree t = new RedBlackTree();
        int[] arr = {1, 4, 6, 3, 5, 7, 8, 2, 9};
        for(int i=0; i<9; i++) {
            t.insert(arr[i]);
            System.out.println();
            t.inorderTraversal();
        }
        t.printTree();
    }
}