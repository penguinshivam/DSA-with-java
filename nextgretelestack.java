import java.util.*;
public class nextgretelestack {
    
    public static void main(String[] args) {
        int arr[]={6,8,0,1,3};
        int nextgrt[]=new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length-1; i >= nextgrt.length; i--) {
            while (!s.isEmpty() && arr[s.peek()]<=arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextgrt[i]=-1;

            }
            else{
                nextgrt[i]=arr[s.peek()];
            }
            s.push(i);
        }
        
        for (int index = 0; index < nextgrt.length; index++) {
            System.out.println(nextgrt[index]+" ");
        }
        System.out.println();
        
    }
    
}
