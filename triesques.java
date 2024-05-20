public class triesques {
    static class Node{
        Boolean endOfWord=false;
        Node children[]= new Node[26];
        int fequency;
        public Node(){
            for (int i = 0; i < 26; i++) {
                children[i]=null;
            }
            fequency=1;
        }
    }
    public static Node root = new Node();
    public static void insert(String word){
        Node curr= root;
        for (int level = 0; level < word.length(); level++) {
            int idx=word.charAt(level)-'a';
            if (curr.children[idx]==null) {
                curr.children[idx]=new Node();
            }else{
                curr.children[idx].fequency++;
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
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        return curr.endOfWord==true; 
    }
    public static boolean wordBreakProblem(String key) {
        if (key.length()==0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0,i))&&wordBreakProblem(key.substring(i))) {
                return true;
            }
        }
        return false;
    }
    public static void prefixProb(Node root, String ans ){
        if (root==null) {
            return;
        }
        if (root.fequency==1) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i]!=null) {
                prefixProb(root.children[i], ans+(char)(i+'a'));
            }
        }
    }
    public static boolean startsWith(String prefix){
        Node curr= root;
        for (int level = 0; level < prefix.length(); level++) {
            int idx=prefix.charAt(level)-'a';
            if (curr.children[idx]==null) {
                return false;
            }
            curr=curr.children[idx];
        }
        return true; 
    } 
    public static void main(String[] args) {
        String words[]={"its","like","sama","samsung","mobile","ice"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        root.fequency=-1;
        String key = "ilikesamsung";
        System.out.println(wordBreakProblem(key));
        prefixProb(root," ");
        String prefix1="li";
        String prefix2="liff";
        System.out.println(startsWith(prefix1));
        System.out.println(startsWith(prefix2));
    }
}
