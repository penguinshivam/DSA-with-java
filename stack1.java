import java.util.*;


public class stack1 {

    static class stack{
        static ArrayList<Integer> list =new ArrayList<>();
        public boolean isEmpty(){
            return list.size()==0;
        }
        public void push(int data){
            list.add(data);
        }
        public int pop(){
            if (isEmpty()) {
                return -1;
            }
            int top =list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        public int peek(){
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size()-1);
        }
    }


    static class node{
        int data;
        node next;
        node (int data){
            this.data=data;
            this.next=null;
        }
    }
    static class stackll{
        static node head=null;
        public boolean isEmpty(){
            return head== null;
        }
        public void push(int data) {
            node newnode = new node(data);
            if (isEmpty()){
                head=newnode;
                return;
            }
            newnode.next=head;
            head=newnode;
        } 
        public  int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top=head.data;
            head=head.next;
            return top;
        }
        public int peek(){
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }

    public static void pushAtBottom(Stack<Integer>s,int data){
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top =s.pop();
        pushAtBottom(s,data);
        s.push(top);
        
    }

    public static String reverseString(String str){
        Stack<Character> s= new Stack<>();
        int idx=0;
        while (idx<str.length()) {
            s.push(str.charAt(idx));
            idx++;

            
        }
        StringBuilder result =new StringBuilder();
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s,top);
    }
    public static void printStack(Stack<Integer> s){
        
    }
    public static void main(String[] args) {

        // stack s1= new stackll();
        Stack<Integer> s1= new Stack<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        // pushAtBottom(s1, 4);
        // while (!s1.isEmpty()) {
        //     System.out.println(s1.peek());
        //     s1.pop();
        // }
        printStack(s1);
        reverseStack(s1);
        printStack(s1);
        
        // String str ="abc";
        // String result = reverseString(str);
        // System.out.println(result);

    }
}
