import java.util.*;
public class IsValid {
    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();

        for( int i =0 ; i< str.length(); i++){
            char ch = str.charAt(i);
            //opening
            if( ch =='(' || ch == '{' || ch == '[' ){
                s.push(ch);
            }else{
                //closing
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek()=='('&& ch ==')')
                || (s.peek() == '{' && ch=='}')
                || (s.peek() == '[' && ch == ']')){
                    s.pop();

                }else{
                    return false;
                }

            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean DupisValid(String str){
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')') {
                int count=0;
                while (s.peek()!='(') {
                    s.pop();
                    count++;
                }
                if (count<1) {
                    return true;
                }else{
                    s.pop();
                }
            }else{
                s.push(ch);
            }
        }
        return false;
    }
public static void main(String args[]){
    String str = "((a+b))";
    String str1 = "(a+b)";
    System.out.println(DupisValid(str));
    System.out.println(DupisValid(str1));
}
}