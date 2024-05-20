public class tries {
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
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        return curr.endOfWord==true; 
    }
    
    public static void main(String[] args) {
        String words[]={"the","a","there","their","any","thee"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }   
        System.out.println(search("any"));
        System.out.println(search("an"));
    }
}