public class longWordWithAllPrefix {
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
    public static String ans="";

    public static void longestWord(Node root,StringBuilder temp){
        if (root==null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i]!=null&&root.children[i].endOfWord==true) {
                char ch=(char)(i+'a');
                temp.append(ch);
                if (temp.length()>ans.length()) {
                    ans=temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        String str[]={"a","banana","app","appl","ap","apply","apple"};
        for (int i = 0; i < str.length; i++) {
            insert(str[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);

    }
}
