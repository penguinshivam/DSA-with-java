// import java.util.*;

public class recursion {
// print factorial
    // public static int printdec(int n) {
    //     if (n==0) {
    //         return 1;
    //     }
    //     return (printdec(n-1)*n);
    // }

// print fibonacci series
    // public static void fib(int n) {
    //     for (int i = 0; i <n; i++) {
    //         System.out.println("Answer = "+func(i));
    //         }
    // }
    // public static int func(int n) {
    //     if (n<=1) {
    //         return n;
    //     }
    //     return func(n-1)+func(n-2);
    // }

// check the arr is sorted or not
    // public static boolean sorted(int arr[],int i) {
    //     if (i==arr.length-1) {
    //         return true;
    //     }
    //     if (arr[i]> arr[i+1])
    //     {
    //         return false;
    //     }
    //     return sorted(arr, i+1);
    // }

// first occurence
        // public static int firstoccurence (int arr[],int key,int i) {
        //     if (i==arr.length) {
        //         return -1;
        //     }
        //     if(arr[i]==key){
        //         return i;
        //     }
        //     return firstoccurence(arr, key, i+1);

        // }
// last occurence
    // public static int lastoccurence (int arr[],int key,int i) {
    //     if (i==0) {
    //         return -1;
    //     }
    //     if(arr[i]==key){
    //         return i;
    //     }
    //     return lastoccurence(arr, key, i-1);

    // }  
    
// print x^n
        // public static int pow(int x , int n) {
        //     if (n==0) {
        //         return 1;
        //     }
        //     return x*pow(x, n-1);
        // }
// 
        public static int pow(int x , int n) {
            if (n==0) {
                    return 1;
                }
            int halfpower=pow(x, n/2)*pow(x, n/2);
            if (n%2!=0){
                halfpower =x*halfpower;
            }
            return halfpower;
        }

    public static void main(String[] args) {
        // System.out.print("Enter the number :- ");
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt(); 
        // sc.close();
        // int n[]={1,3,4,2,2,6,1};
        // int i=n.length-1;
        // int f=firstoccurence(n,3,i);
        // System.out.println(f);
        System.out.println(pow(2,5));

        
        
    }
}
