import java.util.*;

public class recursion {
    public static int printdec(int n) {

        if (n==0) {
            return 1;
        }
        return (printdec(n-1)*n);
    }
    public static void main(String[] args) {
        System.out.print("Enter the number which factorial is to be calculated :- ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        sc.close();
        System.out.println("Answer = "+printdec(n));
    }
}
