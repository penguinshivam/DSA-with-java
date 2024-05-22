public class countUniqueSubstrings {
    static class Node{
        Boolean endOfWord=false;
        Node children[]= new Node[26];
        Node(){
            for (int i = 0; i < 26; i++) {
                children[i]=null;
            }
        }
    }
    public static Node root = new Node();
    public static void insert(String word){
        Node curr= root;
        for (int level = 0; level < word.length(); level++) {
            int idx=word.charAt(level)-'a';
            if (curr.children[idx]==null) {
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.endOfWord=true;
    }
    public static boolean search(String word){
        Node curr= root;
        for (int level = 0; level < word.length(); level++) {
            int idx=word.charAt(level)-'a';
            if (curr.children[idx]==null) {
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.endOfWord==true; 
    }
    public static int countNode(Node root){
        if (root==null) {
            return 0 ;
        }
        int count =0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i]!=null) {
                count+=countNode(root.children[i]);
            }
        }
        return count+1;
    }
    public static void main(String[] args) {
        String str="ababa";
        for (int i = 0; i < str.length(); i++) {
            String suffix =str.substring(i);
            insert(suffix);
        }
        System.out.println(countNode(root));
    }
}
